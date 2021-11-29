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
    public static SearchSteps searchSteps;
    private static Integer timeOuts = 1000;

    @BeforeClass
    public static void setup() {

        System.setProperty("webdriver.gecko.driver", ConfProperties.getProperty("moziladriver"));
        driver = new FirefoxDriver();
        searchPage = new SearchPage(driver);
        driver.get(ConfProperties.getProperty("webpage"));
        driver.manage().timeouts().pageLoadTimeout(timeOuts,
                TimeUnit.MILLISECONDS);
    }

    @Test
    public void searchTest() {

        searchSteps = new SearchSteps(searchPage);
        searchSteps.checkThatPageIsOpen();
        searchSteps.enterSearchValue();
        searchSteps.titleOfPageIsCorrect();
        searchSteps.searchRequestIsCorrect();
        searchSteps.searchResultIsCorrect();
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
