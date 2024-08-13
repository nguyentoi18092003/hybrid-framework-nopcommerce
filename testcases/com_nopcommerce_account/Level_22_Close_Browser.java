package com_nopcommerce_account;

import commons.BaseTest;
import commons.PageGeneratortManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects_user.CustomerPageObject;
import pageObjects_user.HomePageObject;
import pageObjects_user.RegisterPageObject;
import pageObjects_user.UserLoginPageObject;

public class Level_22_Close_Browser extends BaseTest {
    private WebDriver driver;


    private HomePageObject homePage;
    private RegisterPageObject registerPage;



    @Parameters({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName, String url){
        //Co tinh viet cho before class bi fali de xe
        driver=getBrowserDriver(browserName,url);
        homePage= PageGeneratortManager.getHomePage(driver);//ben kia de kieu static, nen ham nay dung o class goi dc luon k can phai khoi tao
        registerPage=homePage.clickToRegisterLink();

        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getFirstNameErrorMessageText(),"First name is required..............");
    }
    @Test
    public void Register_01_Empty_Data(){

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
    @Test
    public void User_06_Login_Success(){

    }
    @AfterClass(alwaysRun = true)//alwaysRun = true cx chi dong dc trinh duyet thoi, k dong duco driver trong task Element-> viets ham close browser de dong dc ca 2
    public void afterClass(){
        closeBrowser();

    }
}

