package pageObjects;


import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.CustomerPageUI;

public class CustomerPageObject extends BasePage {
    WebDriver driver;
    public CustomerPageObject(WebDriver driver){
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
