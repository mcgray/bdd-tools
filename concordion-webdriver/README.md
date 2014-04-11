Before running the test you will need to download [ChromeDriver](https://code.google.com/p/chromedriver/) implementation for your OS  
and update the pom.xml/build.gradle `webdriver.chrome.driver` property with this path.
To run the tests use:    
        `mvn clean test`
Or use (no Gradle installation required):
        `./gradlew clean test`

Or directly from your IDE (not forgetting to set env variables from pom.xml/build.gradle file).