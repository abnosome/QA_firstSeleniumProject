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

public class FindElementsHW {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com");
        driver.manage().window().maximize(); //maximize window to screen size
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void findElemByTag(){
        List<WebElement> elements = driver.findElements(By.tagName("h3"));
        System.out.println(elements.size());

        List<WebElement> elements2 = driver.findElements(By.tagName("h1"));
        System.out.println(elements2.size());

        List<WebElement> elements3 = driver.findElements(By.tagName("li"));
        System.out.println(elements3.size());
    }

    @Test
    public void findElementByCssSelector() {

        driver.findElement(By.cssSelector("#subscribe-loading-progress"));
        driver.findElement(By.cssSelector("#newsletter-subscribe-block"));
        driver.findElement(By.cssSelector(".listbox"));
        driver.findElement(By.cssSelector("[href='/register']"));
        driver.findElement(By.cssSelector("[href*='cart']"));
        driver.findElement(By.cssSelector("[href^='/log']"));
        driver.findElement(By.cssSelector("[href$='shoes']"));
    }

    @Test
    public void findElementByXpath() {
        driver.findElement(By.xpath("//*[@id='subscribe-loading-progress']"));
        driver.findElement(By.xpath("//*[@id='newsletter-subscribe-block']"));
        driver.findElement(By.xpath("//*[@class='listbox']"));
        driver.findElement(By.xpath("//*[@href='/register']"));
        driver.findElement(By.xpath("//*[contains(@href, 'cart')]"));
        driver.findElement(By.xpath("//*[starts-with(@href, '/log')]"));
        driver.findElement(By.xpath("//*[substring(@href, string-length(@href) - string-length('shoes') +1) = 'shoes']"));


    }

    @AfterMethod
    public  void tearDow(){
        driver.quit();
    }

}
