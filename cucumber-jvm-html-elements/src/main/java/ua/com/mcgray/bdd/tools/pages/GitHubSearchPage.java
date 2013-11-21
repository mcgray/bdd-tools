package ua.com.mcgray.bdd.tools.pages;

import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

/**
 * @author orezchykov
 * @since 28.02.13
 */
public class GitHubSearchPage extends Page {

	public static final String GITHUB_SEARCH_URL = "http://github.com/search";

	private SearchForm searchForm;

	public GitHubSearchPage(final WebDriver webDriver) {
		super(webDriver);
		HtmlElementLoader.populatePageObject(this, webDriver);
	}

	public void open() {
		getWebDriver().get(GITHUB_SEARCH_URL);

	}

	public void search_for(final String name) {
		searchForm.search_for(name);
	}

}
