package app.cds.pages.reports;

import app.cds.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static app.cds.common.TestData.REPORTS_PARTIAL_URL;

public class ReportsPage extends BasePage {

    @FindBy(xpath = "//div[text()='View Reports']")
    public WebElement reportsPageHeader;

    public ReportsPage(WebDriver driver) {
        super(driver);
    }

    public boolean validateReportsPageHeaderTextAndPartialUrl() {
        return validatePageHeaderAndPartialUrl(reportsPageHeader, REPORTS_PARTIAL_URL);
    }
}