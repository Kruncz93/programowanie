package com.kruncz.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import com.kruncz.spring.model.Post;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;


public class PostDAOImpl implements PostDAO {
	private JdbcTemplate jdbcTemplate;
	
	public PostDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void save(Post post) { 
			// insert
			String sql = "INSERT INTO post (post_id, username, topic, text)"
						+ " VALUES (?, ?, ?, ?)";
			jdbcTemplate.update(sql, post.getId(),
					post.getUsername(), post.getTopic(), post.getText());
		}
		
	@Override
	public List<Post> list() {
		String sql = "SELECT * FROM post";
		List<Post> listPosts = jdbcTemplate.query(sql, new RowMapper<Post>() {

			@Override
			public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
				Post aContact = new Post();
				aContact.setId(rs.getInt("post_id"));
				aContact.setUsername(rs.getString("username"));
				aContact.setTopic(rs.getString("topic"));
				aContact.setText(rs.getString("text"));
				
				return aContact;
			}
			
		});
		
		return listPosts;
	}

	@Override
	public Post get(String username) {
		String sql = "SELECT * FROM post WHERE username=" + username;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Post>() {

			@Override
			public Post extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					Post post = new Post();
					post.setId(rs.getInt("post_id"));
					post.setUsername(rs.getString("username"));
					post.setTopic(rs.getString("topic"));
					post.setText(rs.getString("text"));
					return post;
				}
				
				return null;
			}
			
		});
	}

}
