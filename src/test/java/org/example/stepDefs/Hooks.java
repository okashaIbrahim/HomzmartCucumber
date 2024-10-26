package org.example.stepDefs;

import com.github.javafaker.Faker;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;

public class Hooks {
    public static WebDriver driver;
    public static WebDriverWait wait;

    @Before
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        //ChromeOptions opt = new ChromeOptions();
        //opt.addExtensions(new File("./src/Extensions/adBlocker.crx"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //Thread.sleep(3000);
        //ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        //driver.switchTo().window(tabs.get(1));
        //driver.close();
        //driver.switchTo().window(tabs.get(0));
        driver.get(" https://homzmart.com/en/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
