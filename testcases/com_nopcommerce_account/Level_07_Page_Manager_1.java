package com_nopcommerce_account;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.CustomerPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

public class Level_07_Page_Manager_1 extends BaseTest {
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
        //Mo Url ra no o page nao-> Khoi tao page do len
        //tu 1 page nay chuyen qua page kia-> khoi tao page do len
        homePage=new HomePageObject(driver);
        homePage.clickToRegisterLink();

        //Tu HomePage click vao RegisterLink no se mo ra trang register Page-> Khoi tao Page do len
        registerPage=new RegisterPageObject(driver);

        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getFirstNameErrorMessageText(),"First name is required.");
        Assert.assertEquals(registerPage.getLastNameErrorMessageText(),"Last name is required.");
        Assert.assertEquals(registerPage.getEmailErrorMessageText(),"Email is required.");
        Assert.assertEquals(registerPage.getPasswordErrorMessageText(),"Password is required.");

//        openPageUrl(driver,"https://demo.nopcommerce.com/");// dung truc tiep ham cua thang cha luon vi no dc ke thua
//
//        basePage.clickToElement(driver,"//a[@class='ico-register']");
//        basePage.clickToElement(driver,"//button[@id='register-button']");
//
//
//        Assert.assertEquals(basePage.getElementText(driver,"//span[@id='FirstName-error']"),"First name is required.");
//        Assert.assertEquals(basePage.getElementText(driver,"//span[@id='LastName-error']"),"Last name is required.");
//        Assert.assertEquals(basePage.getElementText(driver,"//span[@id='Email-error']"),"Email is required.");
//        Assert.assertEquals(basePage.getElementText(driver,"//span[@id='ConfirmPassword-error']"),"Password is required.");

    }
    @Test
    public void Register_02_Invalid_Email(){
        registerPage.clickToNopCommerceLogo();

        //dang tu register page click vao logo thi no mo ra trang home lai

        homePage=new HomePageObject(driver);

        homePage.clickToRegisterLink();

        // tu home page click voa register lonk no se mo ra trang register page
        registerPage=new RegisterPageObject(driver);

        registerPage.enterToFirstNameTextbox("John");
        registerPage.enterToLastNameTextbox("Kennedy");
        registerPage.enterToEmailTextbox("john@kennedy@us");
        registerPage.enterToPasswordTextbox("123456");
        registerPage.enterToConfirmPasswordTextbox("123456");

        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getEmailErrorMessageText(),"Please enter a valid email address.");



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

