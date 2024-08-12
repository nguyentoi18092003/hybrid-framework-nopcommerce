package com_facebook_home;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects_facebook.HomePageObject;
import pageObjects_facebook.PageGeneratorManager;


public class Level_20_Element_Undisplayed extends BaseTest {
     WebDriver driver;
     HomePageObject homePage;

    @Parameters({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName,String urlValue){
        driver=getBrowserDriver(browserName,urlValue);
        homePage= PageGeneratorManager.getHomePage(driver);
    }
    @Test
    public void Home_01_Element_Displayed(){
        homePage.clickToCreateNewAccountButton();

        verifyTrue(homePage.isFirstNameTextboxDisplayed());
        verifyTrue(homePage.isSurNameTextboxDisplayed());
        verifyTrue(homePage.isEmailTextboxDisplayed());
        verifyTrue(homePage.isPasswordTextboxDisplayed());

        homePage.enterToEmailTextbox("automaticfc@gmail.com");

        log.info("Verify Confirm Email textbox is displayed");
        verifyTrue(homePage.isConfirmEmailTextboxDisplayed());


    }
    @Test
    public void Home_02_Element_Undisplayed_In_HTML(){
        homePage.enterToEmailTextbox("");
        homePage.sleepInSecond(2);// Do chua kip mat di da nhay vao verify roi, nen phai cho sleep truoc

        log.info("Verify Confirm Email textbox is not displayed");
        verifyTrue(homePage.isConfirmEmailTextboxUnDisplayed());


    }
    @Test
    public void Home_03_Element_Undisplayed_Not_In_HTML(){
        homePage.clickToCloseSignUpPopup();

        log.info("Verify Firstname textbox is not displayed");
        verifyTrue(homePage.isFirstNameTextboxUnDisplayed());

        log.info("Verify Surname textbox is not displayed");
        verifyTrue(homePage.isSurNameTextboxUnDisplayed());

        log.info("Verify Email textbox is not displayed");
        verifyTrue(homePage.isEmailTextboxUnDisplayed());

        log.info("Verify Password textbox is not displayed");
        verifyTrue(homePage.isPasswordTextboxUnDisplayed());




    }

    @AfterClass
    public void afterClass(){
        driver.quit();

    }
}

