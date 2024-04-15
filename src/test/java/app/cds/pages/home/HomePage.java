package app.cds.pages.home;

import app.cds.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static app.cds.common.TestData.HOME_PARTIAL_URL;

public class HomePage extends BasePage {

    @FindBy(xpath = "//h2[text()='Home']")
    public WebElement homePageHeading;
    @FindBy(xpath = "//div[text()='Completed reviews']")
    public WebElement completedReviewsTab;
    @FindBy(xpath = "//div[text()='Open reviews']")
    public WebElement openReviewsTab;
    @FindBy(xpath = "//div[text()='No completed reviews available']")
    public WebElement completedReviewsMessage;
    @FindBy(css = "[data-qa='Reviewee-table-header']")
    public WebElement revieweeTableHeader;
    @FindBy(css = "[data-qa='Reviewer-table-header']")
    public WebElement reviewerTableHeader;
    @FindBy(css = "[data-qa='Matrix-table-header']")
    public WebElement matrixTableHeader;
    @FindBy(css = "[data-qa='Status-table-header']")
    public WebElement statusTableHeader;
    @FindBy(css = "[data-qa='Action-table-header']")
    public WebElement actionTableHeader;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean validateHomePageHeaderTextAndPartialUrl() {
        return validatePageHeaderAndPartialUrl(homePageHeading, HOME_PARTIAL_URL);
    }

    public void clickCompletedReviewsTab() {
        webDriverWait().until(ExpectedConditions.visibilityOf(completedReviewsTab));
        completedReviewsTab.click();
    }

    public void clickOpenReviewsTab() {
        webDriverWait().until(ExpectedConditions.visibilityOf(openReviewsTab));
        openReviewsTab.click();
    }

    public boolean validateCompletedReviewsPage() {
        return completedReviewsMessage.isDisplayed();
    }

    public boolean validateOpenReviewsPage() {
        return revieweeTableHeader.isDisplayed() && reviewerTableHeader.isDisplayed() && statusTableHeader.isDisplayed()
                && matrixTableHeader.isDisplayed() && actionTableHeader.isDisplayed();
    }
}