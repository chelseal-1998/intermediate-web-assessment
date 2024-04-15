package app.cds.pages;

import app.cds.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage extends BaseTest {

    public BasePage(WebDriver driver) {
        super();
    }

    public boolean validatePageHeaderAndPartialUrl(WebElement pageHeader, String partialUrl) {
        return webDriverWait().until(ExpectedConditions.visibilityOf(pageHeader)).isDisplayed() &&
                webDriverWait().until(ExpectedConditions.urlContains(partialUrl));
    }

    public WebDriverWait webDriverWait() {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(240));
    }
}