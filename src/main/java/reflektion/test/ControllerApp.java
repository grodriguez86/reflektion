package reflektion.test;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import javax.servlet.http.HttpServletRequest;

import com.maxmind.geoip.Country;
import com.maxmind.geoip.Location;
import com.maxmind.geoip.LookupService;
import com.maxmind.geoip.regionName;

@RestController
public class ControllerApp {

	private Hashtable<String, String> messages = new Hashtable<String, String>();

	// @RequestMapping("/")
	// String home() {
	// return "Hello from the Controller!";
	// }
	//
	// public static void main(String[] args) throws Exception {
	// SpringApplication.run(ControllerApp.class, args);
	// }

	// Endpoint #1

	@RequestMapping(value = "/reflektion/postMessage/{msg}", method = RequestMethod.GET)
	public @ResponseBody String post(HttpServletRequest request,
			@PathVariable("msg") String message) throws IOException {
		// TODO

		String ip = request.getLocalAddr();
		String lang = request.getHeader("accept_language");
		File datafile = new File("./GeoIP.dat");
		LookupService lookup = new LookupService(datafile,
				LookupService.GEOIP_MEMORY_CACHE);
		Country geoip_country = lookup.getCountry(ip);
		String country = "Country Not Found";
		if (geoip_country != null)
			country = geoip_country.getName();
		return message + " from " + country;
	}

	// Endpoint #2
	@RequestMapping(value = "/reflektion/getMessages", method = RequestMethod.GET)
	public @ResponseBody String get(@PathVariable("numOf") Integer numOf,
			@PathVariable("lang") String lang) {


		return null;
	}

}