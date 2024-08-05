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

public class Level_12_Dynamic_Locator_Rest_Param extends BaseTest {
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
        addressPage=(AddressPageObject) customerPage.openDynamicSideBarPage("Addresses");

        //Customer Page-> Order Page
        orderPage=(OrderPageObject) addressPage.openDynamicSideBarPage("Orders");

        //Order Page-> Address Page
        customerPage=(CustomerPageObject) orderPage.openDynamicSideBarPage("Customer info");

        //Customer Page-> Order Page
        orderPage=(OrderPageObject) customerPage.openDynamicSideBarPage("Orders");

        addressPage=(AddressPageObject) orderPage.openDynamicSideBarPage("Addresses");

        rewardPointPage=(RewardPointPageObject) addressPage.openDynamicSideBarPage("Reward points");

        customerPage=(CustomerPageObject) rewardPointPage.openDynamicSideBarPage("Customer info");

        rewardPointPage=(RewardPointPageObject) customerPage.openDynamicSideBarPage("Reward points");

    }
    @Test
    public void User_04_Switch_Page(){
        //cach nay khac cách tren ra la mo xong r ms khoi tao-
        //Khong nen dung giong nhu tesst 03 ben tren ma nen dung giong duoi nay

        rewardPointPage.openDynamicSideBarPageByName("Customer info");
        customerPage=PageGeneratortManager.getCustomerPage(driver);

         customerPage.openDynamicSideBarPageByName("Addresses");
         addressPage=PageGeneratortManager.getAddressPage(driver);

         addressPage.openDynamicSideBarPage("Orders");
         orderPage=PageGeneratortManager.getOrderPage(driver);




    }

    @AfterClass
    public void afterClass(){
        driver.quit();

    }
}

