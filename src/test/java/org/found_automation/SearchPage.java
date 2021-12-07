package org.found_automation;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SearchPage {

    public WebDriver driver;

    public SearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "text")
    private WebElement searchField;

    @FindBy(className = "OrganicTitleContentSpan")
    private WebElement firstSearchResult;

    @FindBy(xpath = "//head/title/text()")
    private WebElement pageTitle;

    @FindBy(id = "uniq16385244871821")
    private WebElement searchFieldAfterReq;

    @FindBy(xpath ="//span/span/span" )
    private WebElement clearIcon;

    public void isPageOpen() {
        Assert.assertTrue(searchField.isEnabled(), "Logo is not found");
    }
    public String enterValue(String value) {
        return value;
    }

    public void enterTextOnSearchField(String value) {
        searchField.sendKeys(value, Keys.ENTER);
    }

    public void enterTextOnSearchFieldAfterReq(String value) {
        searchFieldAfterReq.sendKeys(value, Keys.ENTER);
    }

    public String getFirstSearchResult() {
       return firstSearchResult.getText();
    }

    public String getTextFromSearchFieldAfterReq() {
        return searchFieldAfterReq.getAttribute("value");
    }

    public WebElement getClearIcon(){
        return getClearIcon();
    }

    public WebElement getSearchFieldAfterReq(){
        return searchFieldAfterReq;
    }
}
