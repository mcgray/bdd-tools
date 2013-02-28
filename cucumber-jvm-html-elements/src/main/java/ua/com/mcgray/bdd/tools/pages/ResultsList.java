package ua.com.mcgray.bdd.tools.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

/**
 * @author orezchykov
 * @since 01.03.13
 */
@Name("Search result list placeholder")
@Block(@FindBy(css = "div.main-content"))
public class ResultsList extends HtmlElement {

    @Name("Users list")
    @FindBy(css = "ul.members-list")
    private WebElement usersList;

    public String get_list_text() {
        return usersList.getText();
    }

    public void click_on_profile() {
        usersList.findElements(By.tagName("li")).get(0).findElements(By.tagName("a")).get(0).click();
    }
}
