package com.ait.qa34;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddItemToCart extends TestBase {

    @BeforeMethod
    public void ensurePrecondition(){
        login();
    }

    @Test
    public void AddItemToCart(){
        AddItem();
        goToCart();
        Assert.assertTrue(isElementPresent(By.cssSelector("[href='/141-inch-laptop']")));
    }
}
