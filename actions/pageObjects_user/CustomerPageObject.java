package pageObjects_user;


import org.openqa.selenium.WebDriver;
import pageUIs_user.CustomerPageUI;

public class CustomerPageObject extends MyAccountSideBarPageObject {
    WebDriver driver;
    public CustomerPageObject(WebDriver driver){
        super(driver);//vi thang cha mk ke thua no co khoi tao, nen mk ohai co ham nay
        this.driver=driver;

    }
    public String getFirstNameTextboxAttributeValue() {
        waitForElementVisible(driver, CustomerPageUI.FIRST_NAME_TEXTBOX);
        return getElementAttribute(driver,CustomerPageUI.FIRST_NAME_TEXTBOX,"value");

    }

    public String getLastNameTextboxAttributeValue() {
        waitForElementVisible(driver, CustomerPageUI.LAST_NAME_TEXTBOX);
        return getElementAttribute(driver,CustomerPageUI.LAST_NAME_TEXTBOX,"value");

    }

    public String getEmailAddressTextboxAttributeValue() {
        waitForElementVisible(driver, CustomerPageUI.EMAIL_ADDRESS_TEXTBOX);
        return getElementAttribute(driver,CustomerPageUI.EMAIL_ADDRESS_TEXTBOX,"value");

    }


}
