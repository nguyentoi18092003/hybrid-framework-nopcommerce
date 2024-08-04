package pageObject_factory;

import commons.BasePageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject extends BasePageFactory {
    WebDriver driver;
    public LoginPageObject(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(this.driver,this);//cai nay no se tao ra ket noi giua cai ELement() vs FindBy (khi bien do duoc goi-su dung toi no se thuc hien di tim element)
    }
}
