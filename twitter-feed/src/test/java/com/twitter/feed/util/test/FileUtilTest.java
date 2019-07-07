package com.twitter.feed.util.test;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.twitter.feed.util.FileUtil;

public class FileUtilTest {
	
	private String userPath = "";
	private String tweets = "";
	
	@Before
	public void init(){
		userPath = "/twitter/feeds/user.txt";
		tweets = "/twitter/feeds/tweet.txt";
	}
	
	@Test
	public void testLoadUsers() {
		try {
			assertNotNull("User load check", FileUtil.loadUsers(userPath));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testLoadTweets() {
		try {
			assertNotNull("Tweets load check", FileUtil.loadFeeds(tweets));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
