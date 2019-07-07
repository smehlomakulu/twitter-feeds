package com.twitter.feed.presenter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.twitter.feed.model.UserFeed;
import com.twitter.feed.util.FileUtil;

public class UserFeedPresenter implements IUserFeedPresenter{
	
	private Map<String, Set<String>> userFollow = null;
	private Map<String, List<String>> userFeeds = null;
	private List<UserFeed> feeds = new ArrayList<UserFeed>();
	private UserFeed user = null;

	@Override
	public void initialise(String userPath, String tweetsPath) throws FileNotFoundException,
																	  IOException,
																	  Exception {
		userFollow = FileUtil.loadUsers(userPath);
		userFeeds = FileUtil.loadFeeds(tweetsPath);
		
		Set<String> keys = userFollow.keySet();
		for(String key : keys){
			List<String> feed = userFeeds.get(key) != null ? userFeeds.get(key) : new ArrayList<String>();
			user = new UserFeed(userFollow, userFeeds, key, 
								userFollow.get(key), feed);
			feeds.add(user);
		}
		
	}

	@Override
	public void presentFeeds() {
		
		Collections.sort(feeds, new UserFeed());
		for(UserFeed userFeed : feeds){
			System.out.println(userFeed.toString());
		}
	}

}
