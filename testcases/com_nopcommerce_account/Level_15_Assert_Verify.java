package com_nopcommerce_account;

import commons.BaseTest;
import commons.PageGeneratortManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects_user.*;

public class Level_15_Assert_Verify extends BaseTest {
    private WebDriver driver;






    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName){
        driver=getBrowserDriver(browserName);

    }

    @Test
    public void User_01_Register_Success(){




    }
    @Test
    public void User_02_Login_Success(){


    }

    @Test
    public void User_03_Switch_Page(){


    }
    @Test
    public void User_04_Switch_Page(){





    }

    @AfterClass
    public void afterClass(){
        driver.quit();

    }
}

