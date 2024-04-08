package com.ait.qa34;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {

    WebDriver driver;


    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public boolean isElementPresent(By locator){
        return driver.findElements(locator).size()>0;
    }

    @AfterMethod(enabled = false)
    public  void tearDow(){
        driver.quit();

    }

    public void type(By locator, String text) {
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public boolean isAlertPresent() {
        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.alertIsPresent());
        if(alert == null){
            return false;
        }
        return true;
    }

    public void fillRegisterForm() {
        type(By.name("FirstName"), "Mikghail");
        type(By.name("LastName"), "Lovgfe");
        type(By.name("Email"), "martaLgovef@gm.com");

        type(By.id("Password"), "1234Figa!");
        type(By.id("ConfirmPassword"), "1234Figa!");
    }

    public void clickOnRegisterButton() {
        click(By.id("register-button"));
    }

    public void clickOnRegisterLink() {
        click(By.cssSelector("[href='/register']"));
    }

    protected void login() {
        click(By.cssSelector("[href='/login']"));
        type(By.name("Email"), "martaLgovef@gm.com");
        type(By.id("Password"), "1234Figa!");
        click(By.cssSelector(".button-1.login-button"));
    }

    protected void goToCart() {
        click(By.cssSelector("[href='/cart']"));
    }

    public void AddItem() {
        click(By.cssSelector("div.item-box:nth-child(3) input.button-2.product-box-add-to-cart-button"));
    }
}
