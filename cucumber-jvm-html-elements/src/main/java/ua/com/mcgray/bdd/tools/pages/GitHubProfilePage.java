package ua.com.mcgray.bdd.tools.pages;

import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

/**
 * @author orezchykov
 * @since 28.02.13
 */
public class GitHubProfilePage extends Page {

    private NavTabs navTabs;

    private TabContent tabContent;

    public GitHubProfilePage(final WebDriver webDriver) {
        super(webDriver);
        HtmlElementLoader.populatePageObject(this, webDriver);
    }

    public void click_repo_tab() {
        navTabs.click_repo_tab();
    }

    public String get_repositories() {
        return tabContent.get_repositories();
    }

    public void proceed_to_repo() {
        tabContent.proceed_to_repo();


    }
}
