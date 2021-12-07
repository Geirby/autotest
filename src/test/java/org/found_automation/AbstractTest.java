package org.found_automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.logging.Logger;

public abstract class AbstractTest {

    protected WebDriver driver;
    static Logger log = Logger.getLogger("log");

    @BeforeClass
    public void setup() {

        int actualBrowser = 2;
        String browser = ConfProperties.getProperty("actualBrowser");

        switch (actualBrowser) {
            case 1:
                browser.equalsIgnoreCase("firefox");
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case 2:
                browser.equalsIgnoreCase("chrome");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            default:
                System.err.println("Enter actual browser");
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
