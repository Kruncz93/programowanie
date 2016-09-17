package com.kruncz.spring.model;

public class Post {
	private int id;
	private String username;
	private String topic;
	private String text;

	public Post() {
	}

	public Post(String username, String topic, String text) {
		this.username = username;
		this.setTopic(topic);
		this.setText(text);
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
