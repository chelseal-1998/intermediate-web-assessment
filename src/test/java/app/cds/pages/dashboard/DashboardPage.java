package app.cds.pages.dashboard;

import app.cds.pages.BasePage;
import app.cds.pages.logout.LogoutPage;
import app.cds.pages.reports.ReportsPage;
import app.cds.pages.reviews.ReviewsPage;
import app.cds.pages.templates.TemplatesPage;
import app.cds.pages.users.UsersPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DashboardPage extends BasePage {

    @FindBy(css = "[data-qa='users-app-link']")
    public WebElement usersPage;
    @FindBy(css = "[data-qa='templates-app-link']")
    public WebElement templatesPage;
    @FindBy(css = "[data-qa='reviews-app-link']")
    public WebElement reviewsPage;
    @FindBy(css = "[data-qa='reports-app-link']")
    public WebElement reportsPage;
    @FindBy(css = "[data-qa='log out-app-link']")
    public WebElement logoutPage;

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public UsersPage clickUsersLink() {
        webDriverWait().until(ExpectedConditions.visibilityOf(usersPage));
        usersPage.click();
        return new UsersPage(getDriver());
    }

    public TemplatesPage clickTemplatesLink() {
        webDriverWait().until(ExpectedConditions.visibilityOf(templatesPage));
        templatesPage.click();
        return new TemplatesPage(getDriver());
    }

    public ReviewsPage clickReviewsLink() {
        webDriverWait().until(ExpectedConditions.visibilityOf(reviewsPage));
        reviewsPage.click();
        return new ReviewsPage(getDriver());
    }

    public ReportsPage clickReportsLink() {
        webDriverWait().until(ExpectedConditions.visibilityOf(reportsPage));
        reportsPage.click();
        return new ReportsPage(getDriver());
    }

    public LogoutPage clickLogoutLink() {
        webDriverWait().until(ExpectedConditions.visibilityOf(logoutPage));
        logoutPage.click();
        return new LogoutPage(getDriver());
    }
}