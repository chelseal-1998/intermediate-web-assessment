package app.cds.tests.dashboard;

import app.cds.BaseTest;
import app.cds.pages.dashboard.DashboardPage;
import app.cds.pages.login.LoginPage;
import app.cds.pages.reports.ReportsPage;
import app.cds.pages.reviews.ReviewsPage;
import app.cds.pages.templates.TemplatesPage;
import app.cds.pages.users.UsersPage;
import jdk.jfr.Description;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static org.testng.Assert.assertTrue;

@Test
public class LeftFixedNavigationTests extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    UsersPage usersPage;
    TemplatesPage templatesPage;
    ReviewsPage reviewsPage;
    ReportsPage reportsPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp(Method method) {
        super.setUp(method);
        loginPage = PageFactory.initElements(getDriver(), LoginPage.class);
        dashboardPage = PageFactory.initElements(getDriver(), DashboardPage.class);
        usersPage = PageFactory.initElements(getDriver(), UsersPage.class);
        templatesPage = PageFactory.initElements(getDriver(), TemplatesPage.class);
        reviewsPage = PageFactory.initElements(getDriver(), ReviewsPage.class);
        reportsPage = PageFactory.initElements(getDriver(), ReportsPage.class);

        loginPage.enterCredentials(customTestData.getUsername(), customTestData.getPassword());
        loginPage.clickLoginButton();
    }

    @Description("As a user, I should be redirected to the Users page when clicking on the users tab item.")
    public void navigateToUsersPage() {
        dashboardPage.clickUsersLink();
        assertTrue((usersPage.validateUsersPageHeaderTextAndPartialUrl()));
    }

    @Description("As a user, I should be redirected to the Templates page when clicking on the templates tab item.")
    public void navigateToTemplatesPage() {
        dashboardPage.clickTemplatesLink();
        assertTrue(templatesPage.validateTemplatesPageHeaderTextAndPartialUrl());
    }

    @Description("As a user, I should be redirected to the Reviews page when clicking on the reviews tab item.")
    public void navigateToReviewsPage() {
        dashboardPage.clickReviewsLink();
        assertTrue(reviewsPage.validateReviewsPageHeaderTextAndPartialUrl());
    }

    @Description("As a user, I should be redirected to the Reports page when clicking on the reports tab item.")
    public void navigateToReportsPage() {
        dashboardPage.clickReportsLink();
        assertTrue(reportsPage.validateReportsPageHeaderTextAndPartialUrl());
    }
}