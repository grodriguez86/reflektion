package controller;

import java.util.Calendar;
import com.fasterxml.jackson.annotation.JsonFormat;


public class Message {
	
	private Integer id;
	private String lang;
	private String text;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Argentina/Buenos_Aires")
	private Calendar data;
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
	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
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
