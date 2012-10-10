package ua.com.mcgray.bdd.tools.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: orezchykov
 * Date: 10.10.12
 * Time: 18:37
 * To change this template use File | Settings | File Templates.
 */
public class GitHubProfilePage extends Page {

    public GitHubProfilePage(WebDriver webDriver) {
        super(webDriver);
    }
    @FindBy(xpath = "//div[@class='avatared']/h1/em")
    private WebElement profileName;


    public boolean isOnProfilePage(String username) {
        return profileName.equals(username);
    }


    public List<String> repoList() {
        List<String> result = new ArrayList<String>();
        for (WebElement element : getWebDriver().findElements(By.xpath("//div[@class='repo-tab']/ul[@class='repolist js-repo-list']/li[@class='public source']"))) {
            result.add(element.findElement(By.tagName("h3")).findElement(By.tagName("a")).getText());
        }
        return result;
    }
}
