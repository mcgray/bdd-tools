package ua.com.mcgray.bdd.tools.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author orezchykov
 * @since 28.02.13
 */
public class GitHubRepositoryPage extends Page {

    private By contentLinksLocator = By.cssSelector("td.content a");

    private By fileContentLocator = By.xpath("//table[@class='lines']/tbody/tr/td[2]");

    public GitHubRepositoryPage(final WebDriver webDriver) {
        super(webDriver);
    }

    public void browse_to_project_test(final String projectName) {
        shortWait();
        List<WebElement> contentLinks = getWebDriver().findElements(contentLinksLocator);
        for (WebElement contentLink : contentLinks) {
            if (contentLink.getText().contains(projectName)) {
                System.out.println(contentLink.getText());
                contentLink.click();
                return;
            }
        }
    }

    private void shortWait() {

    }

    public String get_file_content() {
        return null;
    }

//    public boolean searchInFileContent(String text) {
//        WebElement fileContent = new WebDriverWait(getWebDriver(), TIME_OUT_IN_SECONDS).until(ExpectedConditions.presenceOfElementLocated(fileContentLocator));
//        return fileContent.getText().contains(text);
//    }
}
