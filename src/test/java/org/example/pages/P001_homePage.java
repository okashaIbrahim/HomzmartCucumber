package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P001_homePage {
    public P001_homePage() {
        PageFactory.initElements(Hooks.driver, this);
    }

    @FindBy(xpath = "//*[@class=\"default__siteHeader\"]/div[2]/div/div[2]/div/a")
    public WebElement kitchenStorage;
    @FindBy(xpath = "//*[@id=\"HEADER_MENU_BAR_SUBCATEGORY_5\"]//a")
    public WebElement kitchenStorageButton;
    @FindBy(xpath = "")
    public WebElement test;

}
