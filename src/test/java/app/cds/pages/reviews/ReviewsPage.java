package app.cds.pages.reviews;

import app.cds.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static app.cds.common.TestData.REVIEWS_PARTIAL_URL;

public class ReviewsPage extends BasePage {

    @FindBy(xpath = "//div[text()='View Reviews']")
    public WebElement reviewsPageHeader;

    public ReviewsPage(WebDriver driver) {
        super(driver);
    }

    public boolean validateReviewsPageHeaderTextAndPartialUrl() {
        return validatePageHeaderAndPartialUrl(reviewsPageHeader, REVIEWS_PARTIAL_URL);
    }
}