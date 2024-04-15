package app.cds.tests.templates;

import app.cds.BaseTest;
import app.cds.pages.dashboard.DashboardPage;
import app.cds.pages.login.LoginPage;
import app.cds.pages.templates.TemplateDetailsPage;
import app.cds.pages.templates.TemplatesPage;
import app.cds.pages.users.UsersPage;
import jdk.jfr.Description;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static app.cds.common.TestData.MID_SDET_TEMPLATE;
import static app.cds.common.TestData.SDE;
import static org.testng.Assert.assertTrue;

@Test
public class ViewTemplatesPageTests extends BaseTest {

    LoginPage loginPage;
    UsersPage usersPage;
    DashboardPage dashboardPage;
    TemplatesPage templatesPage;
    TemplateDetailsPage templateDetailsPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp(Method method) {
        super.setUp(method);
        loginPage = PageFactory.initElements(getDriver(), LoginPage.class);
        usersPage = PageFactory.initElements(getDriver(), UsersPage.class);
        dashboardPage = PageFactory.initElements(getDriver(), DashboardPage.class);
        templatesPage = PageFactory.initElements(getDriver(), TemplatesPage.class);
        templateDetailsPage = PageFactory.initElements(getDriver(), TemplateDetailsPage.class);

        loginPage.enterCredentials(customTestData.getUsername(), customTestData.getPassword());
        loginPage.clickLoginButton();
        dashboardPage.clickTemplatesLink();
        templatesPage.enterTitle(SDE);
    }

    @Description("As a user, I should be able to filter templates by title.")
    public void filterTemplatesByTitle() {
        assertTrue(templatesPage.getListOfTemplates().stream().allMatch(tl -> tl.contains(SDE)));
    }

    @Description("As a user, I should be able to clear the search field.")
    public void clearSearchField() {
        int numberOfTemplatesAfterFilter = templatesPage.getListOfTemplates().size();
        usersPage.clearButton();
        int numberOfTemplatesBeforeFilter = templatesPage.getListOfTemplates().size();
        assertTrue(numberOfTemplatesAfterFilter < numberOfTemplatesBeforeFilter);
    }

    @Description("As a user, I should be able to view a template.")
    public void viewTemplate() {
        templatesPage.viewTemplate(MID_SDET_TEMPLATE);
        assertTrue(templateDetailsPage.validateTemplateDetailsPage());
    }

    @Description("As a user, I should be able to navigate back to the templates page from the templates details page.")
    public void navigateBackToTemplatesPage() {
        templatesPage.viewTemplate(MID_SDET_TEMPLATE);
        templateDetailsPage.clickBack();
        assertTrue(templatesPage.validateTemplatesPageHeaderTextAndPartialUrl());
    }
}