package org.found_automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SearchTest {

    public static SearchPage searchPage;
    public static WebDriver driver;
    public static SearchSteps searchSteps;
    private static Integer timeOuts = 10000;


    @BeforeClass
    public static void setup() {

        if(ConfProperties.getProperty("actualBrowser").equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", ConfProperties.getProperty("moziladriver"));
            driver = new FirefoxDriver();
        }else System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();


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
