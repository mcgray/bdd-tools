package example2;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class UserProfilePage {
  public void showRepositories() {
    $(".tabnav-tabs").find(By.linkText("Repositories")).click();
  }

  public SelenideElement getRepositories() {
    return $(".repolist");
  }

  public RepositoryPage openRepository(String repositoryName) {
    getRepositories().find(By.linkText(repositoryName)).click();
    return page(RepositoryPage.class);
  }
}
