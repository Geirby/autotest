package org.found_automation;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SearchPage {

    public WebDriver driver;

    private String inputValue = "automation";

    public SearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//input[@class='gLFyf gsfi']")
    private WebElement searchField;

    @FindBy(xpath = "//h3")
    private WebElement firstSearchResult;

    @FindBy(xpath = "//input[@class='gNO89b']")
    private WebElement buttonUnderField;

    @FindBy(xpath = "//head/title/text()")
    private WebElement pageTitle;

    public void isPageOpen() {
        Assert.assertTrue(buttonUnderField.isEnabled(), "Button is not found");
    }

    public void enterTextOnSearchField() {
        searchField.sendKeys(inputValue, Keys.ENTER);
    }

    public void textValidationAfterSearch() {
        Assert.assertEquals(searchField.getAttribute("value"), (inputValue), "Search parameter is wrong");
    }

    public void searchResultValidation() {
        Assert.assertTrue(firstSearchResult.getText().contains(inputValue), "Search result is wrong");
    }

    public void checkTitle() {
        Assert.assertTrue(driver.getTitle().contains(inputValue), "Title is wrong");
    }


}
