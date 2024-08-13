package com_nopcommerce_cookie;

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

public class Payment extends BaseTest {
    private WebDriver driver;


    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private UserLoginPageObject loginPage;
    private CustomerPageObject customerPage;
    private String emailAddress=getEmailRadom();


    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName){
        driver=getBrowserDriver(browserName);
        homePage= PageGeneratortManager.getHomePage(driver);//ben kia de kieu static, nen ham nay dung o class goi dc luon k can phai khoi tao

        //co buoc click de vao duoc trang login......hoac o day  viet them ham mo url trang dang nhap nhu vay thi k can click

        loginPage.setCookies(driver,Common_Register.cookies);// set luon cookies mk da tao dc o common thay vi phai nhap mat khau password vao nhu binh thuong-> dang nhap thanh cong
        loginPage.sleepInSeconds(10);
        loginPage.refreshCurrentPage(driver);// sau khi refresh xong no se chuyen sang trang thai login thanh cong
        // Chu y k can an nut click login button nhoas

        customerPage=homePage.clickToMyAccountLink();

        Assert.assertEquals(customerPage.getFirstNameTextboxAttributeValue(), Common_Register.firstName);
        Assert.assertEquals(customerPage.getLastNameTextboxAttributeValue(), Common_Register.lastName);
        Assert.assertEquals(customerPage.getEmailAddressTextboxAttributeValue(), Common_Register.emailAddress);

    }
    @Test
    public void Payment_01_Visa(){

    }
    @Test
    public void Payment_02_Cheque(){

    }
    @Test
    public void Payemnt_03_Paypal(){

    }
    @Test
    public void Payemnt_04_Bitcoin(){

    }
    @AfterClass
    public void afterClass(){
        driver.quit();

    }
}

