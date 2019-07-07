package com.twitter.feed.app.test;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.twitter.feed.presenter.IUserFeedPresenter;
import com.twitter.feed.presenter.UserFeedPresenter;

public class TwitterFeedTest {
	
	private static final Logger log = Logger.getLogger(TwitterFeedTest.class);
	private String userPath = "";
	private String tweets = "";
	
	@Before
	public void init(){
		userPath = "/twitter/feeds/user.txt";
		tweets = "/twitter/feeds/tweet.txt";
	}
	
	@Test
	public void testFeeds() {
		IUserFeedPresenter feedPresenter = new UserFeedPresenter();
    	try {
			feedPresenter.initialise(userPath, tweets);
			feedPresenter.presentFeeds();
    	}catch(FileNotFoundException  fnf){
    		log.error("FileNotFound Exception has occured", fnf);
		}catch(IOException io){
			log.error("I/O Exception occured!",io);
		}catch(Exception e){
			log.error("An Exception has occured",e);
		}
	}

}
