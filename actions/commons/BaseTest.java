package commons;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.time.Duration;
import java.util.Random;

public class BaseTest {
    WebDriver driver;
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


        driver.get("https://demo.nopcommerce.com/");
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
}
