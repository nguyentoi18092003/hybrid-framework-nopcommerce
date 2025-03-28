package com_nopcommerce_account;

import commons.BaseTest;
import commons.PageGeneratortManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects_user.*;

public class Level_08_Switch_Page extends BaseTest {
    private WebDriver driver;


    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private UserLoginPageObject loginPage;
    private CustomerPageObject customerPage;
    private AddressPageObject addressPage;
    private OrderPageObject orderPage;
    private RewardPointPageObject rewardPointPage;
    private String emailAddress=getEmailRadom();




    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName){
        driver=getBrowserDriver(browserName);
        homePage= PageGeneratortManager.getHomePage(driver);//ben kia de kieu static, nen ham nay dung o class goi dc luon k can phai khoi tao
    }

    @Test
    public void User_01_Register_Success(){
        registerPage=homePage.clickToRegisterLink();

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
    public void User_02_Login_Success(){
        homePage=registerPage.clickToNopCommerceLogo();

        customerPage=homePage.clickToMyAccountLink();

        Assert.assertEquals(customerPage.getFirstNameTextboxAttributeValue(),"John");
        Assert.assertEquals(customerPage.getLastNameTextboxAttributeValue(),"Kennedy");
        Assert.assertEquals(customerPage.getEmailAddressTextboxAttributeValue(),emailAddress);

    }

    @Test
    public void User_03_Switch_Page(){
        //Customer Page-> AddressPage();
        addressPage=customerPage.openAddressPage();

        //Customer Page-> Order Page
        orderPage=addressPage.openOrderPage();

        //Order Page-> Address Page
        customerPage=orderPage.openCustomerPage();

        //Customer Page-> Order Page
        orderPage=customerPage.openOrderPage();

        addressPage=orderPage.openAddressPage();

        rewardPointPage=addressPage.openRewardPointPage();

        customerPage=rewardPointPage.openCustomerPage();

        rewardPointPage=customerPage.openRewardPointPage();




    }

    @AfterClass
    public void afterClass(){
        driver.quit();

    }
}

