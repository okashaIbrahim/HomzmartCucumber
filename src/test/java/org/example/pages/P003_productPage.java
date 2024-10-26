package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P003_productPage {
    public P003_productPage() {
        PageFactory.initElements(Hooks.driver, this);
    }

    @FindBy(xpath = "//*[@class=\"button-with-icon default-bg fullWidth\"]")
    public WebElement addToCartButton;
    @FindBy(xpath = "//*[@class=\"cartItem__containerr orders-card-items\"]")
    public WebElement productsInCart;
    @FindBy(xpath = "//*[@class=\"hz-font-w-bold hz-fs-24 head\"]")
    public WebElement productName;
    @FindBy(xpath = "//*[@class=\"productPrices__container price-section-PDP\"]/div[1]/div[1]/p")
    public WebElement productPrice;
    @FindBy(xpath = "")
    public WebElement test;

}
