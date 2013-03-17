package example2;

import com.codeborne.selenide.Selenide;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static java.util.Arrays.asList;

public class GitHubSpec {
  private SearchPage searchPage;

  @BeforeMethod
  public void openGitHub() {
    open("http://github.com/search");
    searchPage = Selenide.page(SearchPage.class);
  }

  @Test
  public void userCanSearchRepositories() {
    searchPage.search("mcgray");
    searchPage.repositoriesResults().shouldHave(text("mcgray/bdd-tools"));
  }

  @Test
  public void userCanSearchUsers() {
    searchPage.search("mcgray");
    searchPage.showUsersResults();
    searchPage.usersResults().shouldHave(text("Oleksiy Rezchykov"));

    UserProfilePage userProfilePage = searchPage.openUserProfile("mcgray");
    userProfilePage.showRepositories();
    userProfilePage.getRepositories().shouldHave(text("bdd-tools"));
  }

  @Test
  public void userCanBrowseProjectSources() {
    UserProfilePage userProfilePage = open("https://github.com/mcgray", UserProfilePage.class);
    userProfilePage.showRepositories();

    RepositoryPage repository = userProfilePage.openRepository("bdd-tools");
    for (String path : asList("cucumber-jvm-html-elements", "src", "test", "java", "ua", "com", "mcgray", "bdd", "tools", "FindTreasureStepdefs.java")) {
      repository.openSource(path);
    }
    repository.getSourceLines().shouldHave(text("hidden treasure"));
  }
}
