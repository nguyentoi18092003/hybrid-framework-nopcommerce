package com_nopcommerce_account;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratortManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.admin.AdminDashboardPageObject;
import pageObjects.admin.AdminLoginPageObject;
import pageObjects_user.*;

public class Level_10_Switch_Role extends BaseTest {
    private WebDriver driver;


    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private UserLoginPageObject userLoginPage;
    private AdminLoginPageObject adminLoginPage;
    private CustomerPageObject customerPage;
    private AddressPageObject addressPage;
    private OrderPageObject orderPage;
    private RewardPointPageObject rewardPointPage;
    private AdminDashboardPageObject adminDashboardPage;

    private String emailAddress=getEmailRadom();

    private String adminUrl= GlobalConstants.DEV_ADMIN_URL;
    private String userUrl=GlobalConstants.DEV_USER_URL;



    @Parameters({"browser"})//browser la co dinh roi(keiu lay ra ten trinh duyet ben xml de chay), adminUrl, userUrl la 2 diem mk dinh nghia ben xml
    //brwoser map vs browserName,adminUrl map vs String adminUrl,userUrl map vs String userUrl ben duoi
    @BeforeClass
    public void beforeClass(String browserName){
        driver=getBrowserDriver(browserName,userUrl);



        homePage= PageGeneratortManager.getHomePage(driver);//ben kia de kieu static, nen ham nay dung o class goi dc luon k can phai khoi tao
    }

    @Test
    public void User_01_User_To_Admin(){
        registerPage=homePage.clickToRegisterLink();

        registerPage.enterToFirstNameTextbox("John");
        registerPage.enterToLastNameTextbox("Kennedy");
        registerPage.enterToEmailTextbox(emailAddress);
        registerPage.enterToPasswordTextbox("123456");
        registerPage.enterToConfirmPasswordTextbox("123456");

        registerPage.clickToRegisterButton();

        //chay qya roi lay text de verify voi 1 text ma mk mong doi
        Assert.assertEquals(registerPage.getRegisterSuccessMessageText(),"Your registration completed");

        homePage=registerPage.clickToNopCommerceLogo();

        homePage.clickToLogoutLink();

        //customerPage=homePage.clickToMyAccountLink();
        //Home page(User)-> Login Page(Admin)

        homePage.openPageUrl(driver,this.adminUrl);
        adminLoginPage=PageGeneratortManager.getAdminLoginPage(driver);

        adminDashboardPage=adminLoginPage.loginToAdmin(GlobalConstants.DEV_ADMIN_USERNAME,GlobalConstants.DEV_ADMIN_PASSWORD);
        Assert.assertTrue(adminDashboardPage.isPageLoadedSuccess(driver));
    }
    @Test
    public void User_02_Admin_To_User(){
       adminLoginPage= adminDashboardPage.clickToLogoutLink();

       //LoginPage (admin)->HomePage(User)
        adminLoginPage.openPageUrl(driver,this.userUrl);
        homePage=PageGeneratortManager.getHomePage(driver);







    }

    @AfterClass
    public void afterClass(){
        driver.quit();

    }
}

