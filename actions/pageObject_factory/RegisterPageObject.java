package pageObject_factory;

import commons.BasePageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPageObject extends BasePageFactory {
    WebDriver driver;

    @FindBy(id="FirstName")
    private WebElement firstNameTextbox;

    @FindBy(id="LastName")
    private WebElement lastNameTextbox;

    @FindBy(id="Email")
    private WebElement emailTextbox;

    @FindBy(id="Password")
    private WebElement passwordTextbox;

    @FindBy(id="ConfirmPassword")
    private WebElement confirmPasswordTextbox;

    @FindBy(id="register-button")
    private WebElement registerButton;

    @FindBy(id="FirstName-error")
    private WebElement firstNameErrorMsg;

    @FindBy(id="LastName-error")
    private WebElement lastNameErrorMsg;

    @FindBy(id="Email-error")
    private WebElement emailErrorMsg;

    @FindBy(xpath = "//span[@class='field-validation-error']")
    private WebElement emailErrorMsg2;

    @FindBy(id="ConfirmPassword-error")
    private WebElement passwordErrorMsg;

    @FindBy(xpath = "//span[@class='field-validation-error']")
    private WebElement passwordErrorMsg2;

    @FindBy(id="ConfirmPassword-error")
    private WebElement confirmPasswordErrorMsg;


    @FindBy(xpath = "//div[@class='header-logo']//img")
    private WebElement nopCommerceLogo;

    @FindBy(xpath = "//div[@class='result']")
    private WebElement successMessage;


    public RegisterPageObject(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(this.driver,this);//cai nay no se tao ra ket noi giua cai ELement() vs FindBy (khi bien do duoc goi-su dung toi no se thuc hien di tim element)

    }

    public void clickToRegisterButton() {
        waitForElementClickable(driver,registerButton);
        clickToElement(driver,registerButton);

    }

    public String getFirstNameErrorMessageText() {
        waitForElementVisible(driver,firstNameErrorMsg);
        return getElementText(driver,firstNameErrorMsg);

    }

    public String getLastNameErrorMessageText() {
        waitForElementVisible(driver,lastNameErrorMsg);
        return getElementText(driver,lastNameErrorMsg);
    }

    public String getEmailErrorMessageText() {
        waitForElementVisible(driver,emailErrorMsg);
        return getElementText(driver,emailErrorMsg);
    }

    public String getEmailErrorMessageText2() {
        waitForElementVisible(driver,emailErrorMsg2);
        return getElementText(driver,emailErrorMsg2);
    }

    public String getPasswordErrorMessageText() {
        waitForElementVisible(driver,passwordErrorMsg);
        return getElementText(driver,passwordErrorMsg);
    }

    public void clickToNopCommerceLogo() {
        waitForElementClickable(driver,nopCommerceLogo);
        clickToElement(driver,nopCommerceLogo);
    }

    public void enterToFirstNameTextbox(String firstNameValue) {
        waitForElementVisible(driver,firstNameTextbox);
        senkeyToElement(driver,firstNameTextbox,firstNameValue);


    }

    public void enterToLastNameTextbox(String lastNameValue) {
        waitForElementVisible(driver,lastNameTextbox);
        senkeyToElement(driver,lastNameTextbox,lastNameValue);
    }

    public void enterToEmailTextbox(String emailAddressValue) {
        waitForElementVisible(driver,emailTextbox);
        senkeyToElement(driver,emailTextbox,emailAddressValue);
    }

    public void enterToPasswordTextbox(String passwordValue) {
        waitForElementVisible(driver,passwordTextbox);
        senkeyToElement(driver,passwordTextbox,passwordValue);
    }

    public void enterToConfirmPasswordTextbox(String passwordValue) {
        waitForElementVisible(driver,confirmPasswordTextbox);
        senkeyToElement(driver,confirmPasswordTextbox,passwordValue);
    }

    public String getPasswordErrorMessageText2() {
        waitForElementVisible(driver,passwordErrorMsg2);
        return getElementText(driver,passwordErrorMsg2);
    }

    public String getConfirmPasswordErrorMessageText() {
        waitForElementVisible(driver,confirmPasswordErrorMsg);
        return getElementText(driver,confirmPasswordErrorMsg);
    }

    public String getRegisterSuccessMessageText() {
        waitForElementVisible(driver,successMessage);
        return getElementText(driver,successMessage);
    }
}
