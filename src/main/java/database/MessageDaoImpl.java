package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import reflektion.test.Message;

@Repository
public class MessageDaoImpl implements MessageDao {

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	Integer M = new Integer(0);

	@Autowired
	public void setNamedParameterJdbcTemplate(
			NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public List<Message> findAll(Integer numOf, String lang) {

		Map<String, Object> params = new HashMap<String, Object>();

		String sql_M = "SELECT * FROM message";

		List<Message> messages = namedParameterJdbcTemplate.query(sql_M,
				params, new MessageMapper());

		M = messages.size(); // CANTIDAD MAXIMA DE MENSAJES

		if (numOf.intValue() <= M.intValue()) {

			String sql = "SELECT * FROM message WHERE (?2='all' OR ?2 = message.lang) ORDER BY data DESC)";

			List<Message> result = namedParameterJdbcTemplate.query(sql,
					params, new MessageMapper());

			return result;
		} else
		{
			List<Message> result = new ArrayList<Message>();
			Message msg = new Message();
			msg.setCountry(null);
			msg.setData(null);
			msg.setId(null);
			msg.setLang(null);
			msg.setText("Max number of messages has been achieved");
			result.add(msg);
			return result;
		}

	}

	private static final class MessageMapper implements RowMapper<Message> {

		public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
			Message msg = new Message();
			msg.setId(rs.getInt("id"));
			msg.setText(rs.getString("text"));
			msg.setLang(rs.getString("lang"));
			msg.setData(rs.getDate("date", new GregorianCalendar()));
			msg.setCountry(rs.getString("country"));
			return msg;

		}
	}

}