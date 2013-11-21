package ua.com.mcgray.bdd.tools.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

/**
 * @author orezchykov
 * @since 01.03.13
 */
@Name("Navigation tabs")
@Block(@FindBy(css = "ul.tabnav-tabs"))
public class NavTabs extends HtmlElement {

	@Name("Repo tab")
	@FindBy(css = "span.octicon.octicon-repo")
	private WebElement repoTab;

	public void click_repo_tab() {
		repoTab.click();
	}
}
