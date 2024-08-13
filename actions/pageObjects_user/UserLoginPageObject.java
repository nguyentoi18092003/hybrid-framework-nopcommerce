package pageObjects_user;

import commons.BaseElement;
import commons.BasePage;
import commons.PageGeneratortManager;
import org.openqa.selenium.WebDriver;
import pageUIs_user.UserLoginPageUI;

public class UserLoginPageObject extends BaseElement {
    WebDriver driver;
    public UserLoginPageObject(WebDriver driver){
        super(driver);
        this.driver=driver;
    }
    public void enterToEmailTextbox(String emailAddress) {
        waitForElementVisible(driver, UserLoginPageUI.EMAIL_TEXTBOX);
        sendkeyToElement(driver, UserLoginPageUI.EMAIL_TEXTBOX,emailAddress);

    }

    public void enterToPasswordTextbox(String password) {
        waitForElementVisible(driver, UserLoginPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, UserLoginPageUI.EMAIL_TEXTBOX,password);
    }

    public HomePageObject clickToLoginButton() {
        waitForElementClickable(driver, UserLoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
        return PageGeneratortManager.getHomePage(driver);
    }
    public HomePageObject loginToUser (String emailAddress,String password){
        enterToEmailTextbox(emailAddress);
        enterToPasswordTextbox(password);
        return clickToLoginButton();
    }
}
