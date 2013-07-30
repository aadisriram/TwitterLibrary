package com.data.source;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Entities {
	private List<String> hashTags;
	private List<String> urls;
	private List<UserMentions> userMentions;
	
	public Entities(List<String> hashTags, List<String> urls,
			JSONArray userMentions) throws JSONException {
		super();
		this.hashTags = hashTags;
		this.urls = urls;
		List<UserMentions> userMentionsList = new ArrayList<UserMentions>();
		for(int i = 0; i < userMentions.length(); i++) {
			JSONObject userMentionsObject = userMentions.getJSONObject(i);
			userMentionsList.add(new UserMentions(userMentionsObject.getString("screen_name"), 
					                              userMentionsObject.getString("name"),
					                              userMentionsObject.getString("id_str")));
		}
		this.userMentions = userMentionsList;
	}

	public List<String> getHashTags() {
		return hashTags;
	}

	public void setHashTags(List<String> hashTags) {
		this.hashTags = hashTags;
	}

	public List<String> getUrls() {
		return urls;
	}

	public void setUrls(List<String> urls) {
		this.urls = urls;
	}

	public List<UserMentions> getUserMentions() {
		return userMentions;
	}

	public void setUserMentions(List<UserMentions> userMentions) {
		this.userMentions = userMentions;
	}
	
}
