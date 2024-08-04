package pageObjects;

import commons.BasePage;
import commons.PageGeneratortManager;
import org.openqa.selenium.WebDriver;
import pageUIs.HomePageUI;


public class HomePageObject extends BasePage {
    WebDriver driver;

    public HomePageObject(WebDriver driver){
        this.driver=driver;
    }
    public RegisterPageObject clickToRegisterLink() {
        waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
        clickToElement(driver,HomePageUI.REGISTER_LINK);
        //Tu HomePage click vao RegisterLink no se mo ra trang register Page-> Khoi tao Page do len
        return  PageGeneratortManager.getRegisterPage(driver);

    }

    public void clickToLoginLink() {
        waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
        clickToElement(driver,HomePageUI.LOGIN_LINK);
    }

    public CustomerPageObject clickToMyAccountLink() {
        waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
        clickToElement(driver,HomePageUI.MY_ACCOUNT_LINK);
        return PageGeneratortManager.getCustomerPage(driver);
    }
}
