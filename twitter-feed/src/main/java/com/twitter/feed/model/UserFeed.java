package com.twitter.feed.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserFeed extends AbstractUserFeed implements Comparator<UserFeed>{
	
	private String user = null;
	private Set<String> following = new HashSet<String>();
	private List<String> myFeeds = new ArrayList<String>();
	
	public UserFeed(){}
	
	public UserFeed(Map<String, Set<String>> following,
					Map<String, List<String>> feeds, String user, 
					Set<String> follows, List<String> myFeeds) {
		super(following, feeds);
		setUser(user);
		setFollowing(follows);
		setMyFeeds(myFeeds);
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Set<String> getFollowing() {
		return following;
	}

	public void setFollowing(Set<String> following) {
		this.following = following;
	}

	public List<String> getMyFeeds() {
		return myFeeds;
	}

	public void setMyFeeds(List<String> myFeeds) {
		this.myFeeds = myFeeds;
	}

	@Override
	protected String buildFeeds() {
		StringBuilder sb = new StringBuilder(); 
		sb.append(user);
		sb.append("\n");		
		
		for(String feed : myFeeds){
			if(following.size() > 0 || myFeeds.size() > 0){
				sb.append("\t");
			}
			sb.append("@"+user+": "+feed);
			sb.append("\n");
		}
		
		for(String userFollowed : following){
			List<String> followFeed = getFeeds().get(userFollowed) != null 
									  ? getFeeds().get(userFollowed) : new ArrayList<String>();
			for(String feed : followFeed){
				sb.append("\t");
				sb.append("@"+userFollowed+": "+feed);
				sb.append("\n");
			}
		}
		return sb.toString();
	}

	@Override
	public int compare(UserFeed uf1, UserFeed uf2) {
		return uf1.getUser().compareTo(uf2.getUser());
	}
	
	@Override
	public String toString(){
		return buildFeeds();
	}

}
