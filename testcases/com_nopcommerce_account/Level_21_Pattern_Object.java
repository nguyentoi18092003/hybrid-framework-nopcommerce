package com_nopcommerce_account;

import commons.BaseTest;
import commons.PageGeneratortManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects_jquery.PageGeneratorManager;
import pageObjects_user.CustomerPageObject;
import pageObjects_user.HomePageObject;
import pageObjects_user.RegisterPageObject;
import pageObjects_user.UserLoginPageObject;

public class Level_21_Pattern_Object extends BaseTest {
    //Chua test dc vi trang web da duoc thy doi
    private WebDriver driver;


    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private UserLoginPageObject loginPage;
    private CustomerPageObject customerPage;
    private String emailAddress=getEmailRadom();


    @Parameters({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName,String url){
        driver=getBrowserDriver(browserName,url);
        homePage= PageGeneratortManager.getHomePage(driver);//ben kia de kieu static, nen ham nay dung o class goi dc luon k can phai khoi tao
    }
    @Test
    public void Register_01_Empty_Data(){
        homePage.clickToHeaderLinkByName("Register");
        registerPage= PageGeneratortManager.getRegisterPage(driver);

        registerPage.clickToButtonByText("Register");

        //Lam cach khac theo kieu Pattern Object
        Assert.assertEquals(registerPage.getTextboxErrorMessageByID("FirstName"),"First name is required.");
        Assert.assertEquals(registerPage.getTextboxErrorMessageByID("LastName"),"Last name is required.");
        Assert.assertEquals(registerPage.getTextboxErrorMessageByID("LastName"),"Email is required.");
        Assert.assertEquals(registerPage.getTextboxErrorMessageByID("LastName"),"Password is required.");
    }
    @Test
    public void Register_02_Invalid_Email(){
        homePage=registerPage.clickToNopCommerceLogo();

        homePage.clickToHeaderLinkByName("Register");
        registerPage= PageGeneratortManager.getRegisterPage(driver);

        registerPage.enterToTextboxByID("FirstName","John");
        registerPage.enterToTextboxByID("LastName","Kennedy");
        registerPage.enterToTextboxByID("Email","john@kennedy@us");
        registerPage.enterToTextboxByID("Password","123456");
        registerPage.enterToTextboxByID("ConfirmPassword","123456");

        registerPage.clickToButtonByText("Register");

        Assert.assertEquals(registerPage.getTextboxErrorMessageByID("Email"),"Wrong email");

    }
    @Test
    public void Register_03_Invalid_Password(){
        homePage=registerPage.clickToNopCommerceLogo();

        homePage.clickToHeaderLinkByName("Register");
        registerPage= PageGeneratortManager.getRegisterPage(driver);

        registerPage.enterToTextboxByID("FirstName","John");
        registerPage.enterToTextboxByID("LastName","Kennedy");
        registerPage.enterToTextboxByID("Email","john@gmail.com");
        registerPage.enterToTextboxByID("Password","123");
        registerPage.enterToTextboxByID("ConfirmPassword","123");

        registerPage.clickToButtonByText("Register");

        Assert.assertEquals(registerPage.getTextboxErrorMessageByID("Password"),"<p>Password must meet the following rules: </p><ul><li>must have at least 6 characters and not greater than 64 characters</li></ul>");

    }
    @Test
    public void Register_04_Incorrect_Confirm_Password(){
        homePage =registerPage.clickToNopCommerceLogo();

        homePage.clickToHeaderLinkByName("Register");
        registerPage= PageGeneratortManager.getRegisterPage(driver);

        registerPage.enterToTextboxByID("FirstName","John");
        registerPage.enterToTextboxByID("LastName","Kennedy");
        registerPage.enterToTextboxByID("Email","john@gmail.com");
        registerPage.enterToTextboxByID("Password","123456");
        registerPage.enterToTextboxByID("ConfirmPassword","123456645");

        registerPage.clickToButtonByText("Register");

        Assert.assertEquals(registerPage.getTextboxErrorMessageByID("ConfirmPassword"),"The password and confirmation password do not match.");

    }
    @Test
    public void Register_05_Success(){
        homePage=registerPage.clickToNopCommerceLogo();

        homePage.clickToHeaderLinkByName("Register");
        registerPage= PageGeneratortManager.getRegisterPage(driver);

        registerPage.enterToTextboxByID("FirstName","John");
        registerPage.enterToTextboxByID("LastName","Kennedy");
        registerPage.enterToTextboxByID("Email",emailAddress);
        registerPage.enterToTextboxByID("Password","123456");
        registerPage.enterToTextboxByID("ConfirmPassword","123456");


        registerPage.clickToButtonByText("Register");

        //chay qya roi lay text de verify voi 1 text ma mk mong doi
        Assert.assertEquals(registerPage.getRegisterSuccessMessageText(),"Your registration completed");

    }
    @Test
    public void User_06_Login_Success(){
        homePage=registerPage.clickToNopCommerceLogo();

        homePage.clickToHeaderLinkByName("My account");
        customerPage= PageGeneratortManager.getCustomerPage(driver);


        Assert.assertEquals(customerPage.getTextboxAttributeValue("FristName"),"John");
        Assert.assertEquals(customerPage.getTextboxAttributeValue("LastName"),"Kennedy");
        Assert.assertEquals(customerPage.getTextboxAttributeValue("Email"),emailAddress);


    }
    @AfterClass
    public void afterClass(){
        driver.quit();

    }
}

