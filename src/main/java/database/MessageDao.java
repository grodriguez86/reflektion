package database;

import java.util.List;

import controller.Message;

public interface MessageDao {


	List<Message> findAll(int numOf, String lang);
	void save(Message message);


}