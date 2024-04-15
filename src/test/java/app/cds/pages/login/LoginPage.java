package app.cds.pages.login;

import app.cds.pages.BasePage;
import app.cds.pages.home.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static app.cds.common.TestData.LOGIN_PARTIAL_URL;

public class LoginPage extends BasePage {

    @FindBy(css = "[data-qa='user-name-text-input-field']")
    public WebElement usernameField;
    @FindBy(css = "[data-qa='password-password-input-field']")
    public WebElement passwordField;
    @FindBy(css = "[data-qa='login-button']")
    public WebElement loginButton;
    @FindBy(xpath = "//h3[text()='career development system powered by global kinetic']")
    public WebElement loginPageHeading;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterCredentials(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
    }

    public HomePage clickLoginButton() {
        loginButton.click();
        return new HomePage(getDriver());
    }

    public boolean validateLoginPageHeaderTextAndPartialUrl() {
        return validatePageHeaderAndPartialUrl(loginPageHeading, LOGIN_PARTIAL_URL) && loginButton.isDisplayed() &&
                usernameField.isDisplayed() && passwordField.isDisplayed();
    }
}