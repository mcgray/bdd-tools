package ua.com.mcgray.bdd.tools.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created with IntelliJ IDEA.
 * User: orezchykov
 * Date: 10.10.12
 * Time: 23:02
 * To change this template use File | Settings | File Templates.
 */
public class GitHubSearchResultPage extends Page {

    private WebElement searchResults;

    @FindBy(xpath = "//a[text()=' Users']")
    private WebElement usersSearch;

    public GitHubSearchResultPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String usersFound() {
        usersSearch.click();
        searchResults = new WebDriverWait(getWebDriver(), TIME_OUT_IN_SECONDS).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='user-list-item'][1]/div[@class='user-list-info']/a")));
        return searchResults.getText();
    }

    public void proceedToResult() {
        searchResults.click();
    }
}
