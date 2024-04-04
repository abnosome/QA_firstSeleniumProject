package com.ait.qa34;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class CreateAccountTests extends TestBase{

    @Test

    public void createNewAccountPositiveTest(){
        Random random = new Random();
       int i = random.nextInt(1000)+1000;

        click(By.cssSelector("[href='/register']"));

        type(By.name("FirstName"), "Martyn");
        type(By.name("LastName"), "Merkelev");
        type(By.name("Email"), "marta" + i+ "@gm.com");

        type(By.id("Password"), "1234Figa!");
        type(By.id("ConfirmPassword"), "1234Figa!");

        click(By.id("register-button"));
        Assert.assertTrue(isElementPresent(By.xpath("//*[contains(@class, 'register-continue-button')]")));
    }
}
