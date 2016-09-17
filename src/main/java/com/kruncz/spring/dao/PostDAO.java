package com.kruncz.spring.dao;

import java.util.List;

import com.kruncz.spring.model.Post;


public interface PostDAO {
	
	public void save(Post post);
	
	public Post get(String Post);
	
	public List<Post> list();
	}

