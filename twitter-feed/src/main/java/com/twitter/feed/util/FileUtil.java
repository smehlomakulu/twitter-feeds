package com.twitter.feed.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;


public class FileUtil {
	
	private final static Logger log = Logger.getLogger(FileUtil.class.getName());
	
	public static Map<String, Set<String>> loadUsers(String path) throws FileNotFoundException,
																		 IOException,
																		 Exception{
		Map<String, Set<String>> users = new HashMap<String, Set<String>>();
		Set<String> follows = null;
				
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			String text = null;
			while((text = br.readLine()) != null){
				
				if(text.contains(",")){
					String preText = text.substring(0, text.indexOf(","));
					String tempText = text.substring(text.indexOf(",")).replaceAll("\\s", "");
					text = preText.concat(tempText);
				}
				follows = new HashSet<String>();
				String[] line = text.split("\\s");
				String user = line[0];
				
				log.debug("User: ["+user+"]");
				log.debug("follows: ["+line[2]+"]");
				
				if(line[2].contains(",")){
					String[] following = line[2].split(",");
					for(String followed: following){
						follows.add(followed);
					}
				}else{
					follows.add(line[2]);
				}
				 
				if(users.containsKey(user)){
					Set<String> tempFollows = users.get(user);
					follows.addAll(tempFollows);
					users.put(user, follows);
				}else{
					users.put(user, follows);
				}
			}
			
			Collection<Set<String>> values = users.values();
			Iterator<Set<String>> itr = values.iterator();
			
			while(itr.hasNext()){
				if(itr.next() != null){
					Set<String> value = itr.next();
					for(String valueSet : value){
						if(users.containsKey(valueSet)){
							continue;
						}else{
							users.put(valueSet, new HashSet<String>());
						}
						
					}
				}
			}
			
		}catch(FileNotFoundException  fnf){
			log.error("An Exception has occured", fnf);
			throw new FileNotFoundException("FileNotFound Exception has occured");
		}catch(IOException io){
			log.error("I/O Exception occured!",io);
			throw new IOException("I/O Exception occured!",io);
		}catch(Exception e){
			log.error("An Exception has occured",e);
			throw new Exception("An Exception has occured", e);
		}
		return users;
	}
	
	public static Map<String, List<String>> loadFeeds(String path) throws FileNotFoundException,
																		  IOException,
																		  Exception{
		
		Map<String, List<String>> userFeeds = new HashMap<String, List<String>>();
		List<String> feeds = null;
		
		try(BufferedReader bf = new BufferedReader(new FileReader(path))){
			
			String text = null;
			while((text = bf.readLine()) != null){
				feeds = new ArrayList<String>();
				String[] line = text.split(">");
				String user = line[0];
				String feed = line[1].trim();
				
				log.debug("User: ["+user+"] - Feed: ["+feed+"]");
				if(userFeeds.containsKey(user)){
					feeds = userFeeds.get(user);
					feeds.add(feed);
					userFeeds.put(user, feeds);
				}else{
					feeds.add(feed);
					userFeeds.put(user, feeds);
				}
			}
		}catch(FileNotFoundException  fnf){
			log.error("An Exception has occured", fnf);
			throw new FileNotFoundException("File Not Found Exception has occured");
		}catch(IOException io){
			log.error("I/O Exception occured!",io);
			throw new IOException("I/O Exception occured!",io);
		}catch(Exception e){
			log.error("An Exception has occured",e);
			throw new Exception("An Exception has occured", e);
		}
		return userFeeds;
	}

}
