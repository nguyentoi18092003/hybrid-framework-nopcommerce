package com_nopcommerce_account;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject_factory.CustomerPageObject;
import pageObject_factory.HomePageObject;
import pageObject_factory.LoginPageObject;
import pageObject_factory.RegisterPageObject;

public class Level_06_Selenium_Page_Factory extends BaseTest {
    private WebDriver driver;


    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private LoginPageObject loginPage;
    private CustomerPageObject customerPage;
    private String emailAddress=getEmailRadom();


    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName){
        driver=getBrowserDriver(browserName);


    }
    @Test
    public void Register_01_Empty_Data(){
        homePage=new HomePageObject(driver);
        homePage.clickToRegisterLink();

        registerPage=new RegisterPageObject(driver);

        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getFirstNameErrorMessageText(),"First name is required.");
        Assert.assertEquals(registerPage.getLastNameErrorMessageText(),"Last name is required.");
        Assert.assertEquals(registerPage.getEmailErrorMessageText(),"Email is required.");
        Assert.assertEquals(registerPage.getPasswordErrorMessageText(),"Password is required.");
    }
    @Test
    public void Register_02_Invalid_Email(){
        registerPage.clickToNopCommerceLogo();

        homePage=new HomePageObject(driver);

        homePage.clickToRegisterLink();

        registerPage=new RegisterPageObject(driver);

        registerPage.enterToFirstNameTextbox("John");
        registerPage.enterToLastNameTextbox("Kennedy");
        registerPage.enterToEmailTextbox("john@kennedy@us");
        registerPage.enterToPasswordTextbox("123456");
        registerPage.enterToConfirmPasswordTextbox("123456");

        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getEmailErrorMessageText2(),"Please enter a valid email address.");



    }
    @Test
    public void Register_03_Invalid_Password(){
        registerPage.clickToNopCommerceLogo();

        // tu home page click voa register lonk no se mo ra trang home page
        homePage=new HomePageObject(driver);
        homePage.clickToRegisterLink();

        // tu home page click voa register lonk no se mo ra trang register page
        registerPage=new RegisterPageObject(driver);

        registerPage.enterToFirstNameTextbox("John");
        registerPage.enterToLastNameTextbox("Kennedy");
        registerPage.enterToEmailTextbox("john@gmail.com");
        registerPage.enterToPasswordTextbox("123");
        registerPage.enterToConfirmPasswordTextbox("123");

        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getPasswordErrorMessageText2(),"<p>Password must meet the following rules: </p><ul><li>must have at least 6 characters and not greater than 64 characters</li></ul>");





    }
    @Test
    public void Register_04_Incorrect_Confirm_Password(){
        registerPage.clickToNopCommerceLogo();

        // tu home page click voa register lonk no se mo ra trang home page
        homePage=new HomePageObject(driver);
        homePage.clickToRegisterLink();

        // tu home page click voa register lonk no se mo ra trang register page
        registerPage=new RegisterPageObject(driver);

        registerPage.enterToFirstNameTextbox("John");
        registerPage.enterToLastNameTextbox("Kennedy");
        registerPage.enterToEmailTextbox("john@gmail.com");
        registerPage.enterToPasswordTextbox("123456");
        registerPage.enterToConfirmPasswordTextbox("123533");

        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getConfirmPasswordErrorMessageText(),"The password and confirmation password do not match.");

    }
    @Test
    public void Register_05_Success(){
        registerPage.clickToNopCommerceLogo();

        // tu home page click voa register lonk no se mo ra trang home page
        homePage=new HomePageObject(driver);
        homePage.clickToRegisterLink();

        // tu home page click voa register lonk no se mo ra trang register page
        registerPage=new RegisterPageObject(driver);

        registerPage.enterToFirstNameTextbox("John");
        registerPage.enterToLastNameTextbox("Kennedy");
        registerPage.enterToEmailTextbox(emailAddress);
        registerPage.enterToPasswordTextbox("123456");
        registerPage.enterToConfirmPasswordTextbox("123456");

        registerPage.clickToRegisterButton();

        //chay qya roi lay text de verify voi 1 text ma mk mong doi
        Assert.assertEquals(registerPage.getRegisterSuccessMessageText(),"Your registration completed");

    }
    @Test
    public void User_06_Login_Success(){
        registerPage.clickToNopCommerceLogo();
        // tu home page click voa register lonk no se mo ra trang home page
        homePage=new HomePageObject(driver);

        //click login link
        //homePage.clickToLoginLink();//manual tesst k co buoc nay luon

        //tu trang home mo tr trang login
        //loginPage=new LoginPageObject(driver);//k co

        //input Email/Password
        //loginPage.enterToEmailTextbox(emailAddress);//k co
        //loginPage.enterToEmailPasswordTextbox("123456");//k co

        //loginPage.clickToLoginButton();//k co

        //homePage=new HomePageObject(driver);

        homePage.clickToMyAccountLink();

        customerPage=new CustomerPageObject(driver);

        //Veryfi
        Assert.assertEquals(customerPage.getFirstNameTextboxAttributeValue(),"John");
        Assert.assertEquals(customerPage.getLastNameTextboxAttributeValue(),"Kennedy");
        Assert.assertEquals(customerPage.getEmailAddressTextboxAttributeValue(),emailAddress);

    }
    @AfterClass
    public void afterClass(){
        driver.quit();

    }
}

