package commons;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class BasePageFactory {

    //    Web browswer
    protected void openPageUrl(WebDriver driver, String pageUrl){
        driver.get(pageUrl);
    }

    protected String getPageTile(WebDriver driver){
        return driver.getTitle();

    }
    //tam
    protected String getCurrentPageUrl(WebDriver driver){
        return driver.getCurrentUrl();
    }

    protected String getPageSourceCode(WebDriver driver){
        return driver.getPageSource();
    }

    protected void backToPage(WebDriver driver) {
        driver.navigate().back();
    }

    protected void forwordToPage(WebDriver driver){
        driver.navigate().forward();
    }

    protected void refreshCurrentPage(WebDriver driver){
        driver.navigate().refresh();
    }

    protected Alert waitForAlertPresence(WebDriver driver){
        return new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.alertIsPresent());
    }

    protected void acceptToAlert(WebDriver driver){
        waitForAlertPresence(driver).accept();
    }

    protected void cancelToAlert(WebDriver driver){
        waitForAlertPresence(driver).dismiss();
    }

    protected String getTextInAlert(WebDriver driver){
        return waitForAlertPresence(driver).getText();
    }

    protected void sendkeyToAlert(WebDriver driver, String keysToSend){
        waitForAlertPresence(driver).sendKeys(keysToSend);
    }

    protected void switchToWindowByID(WebDriver driver,String expectedID){
        //Ham nay ch su dung khi co 2 tab dang duco mo
        //Lay ra ID cua tab hien tai, chu y tat ca cac window/ tab deu co 1 cai ID cau no
        String parentID=driver.getWindowHandle();

        //Lay ra ID cua tat ca cac tab/windown dang duoc mo
        Set<String> allIDs=driver.getWindowHandles();

        //Dung vong lap duyetj qua tung ID
        for(String id:allIDs) {
            //Neu nhu 1 iD nao ma khac voi parentID thi switch vao(TH nay co 2 cai ID thoai)
            if (!id.equals(expectedID)) {//title cac tab k giong nhau ddc nene k lo trung
                driver.switchTo().window(id);
                break;
            }
        }

    }

    protected void switchToWindowByTilte(WebDriver driver,String expectedTitle){
        //Lay het tat caa ID cua cac window/tab
        Set<String> allIDs=driver.getWindowHandles();

        //Dung vong lap de duyet qua Set ID o tren
        for(String id:allIDs){
            //cho switch vao tung ID truowc
            driver.switchTo().window(id);
            //Lay ra tile cua tab/window hien tai
            String actualTitle=driver.getTitle();
            if(actualTitle.equals(expectedTitle)){
                break;
            }
        }

    }

    protected void closeAllWindowWithoutParent(WebDriver driver,String parentID){
        //Lay het tat caa ID cua cac window/tab
        Set<String> allIDs=driver.getWindowHandles();

        //Dung vong lap de duyet qua Set ID o tren
        for(String id:allIDs){
            if(!id.equals(parentID)){
                driver.switchTo().window(id);
                driver.close();
            }
        }
        driver.switchTo().window(parentID);// chu y van phai co cau lenh chuyene driver ve nhoa
        //sau cuoi cx chi con moi tab cha thoi

    }

    protected void sleepInSeconds(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    protected Set<Cookie> getBrowserCookies(WebDriver driver){
        return driver.manage().getCookies();
    }

    protected void setCookies(WebDriver driver, Set<Cookie> cookies){
        for(Cookie cookie :cookies){
            driver.manage().addCookie(cookie);
        }
    }

    protected void deleteAllCookies(WebDriver driver){
        driver.manage().deleteAllCookies();
    }
    protected  void clickToElement(WebDriver driver, WebElement element){
        element.click();
    }
    protected void senkeyToElement(WebDriver driver,WebElement element,String valueToSend){
        element.clear();
        element.sendKeys(valueToSend);
    }
    protected String getElementText(WebDriver driver,WebElement element){
        return element.getText();
    }

    protected void waitForElementVisible(WebDriver driver,WebElement element){
        new WebDriverWait(driver,Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitForElementClickable(WebDriver driver, WebElement element){
        new WebDriverWait(driver,Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(element));
    }
    protected String getElementAttribute(WebDriver driver,WebElement element,String attributeName){
        return element.getAttribute(attributeName);
    }

}
