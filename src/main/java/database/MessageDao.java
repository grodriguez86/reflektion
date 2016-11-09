package database;

import java.util.List;

import reflektion.test.Message;

public interface MessageDao {


	List<Message> findAll(int numOf, String lang);


}