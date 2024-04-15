package app.cds.tests.home;

import app.cds.BaseTest;
import app.cds.pages.home.HomePage;
import app.cds.pages.login.LoginPage;
import jdk.jfr.Description;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

@Test
public class ViewReviewsTests extends BaseTest {

    LoginPage loginPage;
    HomePage homePage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        loginPage = PageFactory.initElements(getDriver(), LoginPage.class);
        homePage = PageFactory.initElements(getDriver(), HomePage.class);

        loginPage.enterCredentials(customTestData.getUsername(), customTestData.getPassword());
        loginPage.clickLoginButton();
    }

    @Description("As a user, I should be able to view the completed reviews page.")
    public void navigateToCompletedReviewsPage() {
        homePage.clickCompletedReviewsTab();
        assertTrue(homePage.validateCompletedReviewsPage());
    }

    @Description("As a user, I should be able to view the open reviews page.")
    public void navigateToOpenReviewsPage() {
        homePage.clickOpenReviewsTab();
        assertTrue(homePage.validateOpenReviewsPage());
    }
}