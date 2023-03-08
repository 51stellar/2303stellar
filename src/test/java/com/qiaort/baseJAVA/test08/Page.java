package com.qiaort.baseJAVA.test08;

import java.util.List;

public class Page {
    private String keyword;
    private List<Locator> locators;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public List<Locator> getLocators() {
        return locators;
    }

    public void setLocators(List<Locator> locators) {
        this.locators = locators;
    }
}
