package app.cds;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Paths;
import java.util.Properties;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

public class BaseTest {

    protected static final Logger LOG = getLogger(lookup().lookupClass());
    public static RemoteWebDriver driver;
    public static CustomTestData customTestData;
    private final String DATA_PROPERTIES = "data.properties";
    Properties properties = new Properties();

    public static RemoteWebDriver getDriver() {
        return driver;
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp(Method method) {
        setUpPropertiesFile();
        customTestData = new CustomTestData(getProperties());
        setUpEnvironment();
    }

    public void setUpPropertiesFile() {
        try {
            File file = new File(Paths.get(DATA_PROPERTIES).toAbsolutePath().toString());
            FileInputStream fis = new FileInputStream(file);
            properties.load(fis);
            fis.close();
        } catch (IOException e) {
            LOG.error("Cannot find file" + e);
            throw new RuntimeException(e);
        }
    }

    public Properties getProperties() {
        return properties;
    }

    public void setUpEnvironment() {
        setUpDriver();
        driver.navigate().to(customTestData.getUrl());
        driver.manage().window().fullscreen();
    }

    public void setUpDriver() {
        if (customTestData.getBrowser().equalsIgnoreCase(Browser.CHROME.browserName())) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (customTestData.getBrowser().equalsIgnoreCase(Browser.FIREFOX.browserName())) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            throw new RuntimeException("Browser type unsupported");
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}