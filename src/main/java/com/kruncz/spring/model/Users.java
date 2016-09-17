package com.kruncz.spring.model;

public class Users {
	private int id;
	private Byte [] image;
	private String username;
	private String password;
	private int enabled;

	public Users() {
	}

	public Users(String username, String password) {
		this.username = username;
		this.password = password;
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Byte [] getImage() {
		return image;
	}

	public void setImage(Byte [] image) {
		this.image = image;
	}
}
