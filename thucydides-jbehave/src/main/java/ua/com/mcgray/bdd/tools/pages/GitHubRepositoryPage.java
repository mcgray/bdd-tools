package ua.com.mcgray.bdd.tools.pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;

/**
 * @author orezchykov
 * @since 26.02.13
 */
public class GitHubRepositoryPage extends PageObject {

	public static final String CONTENT_LINKS_LOCATOR = "td.content a";

	public static final String FILE_CONTENT_LOCATOR = "//table[@class='lines']/tbody/tr/td[2]";

	public GitHubRepositoryPage(final WebDriver driver, final int ajaxTimeout) {
		super(driver, ajaxTimeout);
	}

	public GitHubRepositoryPage(final WebDriver driver) {
		super(driver);
	}

	public String get_file_content() {
		waitForPresenceOf(FILE_CONTENT_LOCATOR);
		return $(FILE_CONTENT_LOCATOR).getText();
	}

	public void proceed_to(String projectName) {

	}
}
