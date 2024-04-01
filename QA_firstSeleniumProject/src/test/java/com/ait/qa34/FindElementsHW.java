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

    @AfterMethod

    public  void tearDow(){
        driver.quit();
    }
}
