package com.data.source;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TwitterRetriever {
	private static String getTwitterFeed(String username, String limit) {
		try {
        	String url = "https://api.twitter.com/1/statuses/user_timeline.json?"
        				 + "include_entities=true&include_rts=true&screen_name="
        				 + username + "&count=" + 10;
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(url);

            HttpResponse httpResponse = httpClient.execute(httpGet);
            HttpEntity httpEntity = httpResponse.getEntity();
            String result = EntityUtils.toString(httpEntity);
            return result;
        } catch(Exception e) {
        	return e.toString();
        }
	}
	
	public static List<TweetData> getTweets(String username, String limit) throws JSONException {
		JSONArray jsonArray = new JSONArray(getTwitterFeed(username, limit));
		List<TweetData> tweetData = new ArrayList<TweetData>();
		for (int i = 0; i < 1; i++) {
			JSONObject jsonObject = jsonArray.getJSONObject(i);
			tweetData.add(new TweetData(jsonObject));
		}
		
		return tweetData;
	}
}
