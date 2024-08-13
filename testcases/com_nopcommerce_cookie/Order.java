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

public class Order extends BaseTest {
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

        //co buoc click de vao duoc trang login......

        loginPage.setCookies(driver,Common_Register.cookies);// set luon cookies mk da tao dc o common thay vi phai nhap mat khau password vao nhu binh thuong-> dang nhap thanh cong
        loginPage.sleepInSeconds(5);
        loginPage.refreshCurrentPage(driver);// sau khi refresh xong no se chuyen sang trang thai login thanh cong
        // Chu y k can an nut click login button nhoas

        customerPage=homePage.clickToMyAccountLink();

        Assert.assertEquals(customerPage.getFirstNameTextboxAttributeValue(), Common_Register.firstName);
        Assert.assertEquals(customerPage.getLastNameTextboxAttributeValue(), Common_Register.lastName);
        Assert.assertEquals(customerPage.getEmailAddressTextboxAttributeValue(), Common_Register.emailAddress);

    }
    @Test
    public void Order_01_Invalid_Adress(){

    }
    @Test
    public void Order_02_Invalid_SSN(){

    }
    @Test
    public void Order_03_INvalid_Phone(){

    }
    @Test
    public void Order_04_Sucess(){

    }
    @AfterClass
    public void afterClass(){
        driver.quit();

    }
}

