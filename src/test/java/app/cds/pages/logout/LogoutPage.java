package app.cds.pages.logout;

import app.cds.pages.BasePage;
import app.cds.pages.login.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage extends BasePage {

    @FindBy(css = "[data-qa='confirmation-yes-button']")
    public WebElement confirmButton;

    public LogoutPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage confirmLogout() {
        confirmButton.click();
        return new LoginPage(getDriver());
    }
}