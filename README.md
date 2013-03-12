bdd-tools
=========

A playground for the Java [BDD](http://http://en.wikipedia.org/wiki/Behavior-driven_development) Tools and [Selenium Webdriver](http://http://docs.seleniumhq.org/projects/webdriver/) based frameworks.

There are three maven projects using different BDD tools performing the similar UI test.

Test steps:


 1. Find a user with a nickname mcgray on a using GitHub search
 2. Proceed to the user profile page
 3. Search for the **bdd-tools** repository on the user public repository list
 4. Proceed to **bdd-tools** repository
 5. After that each particular project traverses to the test file and searches for the _hidden treasure_ text inside the test text. 

Concordion-Webdriver
----------------------------------
[Concordion](http://http://www.concordion.org/) is a simple BDD tool which uses HTML files which are instrumented with special attributes as test scenarios. To create a test you need to create an HTML story file and a JUnit test (Concordion runner is used) with the same name but with *Test suffix. After the test execution Concordion creates an HTML result file which is your story file with highlighted test execution results. For more details, please see [Concordion documentation](http://www.concordion.org/Tutorial.html).

Plain vanilla Webdriver with [Page Object pattern](http://code.google.com/p/selenium/wiki/PageObjects) is used for the first example project. No step abstraction introduced.
The thing worth mentioning here is a custom _Predicate_ to wait until jQuery done with Ajax:
```java
protected void waitForAjax() throws InterruptedException {
        new WebDriverWait(getWebDriver(), SHORT_WAIT_IN_MILISEC).until(new Predicate<WebDriver>() {
            @Override
            public boolean apply(final WebDriver input) {
                return (Boolean) ((JavascriptExecutor) input).executeScript(
                        "return window.jQuery.active == 0");
            }
        });
    }
```
    
    
 

You can run the test using _maven_:

`mvn clean test`

Or using your favorite _IDE_ (in this case you should set the `webdriver.chrome.driver` the location of your Chrome Driver and `concordion.output.dir` if you want to specify the place where to put test result)

Thucydides-JBehave
----------------------
[JBehave](http://) is well-known and widely used BDD implementation for Java which uses plain text scenario files and map them to Java classes using **@Given, @When, @Then** annotations.

[Thucydides](http://) is an acceptance testing framework. 

To start with using both frameworks I recommend to create a maven project from thucydides-jbehave archetype. It is updated quite frequently and will save you a lot of time setting up the project.
`mvn archetype:generate` - archetype number 191.

To run test using _maven_:

`mvn clean integration-test site`

To run using IDE (in this case Thucydides will not generate results because it uses maven site plugin)  - run the StoryRunner

**To be continued**

Cucumber-JVM-Html-Elements
--------------------------
Cucumber-JVM is a Cucumber implementation for Java. ( Cucumber is a canonical BDD tool designed for Ruby)

Html-Elements is a framework designed by Yandex and built to be used with Webdriver tests.

**To be continued**