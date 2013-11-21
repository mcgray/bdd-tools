package ua.com.mcgray.bdd.tools.pages;

import com.google.common.base.Predicate;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author orezchykov
 * @since 26.02.13
 */
public class GitHubRepositoryPage extends PageObject {

	public static final String CONTENT_LINKS_LOCATOR = "td.content a";

	public static final String FILE_CONTENT_LOCATOR = "//td[@class='blob-line-code']/div/pre";

    public static final String[] pathToTest = {"src", "test", "java", "ua", "com", "mcgray", "bdd", "tools", "FindTreasureTest.java"};

    public static final long SHORT_WAIT_IN_MILISEC = 2000l;

    public GitHubRepositoryPage(final WebDriver driver, final int ajaxTimeout) {
		super(driver, ajaxTimeout);
	}

	public GitHubRepositoryPage(final WebDriver driver) {
		super(driver);
	}

    public void proceed_to(String projectName) throws InterruptedException {
        proceed_to_link(projectName);
        for (int i = 0; i < pathToTest.length; i++) {
            proceed_to_link(pathToTest[i]);
        }
    }

    private void proceed_to_link(final String path) throws InterruptedException {
        for (WebElementFacade webElementFacade : findAll(By.cssSelector(CONTENT_LINKS_LOCATOR))) {
            if (webElementFacade.getText().contains(path)) {
                webElementFacade.click();
                waitForAjax();
                return;
            }
        }
    }

    public String get_file_content() {
		waitForPresenceOf(FILE_CONTENT_LOCATOR);
		return $(FILE_CONTENT_LOCATOR).getText();
	}

    protected void waitForAjax() throws InterruptedException {
        new WebDriverWait(getDriver(), SHORT_WAIT_IN_MILISEC).until(new Predicate<WebDriver>() {
            @Override
            public boolean apply(final WebDriver input) {
                return (Boolean) ((JavascriptExecutor) input).executeScript(
                        "return window.jQuery.active == 0");
            }
        });
    }
}
