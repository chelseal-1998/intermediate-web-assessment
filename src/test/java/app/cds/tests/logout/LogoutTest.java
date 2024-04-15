package app.cds.tests.logout;

import app.cds.BaseTest;
import app.cds.pages.dashboard.DashboardPage;
import app.cds.pages.login.LoginPage;
import app.cds.pages.logout.LogoutPage;
import jdk.jfr.Description;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static org.testng.Assert.assertTrue;

public class LogoutTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    LogoutPage logOutPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp(Method method) {
        super.setUp(method);
        loginPage = PageFactory.initElements(getDriver(), LoginPage.class);
        dashboardPage = PageFactory.initElements(getDriver(), DashboardPage.class);
        logOutPage = PageFactory.initElements(getDriver(), LogoutPage.class);
    }

    @Test
    @Description("As a user, I should be able to logout.")
    public void logoutSuccessfully() {
        loginPage.enterCredentials(customTestData.getUsername(), customTestData.getPassword());
        loginPage.clickLoginButton();
        dashboardPage.clickLogoutLink();
        logOutPage.confirmLogout();
        assertTrue(loginPage.validateLoginPageHeaderTextAndPartialUrl());
    }
}