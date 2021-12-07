package org.found_automation;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Locale;

public class SearchTest extends AbstractTest {

    @Test
    public void searchTest() {

        String firstValue = "java";
        String secondValue = "selenium";

        driver.get(ConfProperties.getProperty("webpage"));
        SearchPage searchPage = new SearchPage(driver);
        SearchSteps searchSteps = new SearchSteps(searchPage);
        searchPage.enterValue(firstValue);
        searchSteps.checkThatPageIsOpen();
        log.info("Page is opened");
        searchPage.enterTextOnSearchField(firstValue);
        log.info("Enter search value");
        Integer timeout = 3;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
        Assert.assertTrue(driver.getTitle().contains(firstValue), "Title is wrong");
        log.info("Check title");
        Assert.assertTrue(searchPage.getTextFromSearchFieldAfterReq().toLowerCase(Locale.ROOT).contains(firstValue), "Search parameter is wrong");
        log.info("Check search parameter");
        Assert.assertTrue(searchPage.getFirstSearchResult().toLowerCase(Locale.ROOT).contains(firstValue), "Search result is wrong");
        log.info("Check search result");
        searchPage.getSearchFieldAfterReq().clear();
        searchPage.enterValue(secondValue);
        searchPage.enterTextOnSearchFieldAfterReq(secondValue);
        log.info("Enter search value");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
        Assert.assertTrue(driver.getTitle().contains(secondValue), "Title is wrong");
        log.info("Check title");
        Assert.assertTrue(searchPage.getTextFromSearchFieldAfterReq().toLowerCase(Locale.ROOT).contains(secondValue), "Search parameter is wrong");
        log.info("Check search parameter");
        Assert.assertTrue(searchPage.getFirstSearchResult().toLowerCase(Locale.ROOT).contains(secondValue), "Search result is wrong");
        log.info("Check search result");
    }
}
