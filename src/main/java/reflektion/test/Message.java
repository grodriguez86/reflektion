package reflektion.test;

import java.util.Date;


public class Message {
	
	private Integer id;
	private String lang;
	private String text;
	private Date data;
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
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	public String getCountry() {
		
		return this.country;
	
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Message [id="+ id + ", text=" + text + ", lang=" + lang + ", date=" + data.toString() +  ", country=" + country +"]";
	}

}
