package ua.com.mcgray.bdd.tools.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created with IntelliJ IDEA.
 * User: orezchykov
 * Date: 10.10.12
 * Time: 23:02
 * To change this template use File | Settings | File Templates.
 */
public class GitHubSearchResultPage extends Page {

    @FindBy(xpath = "//div[@id='code_search_results']/table/tbody/tr/td[2]/div[@class='result']/h2[@class='title']/a")
    private WebElement searchResults;

    public GitHubSearchResultPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String usersFound() {
        return searchResults.getText();
    }

    public void proceedToResult() {
        searchResults.click();
    }
}
