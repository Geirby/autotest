package org.found_automation;

import static org.found_automation.SearchTest.driver;

public class SearchSteps {

    SearchPage searchPage = new SearchPage(driver);

    public SearchSteps(SearchPage searchPage) {

    }

    public void checkThatPageIsOpen() {
        searchPage.isPageOpen();
    }

    public void titleOfPageIsCorrect() {
        searchPage.checkTitle();
    }

    public void searchRequestIsCorrect() {
        searchPage.textValidationAfterSearch();
    }

    public void searchResultIsCorrect() {
        searchPage.searchResultValidation();
    }

    public void enterSearchValue() {
        searchPage.enterTextOnSearchField();
    }


}
