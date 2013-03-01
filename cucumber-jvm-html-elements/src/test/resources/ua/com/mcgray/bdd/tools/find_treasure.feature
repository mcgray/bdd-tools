Feature: Searching for a mcgray user repositories on GitHub and than the 'hidden treasure' in the test file
  Scenario: Find mcgray user on GitHub,  find bdd-tools repo on mcgray profile page, find treasure in the test code

    Given the user is on the GitHub search page
    When the user looks up for mcgray
    Then the one should see the mcgray in test results

    Given GitHub profile page
    When the user inspects mcgray profile page
    Then bdd-tools exists as a repository

    Given cucumber-jvm-html-elements project
    When browsing to test in cucumber-jvm-html-elements
    Then hidden treasure is found in the test code
