package ua.com.mcgray.bdd.tools.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author orezchykov
 * @since 28.02.13
 */
public class GitHubRepositoryPage extends Page {

    public static final String[] pathToFile = {"src", "test", "java", "ua", "com", "mcgray", "bdd", "tools", "FindTreasureStepdefs.java"};

    private By contentLinksLocator = By.cssSelector("td.content a");

    private By fileContentLocator = By.xpath("//table[@class='lines']/tbody/tr/td[2]");

    public GitHubRepositoryPage(final WebDriver webDriver) {
        super(webDriver);
    }

    public void browse_to_project_test(final String projectName) throws InterruptedException {
        proceet_to_link(projectName);
        for (String path: pathToFile) {
           proceet_to_link(path);
        }
    }

    private void proceet_to_link(final String projectName) throws InterruptedException {
        shortWait();
        List<WebElement> contentLinks = getWebDriver().findElements(contentLinksLocator);
        for (WebElement contentLink : contentLinks) {
            if (contentLink.getText().contains(projectName)) {
                contentLink.click();
                break;
            }
        }
    }

    public String get_file_content() {
        WebElement fileContent = new WebDriverWait(getWebDriver(), TIME_OUT_IN_SECONDS).until(ExpectedConditions.presenceOfElementLocated(fileContentLocator));
        return fileContent.getText();
    }

}
