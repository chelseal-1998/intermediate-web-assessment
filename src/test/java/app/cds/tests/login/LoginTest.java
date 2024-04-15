package app.cds.tests.login;

import app.cds.BaseTest;
import app.cds.pages.home.HomePage;
import app.cds.pages.login.LoginPage;
import jdk.jfr.Description;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    LoginPage loginPage;
    HomePage homePage;

    @BeforeMethod(alwaysRun = true)
    public void setUp(Method method) {
        super.setUp(method);
        loginPage = PageFactory.initElements(getDriver(), LoginPage.class);
        homePage = PageFactory.initElements(getDriver(), HomePage.class);
    }

    @Description("As a user, I should be able to log in with valid credentials.")
    @Test
    public void loginWithValidCredentials() {
        loginPage.enterCredentials(customTestData.getUsername(), customTestData.getPassword());
        loginPage.clickLoginButton();
        assertTrue(homePage.validateHomePageHeaderTextAndPartialUrl());
    }
}