package ua.com.mcgray.bdd.tools.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author orezchykov
 * @since 26.02.13
 */
@DefaultUrl("http://github.com/search")
public class GitHubSearchPage  extends PageObject {

    @FindBy(name = "q")
    private WebElement searchField;

    public GitHubSearchPage(final WebDriver driver, final int ajaxTimeout) {
        super(driver, ajaxTimeout);
    }

    public GitHubSearchPage(final WebDriver driver) {
        super(driver);
    }


    public void search_for(final String name) {
        $(searchField).typeAndEnter(name);
    }
}
