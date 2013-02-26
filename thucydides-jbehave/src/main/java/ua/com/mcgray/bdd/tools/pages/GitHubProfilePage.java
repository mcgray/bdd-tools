package ua.com.mcgray.bdd.tools.pages;

import java.util.ArrayList;
import java.util.List;

import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author orezchykov
 * @since 26.02.13
 */
public class GitHubProfilePage extends PageObject {

    public static final String REPOSITORIES_LOCATOR = "div.repo-tab ul.repolist.js-repo-list";

    public static final String REPOSITORIES_LINE_LOCATOR = "li.public.source";

    @FindBy(css = "ul.tabnav-tabs li a span.mini-icon.mini-icon-public-repo")
    private WebElement repoTab;

    public GitHubProfilePage(final WebDriver driver, final int ajaxTimeout) {
        super(driver, ajaxTimeout);
    }

    public GitHubProfilePage(final WebDriver driver) {
        super(driver);
    }

    public List<String> get_repositories() {
        List<String> result = new ArrayList<String>();
        repoTab.click();
        waitForPresenceOf(REPOSITORIES_LOCATOR);
        for (WebElementFacade webElementFacade : $(REPOSITORIES_LOCATOR).thenFindAll(REPOSITORIES_LINE_LOCATOR)) {
            result.add(webElementFacade.getText());
        }
        return result;

    }

    public void proceed_to_repo(final String repoName) {
        for (WebElementFacade webElementFacade : $(REPOSITORIES_LOCATOR).thenFindAll(REPOSITORIES_LINE_LOCATOR)) {
            if (webElementFacade.getText().contains(repoName)) {
                webElementFacade.click();
                return;
            }
        }


    }
}
