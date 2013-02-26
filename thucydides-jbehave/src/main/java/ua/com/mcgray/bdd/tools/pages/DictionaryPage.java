package ua.com.mcgray.bdd.tools.pages;

import java.util.ArrayList;
import java.util.List;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

@DefaultUrl("http://en.wiktionary.org/wiki/Wiktionary:Main_Page")
public class DictionaryPage extends PageObject {

    @FindBy(name="search")
    private WebElement searchTerms;

    @FindBy(name="go")
    private WebElement lookupButton;

//    @FindBy(css="ol li")
//    private List<WebElement> definitionList;

    private By definitionList = By.cssSelector("ol li");

    public DictionaryPage(WebDriver driver) {
        super(driver);
    }

    public void enter_keywords(String keyword) {
        $(searchTerms).type(keyword);
    }

    public void lookup_terms() {
        $(lookupButton).click();
    }

    public List<String> getDefinitions() {
        waitFor(ExpectedConditions.presenceOfElementLocated(definitionList));
        List<String> definitionText = new ArrayList<String>();
        List<WebElement> definitions = getDriver().findElements(definitionList);
        for (WebElement definition : definitions) {
           definitionText.add(definition.getText());
        }
//        return extract(definitionList, on(WebElement.class).getText());
        return definitionText;
    }
}