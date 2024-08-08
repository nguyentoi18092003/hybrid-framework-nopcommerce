package pageObjects_jquery;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs_jquery.UploadPageUI;

import java.util.List;

public class UploadPageObject extends BasePage {
    WebDriver driver;

    public UploadPageObject(WebDriver driver){
        this.driver=driver;
    }

    public boolean isFileLoadedSuccess(String fileName) {
        waitForElementVisible(driver, UploadPageUI.FILE_LOADED_BY_NAME,fileName);
        return isElementDisplayed(driver,UploadPageUI.FILE_LOADED_BY_NAME,fileName);
    }

    public void clickStartButtonOnEachFile() {
        List<WebElement> startButtons=getListWebElement(driver,UploadPageUI.MULTIPLE_START_BUTTON);
        for(WebElement button: startButtons){
            waitForElementClickable(driver,button);
            clickToElement(driver,button);
           // sleepInSecond(2);
        }

    }

    public boolean isFileUploadedSuccess(String fileName) {
        waitForElementVisible(driver, UploadPageUI.FILE_LOADED_BY_NAME,fileName);
        return isElementDisplayed(driver,UploadPageUI.FILE_LOADED_BY_NAME,fileName);
    }
    // dong nay chua viet xong
    public boolean isLoadingIconAtMainUploadDisappear() {
        return true;
    }

    public boolean isMultipleProgressBarIconDisappear() {
        return true;
    }

    public boolean isSuccessMessageDisplayed(String s) {
        return true;
    }

    public void clickToSuccessLink() {

    }

    public boolean isContentTableDisplayed() {
        return true;
    }

    public boolean isDownLoadButtonDisplayed(String anh1) {
        return true;
    }


    public boolean isPlayButtonDisplayed(String anh1) {
        return true;
    }

    public boolean isLoadingIconAtMainContentDisappear() {
        return true;
    }
}
