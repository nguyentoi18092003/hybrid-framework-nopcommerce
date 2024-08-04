package pageObject_factory;

import commons.BasePageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObject extends BasePageFactory {
    WebDriver driver;

    //day ms la khai bao, nos se tu dongn tim khi bien nay dc su dung(day la uu diem lon nhat cua page factory)
    @CacheLookup// dung de dung lai element cho lan goi thu nhat de k phai tim lai nua
    @FindBy(xpath="//a[@class='ico-register']")
    private WebElement registerLink;

    @FindBy(css="a.ico-account")
    private WebElement loginLink;

    @FindBy(xpath="//a[@class='ico-account']")
    private WebElement myAccountLink;

    public HomePageObject(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(this.driver,this);//cai nay no se tao ra ket noi giua cai ELement() vs FindBy (khi bien do duoc goi-su dung toi no se thuc hien di tim element)
    }

    public void clickToRegisterLink() {
        waitForElementClickable(driver,registerLink);// den day ms su dung register no moi bat dau tim
        clickToElement(driver,registerLink);//neu k co cacheLookup ben tren no se thuc hien tim lai
    }
    public void clickToMyAccountLink() {
        waitForElementClickable(driver,loginLink);
        clickToElement(driver,loginLink);
    }
    public void clickToMyAccount() {
        waitForElementClickable(driver, myAccountLink);
        clickToElement(driver, myAccountLink);
    }
}
