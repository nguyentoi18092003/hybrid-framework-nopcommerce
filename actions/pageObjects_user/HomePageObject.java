package pageObjects_user;

import commons.BaseElement;
import commons.BasePage;
import commons.PageGeneratortManager;
import org.openqa.selenium.WebDriver;
import pageUIs_user.HomePageUI;


public class HomePageObject extends BaseElement {
    WebDriver driver;

    public HomePageObject(WebDriver driver){
        super(driver);
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

    public void clickToLogoutLink() {
        //a[@class='ico-logout']
        waitForElementClickable(driver, HomePageUI.LOGOUT_LINK);
        clickToElement(driver,HomePageUI.LOGOUT_LINK);
    }

    public boolean isRegisterLinkDisplayed() {
        waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
        return isElementDisplayed(driver,HomePageUI.REGISTER_LINK);

    }

}
