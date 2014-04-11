package ua.com.mcgray.bdd.tools.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created with IntelliJ IDEA.
 * User: orezchykov
 * Date: 10.10.12
 * Time: 16:34
 * To change this template use File | Settings | File Templates.
 */
public class Page {

    public static final long TIME_OUT_IN_SECONDS = 10l;
    public static final long SHORT_WAIT_IN_MILISEC = 2000l;
    protected WebDriver webDriver;

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public Page(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void open() {
        webDriver.get(getUrl());
    }

    protected String getUrl() {
        return "";
    }

    public void close() {
        webDriver.close();
    }

    protected void waitForAjax() throws InterruptedException {
        new WebDriverWait(getWebDriver(), SHORT_WAIT_IN_MILISEC).until((WebDriver input) -> (Boolean) ((JavascriptExecutor) input).executeScript(
                "return window.jQuery.active == 0"));
    }
}
