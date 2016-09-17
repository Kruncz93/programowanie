package com.kruncz.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import com.kruncz.spring.dao.ContactDAO;
import com.kruncz.spring.model.Users;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;


public class ContactDAOImpl implements ContactDAO {
	private JdbcTemplate jdbcTemplate;
	
	public ContactDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void save(Users users) { 
			// insert
			String sql = "INSERT INTO users (username, password)"
						+ " VALUES (?, ?)";
			jdbcTemplate.update(sql, users.getUsername(),
					users.getPassword());
			
			String sql2 = "INSERT INTO user_roles (username, role)"
					+ " VALUES (?, ?)";
		jdbcTemplate.update(sql2, users.getUsername(), "ROLE_USER");
		}
		
	@Override
	public void delete(int id) {
		String sql = "DELETE FROM users WHERE user_id=?";
		jdbcTemplate.update(sql, id);
	}
	
	@Override
	public List<Users> list() {
		String sql = "SELECT * FROM users";
		List<Users> listUsers = jdbcTemplate.query(sql, new RowMapper<Users>() {

			@Override
			public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
				Users aContact = new Users();
	
				aContact.setUsername(rs.getString("username"));
				aContact.setPassword(rs.getString("password"));
				aContact.setEnabled(rs.getInt("enabled"));
				
				return aContact;
			}
			
		});
		
		return listUsers;
	}
	
	@Override
	public void saveImg(Users users)
	{
	String sql = "UPDATE users SET image = ? WHERE username = ?";
	jdbcTemplate.update(sql, users.getImage(), users.getUsername());
	}

	@Override
	public Users get(String username) {
		String sql = "SELECT * FROM users WHERE username=" + username;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Users>() {

			@Override
			public Users extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					Users contact = new Users();
					contact.setUsername(rs.getString("username"));
					contact.setPassword(rs.getString("password"));
					contact.setEnabled(rs.getInt("enabled"));
					return contact;
				}
				
				return null;
			}
			
		});
	}

}
