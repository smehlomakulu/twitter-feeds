This is the solution to the assessment provided.

1. Usage

The app can simply be ran via the below command
	 arg[0] = path to the user.txt file
	 arg[1] = path to the tweet.txt file
	 java -jar twitter-feed-jar-with-dependencies.jar arg[0] arg[1]
	 
Before running the jar, a folder with data source filed, namely user has to be created.
The current structure is /twitter/feeds/user.txt and /twitter/feeds/tweet.txt. In addition, the project makes use of maven for dependency management,
therefore, a mvn clean install would have to be executed before, to build the jar. For logging
a folder stucture of /twitter/feeds/logs/ has to be created. 

Language Choice and plugins/libs

Java 1.8 is the main language used.

Libraries/plugins:
 
maven3.5
log4j
JUnit