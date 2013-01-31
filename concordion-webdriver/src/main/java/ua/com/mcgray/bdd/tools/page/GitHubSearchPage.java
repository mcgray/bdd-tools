package ua.com.mcgray.bdd.tools.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created with IntelliJ IDEA.
 * User: orezchykov
 * Date: 10.10.12
 * Time: 16:28
 * To change this template use File | Settings | File Templates.
 */
public class GitHubSearchPage extends Page {

    public static final String URL = "http://github.com/search";

    @FindBy(name = "q")
    private WebElement searchField;

    @Override
    public String getUrl() {
        return URL;
    }

    public GitHubSearchPage(WebDriver webDriver) {
        super(webDriver);
    }


    public void searchFor(String user) {
        searchField.sendKeys(user);
        searchField.sendKeys(Keys.RETURN);
    }


}
