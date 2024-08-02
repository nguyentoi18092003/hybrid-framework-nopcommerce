package com_nopcommerce_account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Level_01_DRY {
    WebDriver driver;
    WebDriverWait wait;


    @BeforeClass
    public void beforeClass(){
        driver=new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Initialize WebDriverWait

    }
    @Test
    public void Register_01_Empty_Data(){
        driver.get("https://demo.nopcommerce.com/");

        driver.findElement(By.cssSelector("a.ico-register")).click();
        driver.findElement(By.cssSelector("button#register-button")).click();


        Assert.assertEquals(driver.findElement(By.cssSelector("span#FirstName-error")).getText(),"First name is required.");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#LastName-error")).getText(),"Last name is required.");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#Email-error")).getText(),"Email is required.");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#ConfirmPassword-error")).getText(),"Password is required.");


    }
    @Test
    public void Register_02_Invalid_Email(){

    }
    @Test
    public void Register_03_Invalid_Password(){

    }
    @Test
    public void Register_04_Incorrect_Confirm_Password(){

    }
    @Test
    public void Register_05_Success(){

    }
    @AfterClass
    public void afterClass(){
        driver.quit();

    }
    public void sleepInSeconds(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public String getEmailAddress() {
        return "automation"+ new Random().nextInt(99999)+ "@gmail.com";
    }
}

