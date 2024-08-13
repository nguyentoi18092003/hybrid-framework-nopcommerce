package com_nopcommnerce_share;

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

        //Se co 1 doan dang nhap o day , dang nhap xong moi nhay xuong buoc nay vi trang bi thay doi nen chua viet+test dc
        //.....................................
        customerPage=homePage.clickToMyAccountLink();

        Assert.assertEquals(customerPage.getFirstNameTextboxAttributeValue(),Common_Register.firstName);
        Assert.assertEquals(customerPage.getLastNameTextboxAttributeValue(),Common_Register.lastName);
        Assert.assertEquals(customerPage.getEmailAddressTextboxAttributeValue(),Common_Register.emailAddress);

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

