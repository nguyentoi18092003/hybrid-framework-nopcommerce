package pageObjects_jquery;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs_jquery.HomePageUI;

import java.util.ArrayList;
import java.util.List;

public class HomePageObject extends BasePage {
    WebDriver driver;
    public HomePageObject(WebDriver driver){
        this.driver=driver;
    }
    public void inputToColumnTextboxByName(String columnName,String valueToSend){
        waitForElementVisible(driver, HomePageUI.COLUMN_TEXTBOX_BY_NAME,columnName);
        sendkeyToElement(driver,HomePageUI.COLUMN_TEXTBOX_BY_NAME,valueToSend,columnName);
    }
    public void clickToPageByNumber(String pageNumber){
        waitForElementClickable(driver,HomePageUI.PAGE_LINK_BY_NUMBER,pageNumber);
        clickToElement(driver,HomePageUI.PAGE_LINK_BY_NUMBER,pageNumber);

    }
    public boolean isPageActiveByNumber(String pageNumber){
        waitForElementVisible(driver,HomePageUI.PAGE_LINK_ACTIVE_BY_NUMBER,pageNumber);
        return isElementDisplayed(driver,HomePageUI.PAGE_LINK_ACTIVE_BY_NUMBER,pageNumber);

    }
    public boolean isRowValuesDisplayed(String female, String country,String male,String total){
        //sleepInSecond(50);
        waitForElementVisible(driver,HomePageUI.DYNAMIC_ROW_VALUES,female,country,male,total);
        return isElementDisplayed(driver,HomePageUI.DYNAMIC_ROW_VALUES,female,country,male,total);

    }
    public void clickToRowActionByCountryName(String country, String rowAction){
        waitForElementClickable(driver,HomePageUI.ROW_ACTION_BY_COUNTRY_NAME,country,rowAction);
        clickToElement(driver,HomePageUI.ROW_ACTION_BY_COUNTRY_NAME,country,rowAction);

    }

    public List<String> getAllPageValuesByColumnName(String columnName) {
        List<String> allValues=new ArrayList<String>();

        //Buoc 1: Lay ra tat ca cac page
        List<WebElement> allPageLinks=getListWebElement(driver,HomePageUI.ALL_PAGE_LINKS);

        //Lay ra stt cot, vi ten cot va ten du lieu mk can no cx stt nen dung cach nay
        int columnIndex=getListElementSize(driver,HomePageUI.COLUMN_INDEX_BY_COLUMN_NAME
        ,columnName);
        //Buoc 2 duyet qua tung page
        for(WebElement pageLink: allPageLinks){
            pageLink.click();
            sleepInSecond(2);
            //buoc 3 : Lay ra tat ca cac gia tri cua 1 cot trong page do-> Luu no vao list/set,..
            List<WebElement> allRowValues=getListWebElement(driver,HomePageUI.ALL_VALUE_BY_COLUMN_INDEX,String.valueOf(columnIndex));//ham string value la de chuyen tu int sang String

            for(WebElement rowValue:allRowValues){
                allValues.add(rowValue.getText());
            }
        }
        //in ra het tat ca gia tri cua 1 cot trong all page
        for(String value:allValues){
            System.out.println(value);
        }
        //Vi co the du lieu tren UI va DB khong dung thu tu nen ta phai sort triowc
        //........
        return allValues;
    }

    public List<String> getAllPageValuesByColumnNameInDB(String string) {
        //cx lay ra roi sort
        return null;
    }

    public List<String> getAllPageValuesByColumnNameInAPI(String country) {
        //cx lay ra roi sort
        return null;
    }

    public void enterToTextboxByColumnNameAndRowIndex(String columnName,String rowIndex,String valueToSend) {
        int columnIndex=getListElementSize(driver,HomePageUI.DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME,columnName)+1;
        waitForElementVisible(driver,HomePageUI.DYNAMIC_TEXTBOX_BY_ROW_INDEX_AND_COLUMN_INDEX,rowIndex,String.valueOf(columnIndex));
        sendkeyToElement(driver,HomePageUI.DYNAMIC_TEXTBOX_BY_ROW_INDEX_AND_COLUMN_INDEX,valueToSend,rowIndex,String.valueOf(columnIndex));
    }

    public void selectDropdownByColumnNameAndRowIndex(String columnName,String rowIndex, String dropdownItem) {
        int columnIndex=getListElementSize(driver,HomePageUI.DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME,columnName)+1;
        waitForElementVisible(driver,HomePageUI.DYNAMIC_DROPDOWN_BY_ROW_INDEX_AND_COLUMN_INDEX,rowIndex,String.valueOf(columnIndex));
        selectItemInDefaultDropdown(driver,HomePageUI.DYNAMIC_DROPDOWN_BY_ROW_INDEX_AND_COLUMN_INDEX,dropdownItem,rowIndex,String.valueOf(columnIndex));

    }

    public void clickToCheckboxByColumnNameAndRowIndex(String columnName,String rowIndex) {
        int columnIndex=getListElementSize(driver,HomePageUI.DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME,columnName)+1;
        waitForElementClickable(driver,HomePageUI.DYNAMIC_CHECKBOX_BY_ROW_INDEX_AND_COLUMN_INDEX,rowIndex,String.valueOf(columnIndex));
        checkToElement(driver,HomePageUI.DYNAMIC_CHECKBOX_BY_ROW_INDEX_AND_COLUMN_INDEX,rowIndex,String.valueOf(columnIndex));
    }
}
