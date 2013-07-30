package com.data.source;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TweetData {

	private String tweetText;
	private boolean isFavorited;
	private boolean isRetweeted;
	private int retweet_count;
	private int favorite_count;
	private Entities entities;

	public TweetData(JSONObject jsonTweet) throws JSONException {
		createTweetData(jsonTweet.getString("text"), jsonTweet.getBoolean("favorited"),
				  jsonTweet.getBoolean("retweeted"), jsonTweet.getInt("retweet_count"),
				  jsonTweet.getInt("favorite_count"),jsonTweet.getJSONObject("entities"));
	}

	private void createTweetData(String tweetText, boolean isFavorited,
			boolean isRetweeted, int retweet_count, int favorite_count,
			JSONObject entities) throws JSONException {
		this.tweetText = tweetText;
		this.isFavorited = isFavorited;
		this.isRetweeted = isRetweeted;
		this.retweet_count = retweet_count;
		this.favorite_count = favorite_count;
		List<String> hashTags = new ArrayList<String>();
		List<String> urls = new ArrayList<String>();
		JSONArray hashTag = entities.getJSONArray("hashtags");
		JSONArray url = entities.getJSONArray("urls");
		
		for(int i = 0; i < hashTag.length(); i ++ ) {
			hashTags.add(hashTag.getJSONObject(i).getString("text"));
		}
		
		for(int i = 0; i < url.length(); i ++ ) {
			urls.add(url.getJSONObject(i).getString("url"));
		}
		
		this.entities = new Entities(hashTags, urls,
				                     entities.getJSONArray("user_mentions"));
	}

	public String getTweetText() {
		return tweetText;
	}

	public void setTweetText(String tweetText) {
		this.tweetText = tweetText;
	}

	public boolean isFavorited() {
		return isFavorited;
	}

	public void setFavorited(boolean isFavorited) {
		this.isFavorited = isFavorited;
	}

	public boolean isRetweeted() {
		return isRetweeted;
	}

	public void setRetweeted(boolean isRetweeted) {
		this.isRetweeted = isRetweeted;
	}

	public int getRetweet_count() {
		return retweet_count;
	}

	public void setRetweet_count(int retweet_count) {
		this.retweet_count = retweet_count;
	}

	public int getFavorite_count() {
		return favorite_count;
	}

	public void setFavorite_count(int favorite_count) {
		this.favorite_count = favorite_count;
	}

	public Entities getEntities() {
		return entities;
	}

	public void setEntities(Entities entities) {
		this.entities = entities;
	}
}
