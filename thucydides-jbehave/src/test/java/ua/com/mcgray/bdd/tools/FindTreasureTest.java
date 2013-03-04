package ua.com.mcgray.bdd.tools;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import ua.com.mcgray.bdd.tools.steps.RepositorySteps;
import ua.com.mcgray.bdd.tools.steps.SearchSteps;

/**
 * @author orezchykov
 * @since 26.02.13
 */
public class FindTreasureTest {

    @Steps
    private RepositorySteps repositorySteps;

    @Steps
    private SearchSteps searchSteps;

    @Given("the user is on the GitHub search page")
    public void givenTheUserIsOnTheGitHubSearchPage() {
        searchSteps.is_the_search_page();
    }

    @When("the user looks up for '$name'")
    public void whenTheUserLooksFor(String name) {
        searchSteps.search_for(name);
    }

    @Then("the one should see the '$name' in test results")
    public  void thenTheOneShouldSeeInTestResults(String name) {
        searchSteps.check_results_for(name);
    }

    @When("the user inspects '$name' profile page")
    public void whenTheUserInspectsMcGrayProfilePage(String name) {
        searchSteps.proceed_to_profile(name);
    }

    @Then("'$repoName' exists as a repository")
    public void thenExistsAsARepositorty(String repoName) {
        searchSteps.repo_exists(repoName);
        searchSteps.proceed_to_repo(repoName);
    }

    @When("browsing to test in '$projectName'")
    public void whenBrowsingToTestIn(String projectName) throws InterruptedException {
        repositorySteps.browse_to_project(projectName);
    }

    @Then("'$hiddenWords' is found in the test code")
    public void thenIsFoundInTheTestCode(String hiddenWords) {
        repositorySteps.search_for(hiddenWords);
    }

    //That is a hidden treasure
    // that the test should find

}
