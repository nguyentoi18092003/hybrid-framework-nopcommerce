package com_nopcommerce_account;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Level_02_BasePage_3_Inheritance extends BasePage{
    WebDriver driver;
    WebDriverWait wait;
   // BasePage basePage=new BasePage();
    private BasePage basePage=BasePage.getBasePage();//day la bieu hien cho ham static
    //co the lam nhu cach tren hoac co the dung cach 2, vi ham getBasePage dc de static nen co the dung truc tiep tu class de goi ham, ma k can dung tu doi tg, co the viest static cho ham khac va dung tuong tu dc

    @BeforeClass
    public void beforeClass(){
        driver=new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Initialize WebDriverWait

    }
    @Test
    public void Register_01_Empty_Data(){
        openPageUrl(driver,"https://demo.nopcommerce.com/");// dung truc tiep ham cua thang cha luon vi no dc ke thua

        basePage.clickToElement(driver,"//a[@class='ico-register']");
        basePage.clickToElement(driver,"//button[@id='register-button']");


        Assert.assertEquals(basePage.getElementText(driver,"//span[@id='FirstName-error']"),"First name is required.");
        Assert.assertEquals(basePage.getElementText(driver,"//span[@id='LastName-error']"),"Last name is required.");
        Assert.assertEquals(basePage.getElementText(driver,"//span[@id='Email-error']"),"Email is required.");
        Assert.assertEquals(basePage.getElementText(driver,"//span[@id='ConfirmPassword-error']"),"Password is required.");

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

