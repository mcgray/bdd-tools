package ua.com.mcgray.bdd.tools.pages;


import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

/**
 * @author orezchykov
 * @since 28.02.13
 */
public class GitHubSearchResultPage extends Page {

    private MenuContainer menuContainer;

    private ResultsList resultsList;

    public GitHubSearchResultPage(final WebDriver webDriver) {
        super(webDriver);
        HtmlElementLoader.populatePageObject(this, webDriver);
    }

    public String get_search_result_list() {
        menuContainer.switch_to_user_search_list();
        return resultsList.get_list_text();
    }

    public void proceed_to_profile() {
        resultsList.click_on_profile();

    }
}
