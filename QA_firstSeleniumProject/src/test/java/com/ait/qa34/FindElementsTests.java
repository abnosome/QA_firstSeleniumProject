package com.ait.qa34;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FindElementsTests {
    WebDriver driver;
    @BeforeMethod
    public void SetUp(){
        driver = new ChromeDriver();
        driver.get("https://ilcarro.web.app");
        driver.manage().window().maximize(); //maximize window to screen size
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void findElementByTagName(){
        //find element by tag name
        WebElement element = driver.findElement(By.tagName("h1")); //alt enter introduce new variable
        System.out.println(element.getText());
        WebElement element1 = driver.findElement(By.tagName("a")); // no text in loge - empty string in console
        System.out.println(element1.getText());



        List<WebElement> elements = driver.findElements(By.tagName("a"));
        System.out.println(elements.size());
    }

    @Test
    public void findElementByLocators() {
        //id
        driver.findElement(By.id("city"));
        //class name

    }
    @Test
    public void findElementByCssSelector() {
        //id -> #id
        // driver.findElement(By.id("city"));
        driver.findElement(By.cssSelector("#city"));
        //class name -> .className
        // driver.findElement(By.className("input-container"));
        driver.findElement(By.cssSelector(".input-container"));
        //[name='user']
        driver.findElement(By.cssSelector("[for='city']"));
        driver.findElement(By.cssSelector("[href='/search']"));
        //contains -> *
        driver.findElement(By.cssSelector("[href*='car']"));
        //start -> ^
        driver.findElement(By.cssSelector("[href^='/let']"));
        //end on -> $
        driver.findElement(By.cssSelector("[href$='work']"));
    }

    @Test
    public void findElementByXPath (){
        driver.findElement(By.xpath("//h1"));
        driver.findElement(By.xpath("//*[@id='city']"));
        driver.findElement(By.xpath("//*[contains(@href,'car')]"));
        driver.findElement(By.xpath("//span[text()=' Never mistaken for anything else ']"));
        driver.findElement(By.xpath("//.=' Never mistaken for anything else ']"));
        driver.findElement(By.xpath("//span[contains( .'mistake')]"));
    }

    @AfterMethod
    public  void tearDow(){
        driver.quit();
    }
}
