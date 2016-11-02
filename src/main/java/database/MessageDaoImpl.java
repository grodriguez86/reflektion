package database;

import java.sql.ResultSet;
import java.sql.SQLException;
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
	
	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
	@Override
	public Message findById(Integer id) {
		
		Map<Integer, Object> params = new HashMap<Integer, Object>();
        params.put("id", id);
        
		String sql = "SELECT * FROM users WHERE name=:name";
		
        Message result = namedParameterJdbcTemplate.queryForObject(
                    sql,
                    params,
                    new MessageMapper());
                    
        //new BeanPropertyRowMapper(Customer.class));
        
        return result;
        
	}

	@Override
	public List<Message> findAll() {
		
		Map<String, Object> params = new HashMap<String, Object>();
		
		String sql = "SELECT * FROM users";
		
        List<Message> result = namedParameterJdbcTemplate.query(sql, params, new MessageMapper());
        
        return result;
        
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