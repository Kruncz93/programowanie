package com.kruncz.spring.dao;

import java.util.List;

import com.kruncz.spring.model.Users;


public interface ContactDAO {
	
	public void save(Users users);
	
	public void saveImg(Users users);
	
	public Users get(String username);
	
	public List<Users> list();
	
	public void delete(int id);
}
