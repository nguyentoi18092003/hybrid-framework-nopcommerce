package pageObject_28tech;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs28tech.HomePage28techUI;


public class HomePage28techObject extends BasePage {
    WebDriver driver;
    public HomePage28techObject(WebDriver driver){
        this.driver=driver;
    }

    public boolean isTitleDisPlayed() {
        waitForElementVisible(driver, HomePage28techUI.TITLE_TEXT);
        return isElementDisplayed(driver,HomePage28techUI.TITLE_TEXT);
    }

    public void enterToRegisterTextBox(String valueToSenkey) {
        waitForElementVisible(driver,HomePage28techUI.REGISTER_TEXTBOX);
        scrollToElementOnTop(driver,HomePage28techUI.REGISTER_TEXTBOX);


        sendkeyToElement(driver,HomePage28techUI.REGISTER_TEXTBOX,valueToSenkey);
    }

    public void clickToRegisterButton() {
        waitForElementClickable(driver,HomePage28techUI.REGISTER_BUTTON);
        clickToElement(driver,HomePage28techUI.REGISTER_BUTTON);
    }


    public String getTextErrorMessage() {
        waitForElementVisible(driver,HomePage28techUI.REGISTER_ERROR_MESSAGE);
        return getElementText(driver,HomePage28techUI.REGISTER_ERROR_MESSAGE);
    }

    public String getTextFooter(String noidung) {
        waitForElementVisible(driver,HomePage28techUI.DYNAMMIC_FOOTER_TEXT1,noidung);
        return getElementText(driver,HomePage28techUI.DYNAMMIC_FOOTER_TEXT1,noidung);
    }
}
