package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import controller.Message;

@Repository
public class MessageDaoImpl implements MessageDao {
	
	private static final int MAXIMUM = 10;

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(
			NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	public void save(Message message) {
		// create query
		String query = "INSERT INTO message (text, lang, data, country) VALUES (:text, :lang, :data, :country);";

		// set query parameters
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("text", message.getText());
		params.put("lang", message.getLang());
		params.put("data", message.getData());
		params.put("country", message.getCountry());

		// execute query
		namedParameterJdbcTemplate.update(query, params);
	}

	@Override
	public List<Message> findAll(int numOf, String lang) {

		Map<String, Object> params = new HashMap<String, Object>();

		String sql = "SELECT * FROM message WHERE :lang='all' OR :lang = message.lang ORDER BY data DESC LIMIT :limit";

		// set query parameters
		
		params.put("limit", numOf > 0 ? numOf : MAXIMUM);
		params.put("lang", lang);

		List<Message> result = namedParameterJdbcTemplate.query(sql, params,
				new MessageMapper());

		return result;

	}

	private static final class MessageMapper implements RowMapper<Message> {

		public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
			Message msg = new Message();
			msg.setId(rs.getInt("id"));
			msg.setText(rs.getString("text"));
			msg.setLang(rs.getString("lang"));
			Calendar data = Calendar.getInstance();
			data.setTimeInMillis(rs.getTimestamp("data").getTime());
			msg.setData(data);
			msg.setCountry(rs.getString("country"));
			return msg;

		}
	}

}