package com.twitter.feed.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class AbstractUserFeed {
	
	private Map<String, Set<String>> follows = null;
	private Map<String, List<String>> feeds = null;
	
	public AbstractUserFeed(){}
	
	protected AbstractUserFeed(Map<String, Set<String>> following, 
							Map<String, List<String>> feeds){
		this.follows = following;
		this.feeds = feeds;
		
	}
	
	protected final Map<String, Set<String>> getFollows(){
		return follows;
	}
	
	protected final Map<String, List<String>> getFeeds(){
		return feeds;
	}
	
	protected abstract String buildFeeds();
}
