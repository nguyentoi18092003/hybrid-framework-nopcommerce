package pageObjects;

import commons.BasePage;
import commons.PageGeneratortManager;
import org.openqa.selenium.WebDriver;
import pageUIs.CustomerPageUI;

public class AddressPageObject extends BasePage {
    WebDriver driver;
    public AddressPageObject(WebDriver driver){
        this.driver=driver;

    }


}
