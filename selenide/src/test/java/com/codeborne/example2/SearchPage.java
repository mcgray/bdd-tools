package com.codeborne.example2;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class SearchPage {
  public void search(String query) {
    $("#search_form").find(By.name("q")).setValue(query).pressEnter();
  }

  public SelenideElement repositoriesResults() {
    return $(".main-content .repolist");
  }

  public void showUsersResults() {
    $(".search-menu-container").find(By.partialLinkText("Users")).click();
  }

  public SelenideElement usersResults() {
    return $(".main-content .user-list .user-list-item");
  }

  public UserProfilePage openUserProfile(String username) {
    usersResults().find(By.linkText(username)).click();
    return page(UserProfilePage.class);
  }
}
