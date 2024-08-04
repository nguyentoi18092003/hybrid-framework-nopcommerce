package pageObjects;

import commons.PageGeneratortManager;
import org.openqa.selenium.WebDriver;
import pageUIs.RegisterPageUI;
import commons.BasePage;

public class RegisterPageObject extends BasePage{
    WebDriver driver;

    public RegisterPageObject(WebDriver driver){
        this.driver=driver;

    }

    public void clickToRegisterButton() {
        waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
        clickToElement(driver,RegisterPageUI.REGISTER_BUTTON);

    }

    public String getFirstNameErrorMessageText() {
        waitForElementVisible(driver,RegisterPageUI.FIRSTNAME_ERROR_MSG);
        return getElementText(driver,RegisterPageUI.FIRSTNAME_ERROR_MSG);
    }

    public String getLastNameErrorMessageText() {
        waitForElementVisible(driver,RegisterPageUI.LASTNAME_ERROR_MSG);
        return getElementText(driver,RegisterPageUI.LASTNAME_ERROR_MSG);
    }

    public String getEmailErrorMessageText() {
        waitForElementVisible(driver,RegisterPageUI.EMAIL_ERROR_MSG);
        return getElementText(driver,RegisterPageUI.EMAIL_ERROR_MSG);
    }

    public String getPasswordErrorMessageText() {
        waitForElementVisible(driver,RegisterPageUI.PASSWORD_ERROR_MSG);
        return getElementText(driver,RegisterPageUI.PASSWORD_ERROR_MSG);
    }
    public String getPasswordErrorMessageText2() {
        waitForElementVisible(driver,RegisterPageUI.PASSWORD_ERROR_MSG_2);
        return getElementText(driver,RegisterPageUI.PASSWORD_ERROR_MSG_2);
    }

    public HomePageObject clickToNopCommerceLogo() {
        waitForElementClickable(driver,RegisterPageUI.NOP_COMMERCE_LOGO);
        clickToElement(driver,RegisterPageUI.NOP_COMMERCE_LOGO);
        return PageGeneratortManager.getHomePage(driver);
    }

    public void enterToFirstNameTextbox(String firstNameValue) {
        waitForElementVisible(driver,RegisterPageUI.FIRSTNAME_TEXTBOX);
        sendkeyToElement(driver,RegisterPageUI.FIRSTNAME_TEXTBOX,firstNameValue);


    }

    public void enterToLastNameTextbox(String lastNameValue) {
        waitForElementVisible(driver,RegisterPageUI.LAST_NAME_TEXTBOX);
        sendkeyToElement(driver,RegisterPageUI.LAST_NAME_TEXTBOX,lastNameValue);
    }

    public void enterToEmailTextbox(String emailAddressValue) {
        waitForElementVisible(driver,RegisterPageUI.EMAIL_TEXTBOX);
        sendkeyToElement(driver,RegisterPageUI.EMAIL_TEXTBOX,emailAddressValue);
    }

    public void enterToPasswordTextbox(String passwordValue) {
        waitForElementVisible(driver,RegisterPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver,RegisterPageUI.PASSWORD_TEXTBOX, passwordValue);
    }

    public void enterToConfirmPasswordTextbox(String passwordValue) {
        waitForElementVisible(driver,RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
        sendkeyToElement(driver,RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX,passwordValue);
    }

    public String getConfirmPasswordErrorMessageText() {
        waitForElementVisible(driver,RegisterPageUI.CONFIRM_PASSWORD_ERROR_MSG);
        return getElementText(driver,RegisterPageUI.CONFIRM_PASSWORD_ERROR_MSG);
    }

    public String getRegisterSuccessMessageText() {
        waitForElementVisible(driver,RegisterPageUI.REGISTRATION_COMPLETED_MSG);
        return getElementText(driver,RegisterPageUI.REGISTRATION_COMPLETED_MSG);
    }
}
