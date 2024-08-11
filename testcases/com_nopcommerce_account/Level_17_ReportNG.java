package com_nopcommerce_account;

import commons.BaseTest;
import commons.PageGeneratortManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject_28tech.HomePage28techObject;

public class Level_17_ReportNG extends BaseTest {
    private WebDriver driver;

//    private HomePageObject homePage;
//    private RegisterPageObject registerPage;
    private HomePage28techObject homePage28tech;







    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName){
        driver=getBrowserDriver(browserName);


        //homePage= PageGeneratortManager.getHomePage(driver);
        //homePage.openPageUrl(driver,"https://demo.nopcommerce.com/");
        homePage28tech=PageGeneratortManager.gethomePage28tech(driver);

    }

    @Test
    public void Register_01_Empty_Data_Fail_Veryfy(){



        //veryfi button register hien thi-> thuc the co hien thi nhung mk check la false->FALSE;
        log.info("User_01- Step 01: Verify Title is displayed");
        verifyFalse(homePage28tech.isTitleDisPlayed());

//        homePage28tech.enterToRegisterTextBox("sdfasdf");
//        homePage28tech.clickToRegisterButton();

        //True
        //verifyEquals(homePage28tech.getTextErrorMessage(),"Số điện thoại chưa chính xác");

        log.info("User_01- Step 01: Verify Title ");
        verifyEquals(homePage28tech.getTextFooter("Về chúng tôi"),"Về chúng tôi");

        log.info("User_01- Step 02: Verify TextFooter1 ");
        verifyEquals(homePage28tech.getTextFooter("Điều khoản dịch vụ"),"Điều khoản dịch vụ sadjfk");

        log.info("User_01- Step 03: Verify TextFooter2 ");
        verifyEquals(homePage28tech.getTextFooter("Chính sách bảo mật"),"Chính sách bảo mật");

        log.info("User_01- Step 04: Verify TextFooter13 ");
        verifyEquals(homePage28tech.getTextFooter("Hướng dẫn thanh toán"),"Hướng dẫn thanh toán");

    }
    @Test
    public void Register_02_Empty_Data_Fail_Assert(){
        //assert no chup duco het tat ca cac loi sai, con verify o tren chi chup dc loi sia cuoi cx



        //veryfi button register hien thi-> thuc the co hien thi nhung mk check la false->FALSE;
        log.info("User_01- Step 01: Verify Title is displayed");
        Assert.assertFalse(homePage28tech.isTitleDisPlayed());

//        homePage28tech.enterToRegisterTextBox("sdfasdf");
//        homePage28tech.clickToRegisterButton();

        //True
        //verifyEquals(homePage28tech.getTextErrorMessage(),"Số điện thoại chưa chính xác");

        log.info("User_01- Step 01: Verify Title ");
        verifyEquals(homePage28tech.getTextFooter("Về chúng tôi"),"Về chúng tôi");

        log.info("User_01- Step 02: Verify TextFooter1 ");
        Assert.assertEquals(homePage28tech.getTextFooter("Điều khoản dịch vụ"),"Điều khoản dịch vụ sadjfk");

        log.info("User_01- Step 03: Verify TextFooter2 ");
        verifyEquals(homePage28tech.getTextFooter("Chính sách bảo mật"),"Chính sách bảo mật");

        log.info("User_01- Step 04: Verify TextFooter13 ");
        verifyEquals(homePage28tech.getTextFooter("Hướng dẫn thanh toán"),"Hướng dẫn thanh toán");

    }

    @AfterClass
    public void afterClass(){
        driver.quit();

    }
}

