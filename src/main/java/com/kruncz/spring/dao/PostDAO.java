package com.kruncz.spring.dao;

import java.util.List;

import com.kruncz.spring.model.Post;
import com.kruncz.spring.model.Users;


public interface PostDAO {
	
	public void save(Post post);
	
	public Post get(String Post);
	
	public List<Post> list();
	
	}

