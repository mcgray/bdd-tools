package ua.com.mcgray.bdd.tools.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import ua.com.mcgray.bdd.tools.pages.GitHubRepositoryPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;


/**
 * @author orezchykov
 * @since 26.02.13
 */
public class RepositorySteps extends ScenarioSteps {

    private GitHubRepositoryPage gitHubRepositoryPage;

    public RepositorySteps(final Pages pages) {
        super(pages);
        gitHubRepositoryPage = getPages().get(GitHubRepositoryPage.class);
    }

    @Step
    public void browse_to_project(final String projectName) throws InterruptedException {
        gitHubRepositoryPage.proceed_to(projectName);

    }

    @Step
    public void search_for(final String hiddenWords) {
        assertThat(gitHubRepositoryPage.get_file_content(), containsString(hiddenWords));
    }
}
