package app.cds.pages.users;

import app.cds.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

import static app.cds.common.TestData.USERS_PARTIAL_URL;

public class UsersPage extends BasePage {

    @FindBy(xpath = "//h2[text()='Users']")
    public WebElement usersPageHeading;
    @FindBy(xpath = "//tbody[1]//td[1]")
    public List<WebElement> users;
    @FindBy(css = "[data-qa=search-input]")
    public WebElement searchField;
    @FindBy(xpath = "//button")
    public WebElement clearButton;

    public UsersPage(WebDriver driver) {
        super(driver);
    }

    public boolean validateUsersPageHeaderTextAndPartialUrl() {
        return validatePageHeaderAndPartialUrl(usersPageHeading, USERS_PARTIAL_URL);
    }

    public List<String> getListOfUsers() {
        List<String> filteredListOfUsers = new ArrayList<>();

        for (WebElement user : users) {
            filteredListOfUsers.add(user.getText());
        }
        return filteredListOfUsers;
    }

    public void enterUsername(String username) {
        webDriverWait().until(ExpectedConditions.visibilityOf(searchField));
        searchField.sendKeys(username);
    }

    public void clearButton() {
        clearButton.click();
    }
}