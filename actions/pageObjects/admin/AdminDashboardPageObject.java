package pageObjects.admin;

import commons.BasePage;
import commons.PageGeneratortManager;
import org.openqa.selenium.WebDriver;
import pageUIs_admin.AdminDashboardPageUI;

public class AdminDashboardPageObject extends BasePage {
    WebDriver driver;
    public AdminDashboardPageObject(WebDriver driver){
        this.driver=driver;

    }

    public AdminLoginPageObject clickToLogoutLink() {
        waitForElementClickable(driver, AdminDashboardPageUI.LOGOUT_LINK);
        clickToElement(driver,AdminDashboardPageUI.LOGOUT_LINK);
        return PageGeneratortManager.getAdminLoginPage(driver);

    }
}
