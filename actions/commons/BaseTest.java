package commons;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.Assert;
import org.testng.Reporter;


import java.time.Duration;
import java.util.Random;

public class BaseTest {
    protected final Logger log;////Log4j2
    WebDriver driver;
    public BaseTest(){
        log= LogManager.getLogger(getClass());//Log4j2

    }
    protected WebDriver getBrowserDriver(String browserName){
        BrowserList browser=BrowserList.valueOf(browserName.toUpperCase());
        if(browser==BrowserList.FIREFOX){
            driver=new FirefoxDriver();
        }
        else if(browser==BrowserList.CHROME){
            driver=new ChromeDriver();
        }
        else if(browser==BrowserList.EDGE){
            driver=new EdgeDriver();
        }
        else {
            throw new RuntimeException("Ten trinh duyet khong hop le");
        }


        //set kich thuoc man hinh cua trinh duyet khi chay
        driver.manage().window().setPosition(new Point(0,0));
        driver.manage().window().setSize(new Dimension(1024,768));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));


        driver.get("https://28tech.com.vn/");
        return driver;
    }

    protected WebDriver getBrowserDriver(String browserName,String url){
        BrowserList browser=BrowserList.valueOf(browserName.toUpperCase());
        if(browser==BrowserList.FIREFOX){
            driver=new FirefoxDriver();
        }
        else if(browser==BrowserList.CHROME){
            driver=new ChromeDriver();
        }
        else if(browser==BrowserList.EDGE){
            driver=new EdgeDriver();
        }
        else {
            throw new RuntimeException("Ten trinh duyet khong hop le");
        }


        //set kich thuoc man hinh cua trinh duyet khi chay
        driver.manage().window().setPosition(new Point(0,0));
        driver.manage().window().setSize(new Dimension(1024,768));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));


        driver.get(url);
        return driver;
    }

    public String getEmailRadom() {
        Random rand=new Random();
        return "john"+ rand.nextInt(99999)+ "@kennedy.us";
    }
    protected void closeBrowser(){
        if(driver==null){
            System.out.println("Browser is closed");
        }
        else{
            driver.quit();
        }
    }

    //3 ham duoi day la copy tu file cua thay va dung cho phan report loi

    protected boolean verifyTrue(boolean condition) {
        boolean pass = true;
        try {

            Assert.assertTrue(condition);
            log.info("-------------------------PASSED-------------------------");
        } catch (Throwable e) {
            log.info("-------------------------FAILED-------------------------");
            pass = false;

            // Add lỗi vào ReportNG
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }


    protected boolean verifyFalse(boolean condition) {
        boolean pass = true;
        try {
            Assert.assertFalse(condition);
            log.info("-------------------------PASSED-------------------------");
        } catch (Throwable e) {
            log.info("-------------------------FAILED-------------------------");

            pass = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }


    protected boolean verifyEquals(Object actual, Object expected) {
        boolean pass = true;
        try {
            Assert.assertEquals(actual, expected);
            log.info("-------------------------PASSED-------------------------");

        } catch (Throwable e) {
            log.info("-------------------------FAILED-------------------------");
            pass = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }
}
