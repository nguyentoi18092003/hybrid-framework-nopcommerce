package commons;

import org.openqa.selenium.WebDriver;
import pageObjects_user.HomePageObject;
import pageUIs_user.BaseElementUI;
import pageUIs_user.CustomerPageUI;
import pageUIs_user.HomePageUI;


public class BaseElement extends BasePage{
    WebDriver driver;
    public BaseElement(WebDriver driver){
        this.driver=driver;

    }
    public HomePageObject clickToNopCommerceLogo() {
        waitForElementClickable(driver, BaseElementUI.NOP_COMMERCE_LOGO);
        clickToElement(driver,BaseElementUI.NOP_COMMERCE_LOGO);
        return PageGeneratortManager.getHomePage(driver);
    }

    //Theo bussiness thi bat ky page nao cx goi ra dung duoc (may cai link Phan header ne)
    public void clickToHeaderLinkByName(String pageName){
        waitForElementClickable(driver, BaseElementUI.DYNAMIC_HEADER_LINK_BY_NAME,pageName);
        clickToElement(driver,BaseElementUI.DYNAMIC_HEADER_LINK_BY_NAME,pageName);
    }

    //Thao tac voi bat ki 1 button nao o page
    public void clickToButtonByText(String buttonText){
        waitForElementClickable(driver, BaseElementUI.DYNAMIC_BUTTON_BY_TEXT,buttonText);
        clickToElement(driver,BaseElementUI.DYNAMIC_BUTTON_BY_TEXT,buttonText);

    }
    //get ra error message cua textbox tai bat ki page nao
    public String getTextboxErrorMessageByID(String errorMessageID) {
        waitForElementVisible(driver,BaseElementUI.DYNAMIC_TEXTBOX_ERROR_MSG_BY_ID,errorMessageID);
        return getElementText(driver,BaseElementUI.DYNAMIC_TEXTBOX_ERROR_MSG_BY_ID,errorMessageID);
    }
    public void enterToTextboxByID(String textboxID, String valueToSendkey) {
        waitForElementVisible(driver,BaseElementUI.DYNAMIC_TEXTBOX_BY_ID,textboxID);
        sendkeyToElement(driver,BaseElementUI.DYNAMIC_TEXTBOX_BY_ID,valueToSendkey,textboxID);
    }
    //Get ra attribute cua textbox tai bat ki page nao
    public String getTextboxAttributeValue(String textboxID) {
        waitForElementVisible(driver, BaseElementUI.DYNAMIC_TEXTBOX_BY_ID);
        return getElementAttribute(driver,BaseElementUI.DYNAMIC_TEXTBOX_BY_ID,"value",textboxID);
    }
}
