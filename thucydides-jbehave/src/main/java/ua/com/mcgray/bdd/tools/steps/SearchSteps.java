package ua.com.mcgray.bdd.tools.steps;

import java.util.List;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import ua.com.mcgray.bdd.tools.pages.GitHubProfilePage;
import ua.com.mcgray.bdd.tools.pages.GitHubSearchPage;
import ua.com.mcgray.bdd.tools.pages.GitHubSearchResultPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

/**
 * @author orezchykov
 * @since 26.02.13
 */
public class SearchSteps extends ScenarioSteps {

    private GitHubSearchPage gitHubSearchPage;

    private GitHubSearchResultPage gitHubSearchResultPage;
    
    private GitHubProfilePage gitHubProfilePage;

    public SearchSteps(final Pages pages) {
        super(pages);
        gitHubSearchPage = getPages().get(GitHubSearchPage.class);
        gitHubSearchResultPage = getPages().get(GitHubSearchResultPage.class);
        gitHubProfilePage = getPages().get(GitHubProfilePage.class);
    }


    @Step
    public void is_the_search_page() {
        gitHubSearchPage.open();

    }

    @Step
    public void search_for(final String name) {
        gitHubSearchPage.search_for(name);

    }

    @Step
    public void check_results_for(final String name) {
        String users = gitHubSearchResultPage.check_results_for(name);
        assertThat(users, containsString(name));
    }

    @Step
    public void proceed_to_profile(final String name) {
        gitHubSearchResultPage.proceed_to_profile(name);
    }

    @Step
    public void repo_exists(final String repoName) {
        List<String> repositories = gitHubProfilePage.get_repositories();
        assertThat(repositories, hasItem(containsString(repoName)));

    }

    @Step
    public void proceed_to_repo(final String repoName) {
        gitHubProfilePage.proceed_to_repo(repoName);

    }
}
