package app.cds.tests.users;

import app.cds.BaseTest;
import app.cds.pages.dashboard.DashboardPage;
import app.cds.pages.login.LoginPage;
import app.cds.pages.users.UsersPage;
import jdk.jfr.Description;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static app.cds.common.TestData.COOK;
import static org.testng.Assert.assertTrue;

@Test
public class ViewUsersPageTests extends BaseTest {

    LoginPage loginPage;
    UsersPage usersPage;
    DashboardPage dashboardPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp(Method method) {
        super.setUp(method);
        loginPage = PageFactory.initElements(getDriver(), LoginPage.class);
        usersPage = PageFactory.initElements(getDriver(), UsersPage.class);
        dashboardPage = PageFactory.initElements(getDriver(), DashboardPage.class);

        loginPage.enterCredentials(customTestData.getUsername(), customTestData.getPassword());
        loginPage.clickLoginButton();
        dashboardPage.clickUsersLink();
        usersPage.enterUsername(COOK);
    }

    @Description("As a user, I should be able to filter the list of users by username.")
    public void filterUsersByUsername() {
        assertTrue(usersPage.getListOfUsers().stream().allMatch(ul -> ul.contains(COOK)));
    }

    @Description("As a user, I should be able to clear the search field.")
    public void clearSearchField() {
        int numberOfUsersAfterFilter = usersPage.getListOfUsers().size();
        usersPage.clearButton();
        int numberOfUsersBeforeFilter = usersPage.getListOfUsers().size();
        assertTrue(numberOfUsersAfterFilter < numberOfUsersBeforeFilter);
    }
}