package com.twitter.feed.app;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.log4j.Logger;

import com.twitter.feed.presenter.IUserFeedPresenter;
import com.twitter.feed.presenter.UserFeedPresenter;


public class TwitterFeedApp {
	
	private static final Logger log = Logger.getLogger(TwitterFeedApp.class);
	
    public static void main( String[] args ){
    	log.info("Running main appliation...");
    	
    	String userFilePath = args[0];
    	log.debug("Twitter user file path: "+userFilePath);
    	String feedsFilePath = args[1];
    	log.debug("Twitter feeds file path: "+feedsFilePath);
    	
    	IUserFeedPresenter feedPresenter = new UserFeedPresenter();
    	try {
			feedPresenter.initialise(userFilePath, feedsFilePath);
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
