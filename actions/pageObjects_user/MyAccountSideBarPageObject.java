package pageObjects_user;

import commons.BasePage;
import commons.PageGeneratortManager;
import org.openqa.selenium.WebDriver;
import pageUIs_user.MyAccountSideBarPageUI;

public class MyAccountSideBarPageObject extends BasePage {
    WebDriver driver;
    public MyAccountSideBarPageObject(WebDriver driver){
        this.driver=driver;
    }

    //day la nhung trang dung chung(Phan dung chung thi nem vo day)- con dung rinf thi van viet o page object class
    public AddressPageObject openAddressPage() {
        waitForElementClickable(driver, MyAccountSideBarPageUI.ADDRESS_LINK_TEXT);
        clickToElement(driver,MyAccountSideBarPageUI.ADDRESS_LINK_TEXT);
        return PageGeneratortManager.getAddressPage(driver);
    }

    public OrderPageObject openOrderPage() {
        waitForElementClickable(driver,MyAccountSideBarPageUI.ORDER_LINK_TEXT);
        clickToElement(driver,MyAccountSideBarPageUI.ORDER_LINK_TEXT);
        return PageGeneratortManager.getOrderPage(driver);
    }

    public RewardPointPageObject openRewardPointPage() {
        waitForElementClickable(driver,MyAccountSideBarPageUI.REWARD_POINT_LINK_TEXT);
        clickToElement(driver,MyAccountSideBarPageUI.REWARD_POINT_LINK_TEXT);
        return PageGeneratortManager.getRewardPointPage(driver);

    }

    public CustomerPageObject openCustomerPage() {
        waitForElementClickable(driver, MyAccountSideBarPageUI.ORDER_INFO_LINK_TEXT);
        clickToElement(driver,MyAccountSideBarPageUI.ORDER_INFO_LINK_TEXT);
        return PageGeneratortManager.getCustomerPage(driver);
    }
    //Gonj hon cach 1: 4 ham ben tren duoc goi gon thanh ham nay, ham nya chuyen trang va khoi tao doi tuong luon
    public MyAccountSideBarPageObject openDynamicSideBarPage(String pageName){//Kieu tra ve o day deu la cha cua cac cai return
        waitForElementClickable(driver,MyAccountSideBarPageUI.DYNAMIC_SIDEBAR_LINK_TEXT,pageName);
        clickToElement(driver,MyAccountSideBarPageUI.DYNAMIC_SIDEBAR_LINK_TEXT,pageName);
        switch(pageName){
            case "Customer info":
                return PageGeneratortManager.getCustomerPage(driver);
            case "Addresses":
                return PageGeneratortManager.getAddressPage(driver);
            case"Orders":
                return PageGeneratortManager.getOrderPage(driver);
            case "Reward points":
                return PageGeneratortManager.getRewardPointPage(driver);
            default:
                new RuntimeException("Sidebar Page is inccorect");
                return null;
        }

    }
    //goi gon hon cach 2: 4 ham ben tren goi gon thnanh ham nay, ham nay chi chuyen trang nhunwg k khoi tao doi tuong, khoi tao doi tuong de tang testcase lam
    public void openDynamicSideBarPageByName(String pageName) {
        waitForElementClickable(driver, MyAccountSideBarPageUI.DYNAMIC_SIDEBAR_LINK_TEXT, pageName);
        clickToElement(driver, MyAccountSideBarPageUI.DYNAMIC_SIDEBAR_LINK_TEXT, pageName);
    }

}
