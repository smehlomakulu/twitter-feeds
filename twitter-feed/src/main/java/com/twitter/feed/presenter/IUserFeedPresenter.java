 package com.twitter.feed.presenter;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface IUserFeedPresenter {
	
	public void initialise(String userPath, String tweetsPath) throws FileNotFoundException,
	  																  IOException,Exception;
	
	public void presentFeeds();

}
