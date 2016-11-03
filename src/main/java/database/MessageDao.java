package database;

import java.util.List;

import reflektion.test.Message;

public interface MessageDao {

	Message findById(Integer id);
	
	List<Message> findAll(Integer n, String lang);


}