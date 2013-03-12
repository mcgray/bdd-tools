package ua.com.mcgray.bdd.tools.pages;

import com.google.common.base.Predicate;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author orezchykov
 * @since 01.03.13
 */
public class Page {

    public static final long TIME_OUT_IN_SECONDS = 10l;
    public static final long AJAX_WAIT = 2000l;

    private WebDriver webDriver;

    public Page(final WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public void shortWait() throws InterruptedException {
        new WebDriverWait(getWebDriver(), AJAX_WAIT).until(new Predicate<WebDriver>() {
            @Override
            public boolean apply(final WebDriver input) {
                return (Boolean) ((JavascriptExecutor) input).executeScript(
                        "return window.jQuery.active == 0");
            }
        });
    }
}
