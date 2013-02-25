package ua.com.mcgray.bdd.tools;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import ua.com.mcgray.bdd.tools.page.GitHubProfilePage;
import ua.com.mcgray.bdd.tools.page.GitHubRepositoryPage;
import ua.com.mcgray.bdd.tools.page.GitHubSearchPage;
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

    private GitHubSearchPage gitHubIndexPage;
    private GitHubSearchResultPage gitHubSearchResultPage;
    private GitHubProfilePage gitHubProfilePage;
    private GitHubRepositoryPage gitHubRepositoryPage;

    @Before
    public void setUp() {
        webDriver = new ChromeDriver();
        gitHubIndexPage = PageFactory.initElements(webDriver, GitHubSearchPage.class);
        gitHubSearchResultPage = PageFactory.initElements(webDriver,GitHubSearchResultPage.class);
        gitHubProfilePage = PageFactory.initElements(webDriver, GitHubProfilePage.class);
        gitHubRepositoryPage = PageFactory.initElements(webDriver, GitHubRepositoryPage.class);
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

    public void brosweToTest() throws InterruptedException {
        gitHubProfilePage.proceedToRepo("bdd-tools");
        gitHubRepositoryPage.proceedToPath("concordion-webdriver", "src", "test", "java", "ua", "com", "mcgray", "bdd", "tools", "GitHubRepoTest.java");

    }


    public boolean searchFor(String text) {
        return gitHubRepositoryPage.searchInFileContent(text);
    }

    @After
    public void tearDown() {
        gitHubIndexPage.close();
    }

    //That is a hidden treasure
    // that the test should find


}
