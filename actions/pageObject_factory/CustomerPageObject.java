package pageObject_factory;

import commons.BasePageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerPageObject extends BasePageFactory {
    WebDriver driver;

    @FindBy(id="FirstName")
    private WebElement firstNameTextbox;

    @FindBy(id="LastName")
    private WebElement lastNameTextBox;

    @FindBy(id="Email")
    private WebElement emailAddressTextBox;

    public CustomerPageObject(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(this.driver,this);//cai nay no se tao ra ket noi giua cai ELement() vs FindBy (khi bien do duoc goi-su dung toi no se thuc hien di tim element)

    }

    public String  getFirstNameTextboxAttributeValue() {
        waitForElementVisible(driver,firstNameTextbox);
        return getElementAttribute(driver,firstNameTextbox,"value");
    }

    public String getLastNameTextboxAttributeValue() {
        waitForElementVisible(driver,lastNameTextBox);
        return getElementAttribute(driver,lastNameTextBox,"value");

    }

    public String  getEmailAddressTextboxAttributeValue() {
        waitForElementVisible(driver,emailAddressTextBox);
        return getElementAttribute(driver,emailAddressTextBox,"value");
    }
}
