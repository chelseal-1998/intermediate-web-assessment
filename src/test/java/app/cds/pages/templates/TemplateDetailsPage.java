package app.cds.pages.templates;

import app.cds.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TemplateDetailsPage extends BasePage {

    @FindBy(xpath = "//h2[text()='Mid SDET ']")
    public WebElement templateDetailsHeading;
    @FindBy(xpath = "//h2[text()='Published by: ']")
    public WebElement templateDetailsPublishedLabel;
    @FindBy(xpath = "//h3[text()='cds-test-admin@globalkinetic.com']")
    public WebElement templateDetailsPublishedUsername;
    @FindBy(xpath = "//th[text()='Category']")
    public WebElement templateDetailsCategoryText;
    @FindBy(xpath = "//th[text()='Minimum Requirements']")
    public WebElement templateDetailsMinimumRequirementsText;
    @FindBy(xpath = "//th[text()='Definition of Success']")
    public WebElement templateDetailsDefinitionOfSuccessText;
    @FindBy(css = "[data-qa=back-button]")
    public WebElement backButton;

    public TemplateDetailsPage(WebDriver driver) {
        super(driver);
    }

    public boolean validateTemplateDetailsPage() {
        webDriverWait().until(ExpectedConditions.visibilityOf(templateDetailsHeading));
        return templateDetailsHeading.isDisplayed() && templateDetailsPublishedLabel.isDisplayed() &&
                templateDetailsPublishedUsername.isDisplayed() && templateDetailsCategoryText.isDisplayed() &&
                templateDetailsMinimumRequirementsText.isDisplayed() && templateDetailsDefinitionOfSuccessText.isDisplayed();
    }

    public TemplatesPage clickBack() {
        webDriverWait().until(ExpectedConditions.visibilityOf(backButton));
        backButton.click();
        return new TemplatesPage(getDriver());
    }
}