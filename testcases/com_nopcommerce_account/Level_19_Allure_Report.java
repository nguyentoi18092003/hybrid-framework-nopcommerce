package com_nopcommerce_account;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import commons.PageGeneratortManager;
import io.qameta.allure.*;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject_28tech.HomePage28techObject;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;


@Epic("Account")
@Feature("Create Account")
public class Level_19_Allure_Report extends BaseTest {
    private WebDriver driver;
    private String browserName;

//    private HomePageObject homePage;
//    private RegisterPageObject registerPage;
    private HomePage28techObject homePage28tech;







    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName){
        this.browserName=browserName;

        driver=getBrowserDriver(browserName);


        //homePage= PageGeneratortManager.getHomePage(driver);
        //homePage.openPageUrl(driver,"https://demo.nopcommerce.com/");
        homePage28tech=PageGeneratortManager.gethomePage28tech(driver);

    }
    @Description("User01- Validate register form")
    @Story("register")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void Register_01_Empty_Data_Fail_Veryfy( ){


        //veryfi button register hien thi-> thuc the co hien thi nhung mk check la false->FALSE;
        verifyTrue(homePage28tech.isTitleDisPlayed());

//        homePage28tech.enterToRegisterTextBox("sdfasdf");
//        homePage28tech.clickToRegisterButton();

        //True
        //verifyEquals(homePage28tech.getTextErrorMessage(),"Số điện thoại chưa chính xác");

        verifyEquals(homePage28tech.getTextFooter("Về chúng tôi"),"Về chúng tôi");

        verifyEquals(homePage28tech.getTextFooter("Điều khoản dịch vụ"),"Điều khoản dịch vụ");

        verifyEquals(homePage28tech.getTextFooter("Chính sách bảo mật"),"Chính sách bảo mật");

        verifyEquals(homePage28tech.getTextFooter("Hướng dẫn thanh toán"),"Hướng dẫn thanh toán");

    }
    @Description("User01- Register success hehe")
    @Story("register")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void Register_02_Empty_Data_Fail_Assert(){
        //assert no chup duco het tat ca cac loi sai, con verify o tren chi chup dc loi sia cuoi cx



        //veryfi button register hien thi-> thuc the co hien thi nhung mk check la false->FALSE;
        Assert.assertFalse(homePage28tech.isTitleDisPlayed());

//        homePage28tech.enterToRegisterTextBox("sdfasdf");
//        homePage28tech.clickToRegisterButton();

        //True
        //verifyEquals(homePage28tech.getTextErrorMessage(),"Số điện thoại chưa chính xác");

        verifyEquals(homePage28tech.getTextFooter("Về chúng tôi"),"Về chúng tôi");

        Assert.assertEquals(homePage28tech.getTextFooter("Điều khoản dịch vụ"),"Điều khoản dịch vụ sadjfk");

        verifyEquals(homePage28tech.getTextFooter("Chính sách bảo mật"),"Chính sách bảo mật");

        verifyEquals(homePage28tech.getTextFooter("Hướng dẫn thanh toán"),"Hướng dẫn thanh toán");

    }

    @AfterClass
    public void afterClass(){
        driver.quit();

    }
}

