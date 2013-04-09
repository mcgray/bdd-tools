package com.codeborne.example2;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static java.util.Arrays.asList;

public class GitHubSpec {

    private SearchPage searchPage;
	private UserProfilePage userProfilePage;
    private RepositoryPage repositoryPage;

    @BeforeMethod
	public void openGitHub() {
		searchPage = open("http://github.com/search", SearchPage.class);
	}

	@Test
	public void userCanSearchRepositories() {
		searchPage.search("bdd-tools");
		searchPage.repositoriesResults().shouldHave(text("mcgray/bdd-tools"));
	}

	@Test
	public void userCanSearchUsers() {
		searchPage.search("mcgray");
		searchPage.showUsersResults();
		searchPage.usersResults().shouldHave(text("Oleksiy Rezchykov"));

		userProfilePage = searchPage.openUserProfile("mcgray");
		userProfilePage.showRepositories();
		userProfilePage.getRepositories().shouldHave(text("bdd-tools"));
	}

	@Test
	public void userCanBrowseProjectSources() {
		userProfilePage = open("https://github.com/mcgray", UserProfilePage.class);
		userProfilePage.showRepositories();

        repositoryPage = userProfilePage.openRepository("bdd-tools");
		for (String path : asList("selenide", "src", "test", "java", "com", "codeborne", "example2", "GitHubSpec.java")) {
			repositoryPage.openSource(path);
		}
		repositoryPage.getSourceLines().shouldHave(text("hidden treasure"));
	}

}
