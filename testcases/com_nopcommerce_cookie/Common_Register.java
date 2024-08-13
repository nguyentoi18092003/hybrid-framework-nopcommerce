package com_nopcommerce_cookie;

import commons.BaseTest;
import commons.PageGeneratortManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import pageObjects_user.CustomerPageObject;
import pageObjects_user.HomePageObject;
import pageObjects_user.RegisterPageObject;

import java.util.Set;

public class Common_Register extends BaseTest {
    private WebDriver driver;


    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private String password;
    private CustomerPageObject customerPage;
    public static String emailAddress,firstName,lastName;

    //bien lay de lat nua dang ki xong mk se luu lai cookies sau nay chi can refrash lai no se tu dong dang nhap cho mk ma mk k can buwoc dang nhap nua
    public static Set<Cookie>  cookies;


    @Parameters("browser")
    @BeforeTest
    public void beforeTest(String browserName){
        //Chuwa test dc,  chu y trnag nao nhan cookie thi dung cach nafy dc
        driver=getBrowserDriver(browserName);
        homePage= PageGeneratortManager.getHomePage(driver);//ben kia de kieu static, nen ham nay dung o class goi dc luon k can phai khoi tao

        emailAddress=getEmailRadom();
        password="123456";
        firstName="John";
        lastName="Kennedy";

        registerPage=homePage.clickToRegisterLink();

        registerPage.enterToFirstNameTextbox(firstName);
        registerPage.enterToLastNameTextbox(lastName);
        registerPage.enterToEmailTextbox(emailAddress);
        registerPage.enterToPasswordTextbox(password);
        registerPage.enterToConfirmPasswordTextbox(password);

        registerPage.clickToRegisterButton();

        //chay qya roi lay text de verify voi 1 text ma mk mong doi
        Assert.assertEquals(registerPage.getRegisterSuccessMessageText(),"Your registration completed");

        // o day pahi them cacs buoc login thi no moi co cookie, kia mowi la dang ki
        //............................

        //get ra, lay ra cookies-> sang cac cai kia lai set voa de thay buoc dang nhap
        cookies=registerPage.getBrowserCookies(driver);
        //tao du lieu xong dong luon
        closeBrowser();//co mot so trang dong browser la mat luon cookies nen tuy truowng hop co the bo cau lenh dong nay di

    }

}

