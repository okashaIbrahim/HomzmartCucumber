package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P001_homePage;
import org.example.pages.P002_kitchenStoragePage;
import org.example.pages.P003_productPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class D001_homePage {
    P001_homePage home = new P001_homePage();
    P002_kitchenStoragePage kit = new P002_kitchenStoragePage();
    P003_productPage pro = new P003_productPage();
    WebDriverWait wait;
    Actions action = new Actions(Hooks.driver);
    SoftAssert soft = new SoftAssert();


    public String product1Name;
    public String product1Price;
    public String product2Name;
    public String product2Price;
    public String product1NameInCart;
    public String product1PriceInCart;
    public String product2NameInCart;
    public String product2PriceInCart;


    @Given("User go to home page")
    public void verifyThatHomePagevisible() {
        soft.assertEquals(Hooks.driver.getCurrentUrl(), "https://homzmart.com/en/", "Wrong URL");
        soft.assertAll();
    }

    @When("User hover on \"Storage\"")
    public void userHoverOnStorageDropDown() throws InterruptedException {
        action.moveToElement(home.kitchenStorage).perform();

    }

    @Then("dropdown menu appears and including \"Kitchen Storage\" subcategory")
    public void kitchenStorageShouldDisplay() {
        soft.assertTrue(home.kitchenStorageButton.isDisplayed(), "Wrong category");
        soft.assertAll();
    }

    @When("User click on “Kitchen Storage” and choose two products and add them to cart")
    public void userChooseTwoRandomProducts() throws InterruptedException {
        wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(home.kitchenStorageButton));
        home.kitchenStorageButton.click();
        kit.languageDropDown.click();
        wait.until(ExpectedConditions.visibilityOfAllElements(kit.productOptions));
        WebElement p1 = kit.getRandomProduct1();
        action.moveToElement(p1).perform();
        wait.until(ExpectedConditions.elementToBeClickable(p1));
        p1.click();
        product1Name = pro.productName.getText();
        product1Price = pro.productPrice.getText();
        product1Price = product1Price.replace(",", "");
        product1Price = product1Price.replaceAll("\\.00", "");
        int p1Price = Integer.parseInt(product1Price);
        System.out.println(product1Name + " " + p1Price);
        pro.addToCartButton.click();
        Hooks.driver.navigate().back();
        wait.until(ExpectedConditions.visibilityOfAllElements(kit.productOptions));
        WebElement p2 = kit.getRandomProduct2();
        action.moveToElement(p2).perform();
        wait.until(ExpectedConditions.elementToBeClickable(p2));
        p2.click();
        product2Name = pro.productName.getText();
        product2Price = pro.productPrice.getText();
        product2Price = product2Price.replace(",", "");
        product2Price = product2Price.replaceAll("\\.00", "");
        int p2Price = Integer.parseInt(product2Price);
        System.out.println(product2Name + " " + p2Price);
        pro.addToCartButton.click();

    }

    @And("User open the cart preview")
    public void openCart() {
        kit.cartPreviewButton.click();
        wait.until(ExpectedConditions.visibilityOfAllElements(pro.productsInCart));
        product1NameInCart = kit.productOneName.getText();
        product1PriceInCart = kit.productOnePrice.getText();
        product1PriceInCart = product1PriceInCart.replace(",", "");
        product1PriceInCart = product1PriceInCart.replaceAll("\\.00", "");
        int p1PriceInCart = Integer.parseInt(product1PriceInCart);
        product2NameInCart = kit.productTwoName.getText();
        product2PriceInCart = kit.productTwoPrice.getText();
        product2PriceInCart = product2PriceInCart.replace(",", "");
        product2PriceInCart = product2PriceInCart.replaceAll("\\.00", "");
        int p2PriceInCart = Integer.parseInt(product2PriceInCart);
        System.out.println(product1NameInCart + " " + p1PriceInCart);
        System.out.println(product2NameInCart + " " + p2PriceInCart);
    }

    @Then("Compare every product’s name and price in the cart with product details and check that the total price in the cart is calculated correctly.")
    public void compareProducts() {
        soft.assertEquals(product1Name, product1NameInCart);
        soft.assertEquals(product1Price, product1PriceInCart);
        soft.assertEquals(product2Name, product2NameInCart);
        soft.assertEquals(product2Price, product2PriceInCart);
        soft.assertAll();
    }
}
