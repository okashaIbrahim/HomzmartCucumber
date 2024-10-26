package org.example.pages;

import com.github.javafaker.Faker;
import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class P002_kitchenStoragePage {
    public P002_kitchenStoragePage() {
        PageFactory.initElements(Hooks.driver, this);
    }

    Faker faker = new Faker();
    @FindBy(xpath = "//*[@class=\"listing__card\"]/div")
    public List<WebElement> productOptions;
    @FindBy(xpath = "//*[@class=\"default__siteHeader\"]/div[1]/div[2]/div[3]/div/div[1]/div")
    public WebElement languageDropDown;
    @FindBy(xpath = "//*[@id=\"HEADER_CART_BRIEF_ICON\"]")
    public WebElement cartPreviewButton;
    @FindBy(xpath = "//*[@class=\"cart__detailsScroll\"]/div[3]/div/div/div[2]/a")
    public WebElement productOneName;
    @FindBy(xpath = "//*[@class=\"cart__detailsScroll\"]/div[3]/div/div/div[2]/div[2]/p/span")
    public WebElement productOnePrice;
    @FindBy(xpath = "//*[@class=\"cart__detailsScroll\"]/div[4]/div/div/div[2]/a")
    public WebElement productTwoName;
    @FindBy(xpath = "//*[@class=\"cart__detailsScroll\"]/div[4]/div/div/div[2]/div[2]/p/span")
    public WebElement productTwoPrice;
    @FindBy(xpath = "//*[@class=\"cart__detailsScroll\"]/div[2]/div/b")
    public WebElement subTotalPrice;
    @FindBy(xpath = "")
    public WebElement test;

    public WebElement getRandomProduct1(){
        int productSize = productOptions.size();
        int randomProduct1 = faker.number().numberBetween(1, productSize+1);
        WebElement product1 = Hooks.driver.findElement(By.xpath("//*[@class=\"productCard__container card-item\"][" + randomProduct1 + "]"));;
        return  product1;
    }

    public WebElement getRandomProduct2(){
        int productSize = productOptions.size();
        int randomProduct2 = faker.number().numberBetween(1, productSize+1);
        WebElement product2 = Hooks.driver.findElement(By.xpath("//*[@class=\"productCard__container card-item\"][" + randomProduct2 + "]"));;
        return  product2;
    }


}
