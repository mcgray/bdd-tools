package ua.com.mcgray.bdd.tools;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import ua.com.mcgray.bdd.tools.page.GitHubIndexPage;
import ua.com.mcgray.bdd.tools.page.GitHubProfilePage;
import ua.com.mcgray.bdd.tools.page.GitHubSearchResultPage;

/**
 * Created with IntelliJ IDEA.
 * User: orezchykov
 * Date: 10.10.12
 * Time: 16:15
 * To change this template use File | Settings | File Templates.
 */
@RunWith(ConcordionRunner.class)
public class GitHubRepoTest {

    private WebDriver webDriver;

    private GitHubIndexPage gitHubIndexPage;
    private GitHubSearchResultPage gitHubSearchResultPage;
    private GitHubProfilePage gitHubProfilePage;

    @Before
    public void setUp() {
        webDriver = new ChromeDriver();
        gitHubIndexPage = PageFactory.initElements(webDriver, GitHubIndexPage.class);
        gitHubSearchResultPage = PageFactory.initElements(webDriver,GitHubSearchResultPage.class);
        gitHubProfilePage = PageFactory.initElements(webDriver, GitHubProfilePage.class);
        gitHubIndexPage.open();


    }

    public void searchForUser(String user) {
        gitHubIndexPage.searchFor(user);
    }

    public boolean userFound(String username) {
        return gitHubSearchResultPage.usersFound().contains(username);
    }

    public void proceedToProfile() {
        gitHubSearchResultPage.proceedToResult();
    }

    public boolean isOnProfilePage(String username) {
        return gitHubProfilePage.isOnProfilePage(username);
    }

    public boolean repoPresentOnProfilePage(String repo) {
        return gitHubProfilePage.repoList().contains(repo);
    }

    @After
    public void tearDown() {
        gitHubIndexPage.close();
    }


}
