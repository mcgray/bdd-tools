
Scenario: Searching for a mcgray user repositories on GitHub and than the 'hidden treasure' in the test file
Given the user is on the GitHub search page
When the user looks up for 'mcgray'
Then the one should see the 'mcgray' in test results
When the user inspects 'mcgray' profile page
Then 'bdd-tools' exists as a repository
When browsing to test in 'thucydides-jbehave'
Then 'hidden treasure' is found in the test code