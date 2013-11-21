package ua.com.mcgray.bdd.tools.pages;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

/**
 * @author orezchykov
 * @since 01.03.13
 */
@Name("Search form")
@Block(@FindBy(id = "code_search"))
public class SearchForm extends HtmlElement {
    @Name("Search input")
    @FindBy(name = "q")
    private TextInput searchField;

    @Name("Submit button")
    @FindBy(css = "button.button")
    private Button submitButton;

    public void search_for(String name) {
        searchField.sendKeys(name);
        submitButton.click();
    }

}
