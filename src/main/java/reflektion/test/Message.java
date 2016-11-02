package reflektion.test;

import java.util.Date;

public class Message {
	
	private String lang;
	private String text;
	private Date date;
	private String country;

	
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getCountry() {
		
		return this.country;
	
	}
	public void setCountry(String country) {
		this.country = country;
	}

	

}
