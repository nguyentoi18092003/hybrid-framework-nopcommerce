package pageObjects.admin;

import commons.BasePage;
import commons.PageGeneratortManager;
import org.openqa.selenium.WebDriver;
import pageUIs_admin.AdminLoginPageUI;

public class AdminLoginPageObject extends BasePage {
    WebDriver driver;
    public AdminLoginPageObject(WebDriver driver){
        this.driver=driver;

    }

    public void enterToEmailTextBox(String emailAddress) {
        waitForElementVisible(driver, AdminLoginPageUI.EMAIL_ADDRESS_TXT);
        sendkeyToElement(driver,AdminLoginPageUI.EMAIL_ADDRESS_TXT,emailAddress);
    }

    public void enterToPasswordTextbox(String password) {
        waitForElementVisible(driver, AdminLoginPageUI.PASSWORD_TXT);
        sendkeyToElement(driver,AdminLoginPageUI.PASSWORD_TXT,password);
    }

    public  AdminDashboardPageObject clickToLoginButton( ) {
        waitForElementClickable(driver,AdminLoginPageUI.LOGIN_BUTTON);
        clickToElement(driver,AdminLoginPageUI.LOGIN_BUTTON);
        return PageGeneratortManager.getAdminDashboardPage(driver);

    }
    public AdminDashboardPageObject  loginToAdmin(String emailAddress,String password){
        enterToEmailTextBox(emailAddress);
        enterToPasswordTextbox(password);
        return clickToLoginButton();

    }
}
