package ua.com.mcgray.bdd.tools.pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author orezchykov
 * @since 26.02.13
 */
public class GitHubSearchResultPage extends PageObject {

    public static final String SEARCH_RESULT_LOCATOR = "//ul[@class='members-list']/li[1]/h4/a";
    @FindBy(xpath = "//ul[@class='menu']/li/a[text()=' Users']")
//    @FindBy(css = "div.menu-container a:contains(' Users')")
    private WebElement usersSearch;

    public GitHubSearchResultPage(final WebDriver driver, final int ajaxTimeout) {
        super(driver, ajaxTimeout);
    }

    public GitHubSearchResultPage(final WebDriver driver) {
        super(driver);
    }

    public String check_results_for(final String name) {
        $(usersSearch).click();
        waitForPresenceOf(SEARCH_RESULT_LOCATOR);
        return $(SEARCH_RESULT_LOCATOR).getText();
    }

    public void proceed_to_profile(final String name) {
        $(SEARCH_RESULT_LOCATOR).click();
    }
}
