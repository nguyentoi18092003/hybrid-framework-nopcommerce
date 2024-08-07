package com_jquery_table;

import commons.BaseTest;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects_jquery.HomePageObject;
import pageObjects_jquery.PageGeneratorManager;


public class Level_13_Handle_DataTable extends BaseTest {
    private WebDriver driver;

    HomePageObject homePage;


    @Parameters({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName,String url){
        driver=getBrowserDriver(browserName,url);
        homePage= PageGeneratorManager.getHomePage(driver);
    }

    @Test
    public void TC_01_Search(){
        //Search du lieu trong 1 table (tren Header)
        homePage.inputToColumnTextboxByName("Females","624");
        homePage.inputToColumnTextboxByName("Country","Afghanistan");
        homePage.inputToColumnTextboxByName("Males","651");
        homePage.inputToColumnTextboxByName("Total","1270");


    }
    @Test
    public void TC_02_Paging(){
        //click to any Page
        homePage.clickToPageByNumber("10");
        homePage.sleepInSecond(2);
        Assert.assertTrue(homePage.isPageActiveByNumber("10"));

        homePage.clickToPageByNumber("1");
        homePage.sleepInSecond(2);
        Assert.assertTrue(homePage.isPageActiveByNumber("1"));





    }

    @Test
    public void TC_03(){
        //chu y muon tim kiem dong o page khac nen tim kiem trươc roi moi check hien thi day la o ngya trang 1 roi(trang dang dung roi)

//hoac nhay sang trang do truowc roi searxh sau
        Assert.assertTrue(homePage.isRowValuesDisplayed("750","Aruba","756","1504"));


    }
    @Test
    public void TC_04_Icon_Button_Checkbox(){
        //click vao bat ki 1 cai icon/button/checkbox/.. cua 1 row nao do
        //tim dc 1 key la duy nhat cua row do so vs cac row khac
        homePage.clickToRowActionByCountryName("Afghanistan","remove");
        homePage.refreshCurrentPage(driver);

        homePage.clickToRowActionByCountryName("AFRICA","edit");
        homePage.refreshCurrentPage(driver);




    }

    @AfterClass
    public void afterClass(){
        driver.quit();

    }
}

