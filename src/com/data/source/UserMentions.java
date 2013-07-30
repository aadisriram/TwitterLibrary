package com.data.source;

public class UserMentions {
	private String screen_name;
	private String name;
	private String user_id;
	
	public UserMentions(String screen_name, String name, String user_id) {
		super();
		this.screen_name = screen_name;
		this.name = name;
		this.user_id = user_id;
	}

	public String getScreen_name() {
		return screen_name;
	}

	public void setScreen_name(String screen_name) {
		this.screen_name = screen_name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
}
