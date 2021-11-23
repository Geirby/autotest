package org.found_automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SearchTest {

    public static SearchPage searchPage;
    public static WebDriver driver;

    @BeforeClass
    public static void setup() {

        System.setProperty("webdriver.gecko.driver", ConfProperties.getProperty("moziladriver"));
        driver = new FirefoxDriver();
        driver.get(ConfProperties.getProperty("webpage"));
        driver.manage().timeouts().pageLoadTimeout(10000,
                TimeUnit.MILLISECONDS);
    }

    @Test
    public void searchTest() {

        searchPage.isPageOpen();
        searchPage.enterTextOnSearchField();
        searchPage.textValidationAfterSearch();
        searchPage.searchResultValidation();

    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }


}
