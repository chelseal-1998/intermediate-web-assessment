package app.cds.pages.templates;

import app.cds.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

import static app.cds.common.TestData.TEMPLATES_PARTIAL_URL;

public class TemplatesPage extends BasePage {

    @FindBy(xpath = "//h2[text()='Templates']")
    public WebElement templatesPageHeader;
    @FindBy(css = "[data-qa=search-input]")
    public WebElement searchField;
    @FindBy(xpath = "//tbody[1]//td[1]")
    public List<WebElement> templates;
    @FindBy(xpath = "//tr[@class='sc-jsEeTM eNwaQz'][1]")
    public WebElement midSdetTemplate;

    public TemplatesPage(WebDriver driver) {
        super(driver);
    }

    public boolean validateTemplatesPageHeaderTextAndPartialUrl() {
        return validatePageHeaderAndPartialUrl(templatesPageHeader, TEMPLATES_PARTIAL_URL);
    }

    public void enterTitle(String title) {
        webDriverWait().until(ExpectedConditions.visibilityOf(searchField));
        searchField.sendKeys(title);
        webDriverWait().until(ExpectedConditions.visibilityOf(searchField));
    }

    public List<String> getListOfTemplates() {
        List<String> defaultListOfTemplates = new ArrayList<>();

        for (WebElement templateName : templates) {
            defaultListOfTemplates.add(templateName.getText());
        }
        return defaultListOfTemplates;
    }

    public TemplateDetailsPage viewTemplate(String templateName) {
        webDriverWait().until(ExpectedConditions.elementToBeClickable(midSdetTemplate));
        getDriver().findElement(By.xpath("//td[text()='" + templateName +"']")).click();
        return new TemplateDetailsPage(getDriver());
    }
}