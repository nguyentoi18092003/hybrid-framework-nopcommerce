package com_jquery_upload;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects_jquery.HomePageObject;
import pageObjects_jquery.PageGeneratorManager;
import pageObjects_jquery.UploadPageObject;

import java.util.ArrayList;
import java.util.List;


public class Level_14_Upload_File extends BaseTest {
    WebDriver driver;
    UploadPageObject uploadPage;
    String Anh1="Anh1.jpg";
    String Anh3="Anh3.jpg";
    String AnhThe="AnhThe.jpg";

    String[] fileNames={Anh1, Anh3,AnhThe};


    @Parameters({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName,String url){
        driver=getBrowserDriver(browserName,url);
        uploadPage=PageGeneratorManager.getUploadPage(driver);
    }

    @Test
    public void TC_01_Upload_Single_File(){
        uploadPage.uploadMultipleFiles(driver,Anh1);
        uploadPage.sleepInSecond(2);
        uploadPage.uploadMultipleFiles(driver,Anh3);
        uploadPage.sleepInSecond(2);
        uploadPage.uploadMultipleFiles(driver,AnhThe);
        uploadPage.sleepInSecond(2);

        Assert.assertTrue(uploadPage.isFileLoadedSuccess(Anh1));
        Assert.assertTrue(uploadPage.isFileLoadedSuccess(Anh3));
        Assert.assertTrue(uploadPage.isFileLoadedSuccess(AnhThe));

        uploadPage.clickStartButtonOnEachFile();

        Assert.assertTrue(uploadPage.isFileUploadedSuccess(Anh1));
        Assert.assertTrue(uploadPage.isFileUploadedSuccess(Anh3));
        Assert.assertTrue(uploadPage.isFileUploadedSuccess(AnhThe));

    }
    @Test
    public void TC_02_Upload_Multiple_File(){
        uploadPage.refreshCurrentPage(driver);
        uploadPage.uploadMultipleFiles(driver,fileNames);
        Assert.assertTrue(uploadPage.isFileLoadedSuccess(Anh1));
        Assert.assertTrue(uploadPage.isFileLoadedSuccess(Anh3));
        Assert.assertTrue(uploadPage.isFileLoadedSuccess(AnhThe));

        uploadPage.clickStartButtonOnEachFile();

        Assert.assertTrue(uploadPage.isFileUploadedSuccess(Anh1));
        Assert.assertTrue(uploadPage.isFileUploadedSuccess(Anh3));
        Assert.assertTrue(uploadPage.isFileUploadedSuccess(AnhThe));


    }
    @Test
    public void TC_03_Upload_GoFile(){//TC nay chua xong, dnag xu li do ben uploadFilePageUI
        //lam tren trang goFile
        uploadPage.openPageUrl(driver,"");
        //Ham assert Wait cho loading icon o trang upload bien mat
        Assert.assertTrue(uploadPage.isLoadingIconAtMainContentDisappear());
        uploadPage.uploadMultipleFiles(driver,fileNames);

        //Ham asser nay dung de wait cho loading icon o trang upload bien mat
        Assert.assertTrue(uploadPage.isLoadingIconAtMainUploadDisappear());
        //Ham asset wait cho tat ca ca progress bar bien mat
        Assert.assertTrue(uploadPage.isMultipleProgressBarIconDisappear());
        //Wait +check cho messageHien thi
        Assert.assertTrue(uploadPage.isSuccessMessageDisplayed("Your files have been successfully uploaded"));

        //wait +click to link
        uploadPage.clickToSuccessLink();

        //wait table chua cacs file dc upload visible
        Assert.assertTrue(uploadPage.isContentTableDisplayed());

        Assert.assertTrue(uploadPage.isDownLoadButtonDisplayed("Anh1"));
        Assert.assertTrue(uploadPage.isDownLoadButtonDisplayed("Anh3"));
        Assert.assertTrue(uploadPage.isDownLoadButtonDisplayed("AnhThe"));

        Assert.assertTrue(uploadPage.isPlayButtonDisplayed("Anh1"));
        Assert.assertTrue(uploadPage.isPlayButtonDisplayed("Anh3"));
        Assert.assertTrue(uploadPage.isPlayButtonDisplayed("AnhThe"));









    }

    @AfterClass
    public void afterClass(){
        driver.quit();

    }
}

