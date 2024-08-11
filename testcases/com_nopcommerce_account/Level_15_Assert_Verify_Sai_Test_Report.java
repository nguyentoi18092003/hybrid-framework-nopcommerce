package com_nopcommerce_account;

import commons.BaseTest;
import commons.PageGeneratortManager;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject_28tech.HomePage28techObject;
import pageObjects_user.CustomerPageObject;
import pageObjects_user.HomePageObject;
import pageObjects_user.RegisterPageObject;
import pageObjects_user.UserLoginPageObject;

public class Level_15_Assert_Verify_Sai_Test_Report extends BaseTest {
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
    public void Register_01_Empty_Data_Fail(){


//        //dang loi do k hieu sao luc mo trinh duyet len no bi hien thi them buco xac minh con nguoi, (go xong het r, h chi chay thoi)lan sau vao test lai video thu topic 76, 1:07:00
//        verifyFalse(homePage.isRegisterLinkDisplayed());//thuc te no co hien thi nhung mk co tinh check k hien thi->FAILED
//        registerPage=homePage.clickToRegisterLink();
//
//        //Vrify error messagea at FirstName textbox ->PASSED
//        registerPage.clickToRegisterButton();
//        verifyEquals(registerPage.getFirstNameErrorMessageText(),"First name is required.");
//
//        //Vrify error messagea at FirstName textbox ->FALIED
//        verifyEquals(registerPage.getFirstNameErrorMessageText(),"First name is required.heh");
//
//
//        registerPage.enterToFirstNameTextbox("John");
//        registerPage.enterToLastNameTextbox("Kennedy");
//        registerPage.enterToEmailTextbox("toi@gmail.com");
//        registerPage.enterToPasswordTextbox("123456");
//        registerPage.enterToConfirmPasswordTextbox("123456");
//
//        registerPage.clickToRegisterButton();
//
//        //verify success message ->FAIL
//        verifyEquals(registerPage.getRegisterSuccessMessageText(),"Your registration completed hehe");

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
public void Register_02_Empty_Data_Pass(){
    log.info("User_01- Step 01: Verify Title is displayed");
    verifyTrue(homePage28tech.isTitleDisPlayed());

    log.info("User_01- Step 01: Verify Title ");
    verifyEquals(homePage28tech.getTextFooter("Về chúng tôi"),"Về chúng tôi");

    log.info("User_01- Step 02: Verify TextFooter1 ");
    verifyEquals(homePage28tech.getTextFooter("Điều khoản dịch vụ"),"Điều khoản dịch vụ");

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

