package reflektion.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import com.maxmind.geoip.Country;
import com.maxmind.geoip.LookupService;
import database.MessageDaoImpl;


@RestController
public class ControllerApp {

	 String lang=new String();
	 
	 @Autowired
	 MessageDaoImpl repoMessage;

	// Endpoint #1
	@RequestMapping(value = "/reflektion/postMessage/{msg}", method = RequestMethod.POST)
	public @ResponseBody String post(HttpServletRequest request,
			@PathVariable("msg") String message) throws IOException {
	
		String ip = request.getLocalAddr();
	    this.lang = request.getHeader("accept_language");
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
	public @ResponseBody List<Message> get(@PathVariable("numOf") Integer numOf,
			@PathVariable("lang") String lang) {
		List<Message> message = repoMessage.findAll(numOf, lang);
		return message;
	
	}

}