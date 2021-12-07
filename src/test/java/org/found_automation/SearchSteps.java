package org.found_automation;

public class SearchSteps {

    private SearchPage searchPage;

    public SearchSteps(SearchPage searchPage) {
        this.searchPage = searchPage;
    }

    public void checkThatPageIsOpen() {
        searchPage.isPageOpen();
    }
}
