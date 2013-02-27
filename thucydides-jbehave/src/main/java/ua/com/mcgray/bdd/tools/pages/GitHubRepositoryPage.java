package ua.com.mcgray.bdd.tools.pages;

import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author orezchykov
 * @since 26.02.13
 */
public class GitHubRepositoryPage extends PageObject {

	public static final String CONTENT_LINKS_LOCATOR = "td.content a";

	public static final String FILE_CONTENT_LOCATOR = "//table[@class='lines']/tbody/tr/td[2]";

    public static final String[] pathToTest = {"src", "test", "java", "ua", "com", "mcgray", "bdd", "tools", "FindTreasureTest.java"};

	public GitHubRepositoryPage(final WebDriver driver, final int ajaxTimeout) {
		super(driver, ajaxTimeout);
	}

	public GitHubRepositoryPage(final WebDriver driver) {
		super(driver);
	}

    public void proceed_to(String projectName) {
        proceed_to_link(projectName);
        for (int i = 0; i < pathToTest.length; i++) {
            proceed_to_link(pathToTest[i]);
        }
    }

    private void proceed_to_link(final String path) {
        waitABit(2000l);
        for (WebElementFacade webElementFacade : findAll(By.cssSelector(CONTENT_LINKS_LOCATOR))) {
            if (webElementFacade.getText().contains(path)) {
                webElementFacade.click();
                return;
            }
        }
    }

    public String get_file_content() {
		waitForPresenceOf(FILE_CONTENT_LOCATOR);
		return $(FILE_CONTENT_LOCATOR).getText();
	}
}
