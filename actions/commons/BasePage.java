package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;
///me that 1

public class BasePage {
    //    Web browswer
    public void openPageUrl(WebDriver driver, String pageUrl){
        driver.get(pageUrl);
    }

    public String getPageTile(WebDriver driver){
        return driver.getTitle();

    }

    public String getCurrentPageUrl(WebDriver driver){
        return driver.getCurrentUrl();
    }

    public String getPageSourceCode(WebDriver driver){
        return driver.getPageSource();
    }

    public void backToPage(WebDriver driver) {
        driver.navigate().back();
    }

    public void forwordToPage(WebDriver driver){
        driver.navigate().forward();
    }

    public void refreshCurrentPage(WebDriver driver){
        driver.navigate().refresh();
    }

    public Alert waitForAlertPresence(WebDriver driver){
        return new WebDriverWait (driver, Duration.ofSeconds(30)).until(ExpectedConditions.alertIsPresent());
    }

    public void acceptToAlert(WebDriver driver){
        waitForAlertPresence(driver).accept();
    }

    public void cancelToAlert(WebDriver driver){
        waitForAlertPresence(driver).dismiss();
    }

    public String getTextInAlert(WebDriver driver){
        return waitForAlertPresence(driver).getText();
    }

    public void sendkeyToAlert(WebDriver driver, String keysToSend){
        waitForAlertPresence(driver).sendKeys(keysToSend);
    }

    public void switchToWindowByID(WebDriver driver,String expectedID){
        //Ham nay ch su dung khi co 2 tab dang duco mo
        //Lay ra ID cua tab hien tai, chu y tat ca cac window/ tab deu co 1 cai ID cau no
        String parentID=driver.getWindowHandle();

        //Lay ra ID cua tat ca cac tab/windown dang duoc mo
        Set<String> allIDs=driver.getWindowHandles();

        //Dung vong lap duyetj qua tung ID
        for(String id:allIDs) {
            //Neu nhu 1 iD nao ma khac voi parentID thi switch vao(TH nay co 2 cai ID thoai)
            if (!id.equals(expectedID)) {//title cac tab k giong nhau ddc nene k lo trung
                driver.switchTo().window(id);
                break;
            }
        }

    }

    public void switchToWindowByTilte(WebDriver driver,String expectedTitle){
        //Lay het tat caa ID cua cac window/tab
        Set<String> allIDs=driver.getWindowHandles();

        //Dung vong lap de duyet qua Set ID o tren
        for(String id:allIDs){
            //cho switch vao tung ID truowc
            driver.switchTo().window(id);
            //Lay ra tile cua tab/window hien tai
            String actualTitle=driver.getTitle();
            if(actualTitle.equals(expectedTitle)){
                break;
            }
        }

    }

    public void closeAllWindowWithoutParent(WebDriver driver,String parentID){
        //Lay het tat caa ID cua cac window/tab
        Set<String> allIDs=driver.getWindowHandles();

        //Dung vong lap de duyet qua Set ID o tren
        for(String id:allIDs){
            if(!id.equals(parentID)){
                driver.switchTo().window(id);
                driver.close();
            }
        }
        driver.switchTo().window(parentID);// chu y van phai co cau lenh chuyene driver ve nhoa
        //sau cuoi cx chi con moi tab cha thoi

    }

    public void sleepInSeconds(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public Set<Cookie> getBrowserCookies(WebDriver driver){
        return driver.manage().getCookies();
    }

    public void setCookies(WebDriver driver, Set<Cookie> cookies){
        for(Cookie cookie :cookies){
            driver.manage().addCookie(cookie);
        }
    }

    public void deleteAllCookies(WebDriver driver){
        driver.manage().deleteAllCookies();
    }

    //Web Element
    public By getByXpath(String locator){
        return By.xpath(locator);
    }

    public WebElement getWebElement(WebDriver driver,String locator){
        return driver.findElement(getByXpath(locator));
    }

    public List<WebElement> getListWebElement(WebDriver driver, String locator){
        return driver.findElements(getByXpath(locator));
    }

    public  void clickToElement(WebDriver driver, String locator){
        getWebElement(driver,locator).click();
    }

    public void senKeyToElement(WebDriver driver,String locator,String valueToSend){
        getWebElement(driver,locator).clear();
        getWebElement(driver,locator).sendKeys(valueToSend);
    }

    public void selectItemInDefaultDropdown(WebDriver driver, String locator, String itemValue){
        new Select(getWebElement(driver,locator)).selectByVisibleText(itemValue);
    }

    public String getFirstSelectedTextInDefaultDropdown(WebDriver driver,String locator){
        return new Select(getWebElement(driver,locator)).getFirstSelectedOption().getText();
    }

    public boolean isDefaultDropdownMultiple(WebDriver driver,String locator){
        return new Select(getWebElement(driver,locator)).isMultiple();
    }

    public void selectItemDropdown(WebDriver driver,String parentLocator, String childLocator, String itemTextExpected) {
        getWebElement(driver,parentLocator).click();
        sleepInSeconds(1);
        List<WebElement> allItems = new WebDriverWait(driver,Duration.ofSeconds(30)).until(ExpectedConditions.
                presenceOfAllElementsLocatedBy(getByXpath(childLocator)));

        for (WebElement item : allItems) {
            String textItems = item.getText();
            if (textItems.equals(itemTextExpected)) {
                item.click();
                break;
            }
        }
    }

    public String getElementText(WebDriver driver,String locator){
        return getWebElement(driver,locator).getText();
    }

    public String getElementAttribute(WebDriver driver,String locator,String attributeName){
        return getWebElement(driver,locator).getAttribute(attributeName);
    }

    public String getElementCssValue(WebDriver driver,String locator,String cssPropertyName){
        return getWebElement(driver,locator).getCssValue(cssPropertyName);
    }

    public String convertRGBAToHexaColor(WebDriver driver,String locator){
        return Color.fromString(getElementCssValue(driver,locator,"background-color")).asHex();
    }

    public int getListElementSize(WebDriver driver,String locator){
        return getListWebElement(driver,locator).size();
    }
    //Apply for checkbox and radio button
    public void checkToElement(WebDriver driver, String locator){
        if(!getWebElement(driver,locator).isSelected()){
            getWebElement(driver,locator).click();
        }
    }
    //only apply for checkbox
    public void uncheckToElement(WebDriver driver, String locator){
        if(!getWebElement(driver,locator).isSelected()){
            getWebElement(driver,locator).click();
        }
    }

    public boolean isElementDisplayed(WebDriver driver, String locator){
        return getWebElement(driver,locator).isDisplayed();
    }

    public boolean isElementSelected(WebDriver driver,String locator){
        return getWebElement(driver,locator).isSelected();
    }

    public boolean isElementEnable(WebDriver driver,String locator){
        return getWebElement(driver,locator).isEnabled();
    }

    public void switchToIframe(WebDriver driver,String locator){
        new WebDriverWait(driver,Duration.ofSeconds(30)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(getByXpath(locator)));//vua wait vua switch luon
    }

    public void switchToDefaultContent(WebDriver driver){
        driver.switchTo().defaultContent();//swith ve trang truoc do(trang truoc khi mk switch vao)
    }

    public void hoverToElement(WebDriver driver, String locator){
        new Actions(driver).moveToElement(getWebElement(driver,locator)).perform();
    }

    public void doubleClickElement(WebDriver driver,String locator){
        new Actions(driver).doubleClick(getWebElement(driver,locator));
    }

    public void  rightClickElement(WebDriver driver,String locator){
        new Actions(driver).contextClick(getWebElement(driver,locator));
    }

    public void dragAndDropElement(WebDriver driver,String sourceLocator, String targetLocator){
        new Actions(driver).dragAndDrop(getWebElement(driver,sourceLocator),getWebElement(driver,targetLocator)).perform();
    }

    public void sendKeyBoardToElement(WebDriver driver, String locator, Keys key){
        new Actions(driver).sendKeys(getWebElement(driver,locator),key).perform();
    }

    public Object executeForBrowser(WebDriver driver,String javaScript) {
        return ((JavascriptExecutor) driver).executeScript(javaScript);
    }

    public String getInnerText(WebDriver driver) {
        return (String) ((JavascriptExecutor) driver).executeScript("return document.documentElement.innerText;");
    }

    public void sleepInSecond(int timeout) {
        try {
            Thread.sleep(timeout * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean areExpectedTextInInnerText(WebDriver driver,String textExpected) {
        String textActual = (String) ((JavascriptExecutor) driver).executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0];");
        return textActual.equals(textExpected);
    }

    public void scrollToBottomPage(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void navigateToUrlByJS(WebDriver driver,String url) {
        ((JavascriptExecutor) driver).executeScript("window.location = '" + url + "'");

    }

    public void hightlightElement(WebDriver driver,String locator) {
        WebElement element = getWebElement(driver,locator);
        String originalStyle = element.getAttribute("style");
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
        sleepInSecond(2);
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
    }

    public void clickToElementByJS(WebDriver driver,String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", getWebElement(driver,locator));
        sleepInSecond(3);
    }

    public void scrollToElementOnTop(WebDriver driver,String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver,locator));
    }

    public void scrollToElementOnDown(WebDriver driver,String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", getWebElement(driver,locator));
    }

//    public void setAttributeInDOM(WebDriver driver,String locator, String attributeName, String attributeValue) {
//        jsExecutor.executeScript("arguments[0].setAttribute('" + attributeName + "', '" + attributeValue +"');", getWebElement(locator));
//    }

    public void removeAttributeInDOM(WebDriver driver,String locator, String attributeRemove) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver,locator));
    }

    public void sendkeyToElementByJS(WebDriver driver,String locator, String value) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + value + "')", getWebElement(driver,locator));
    }

//    public String getAttributeInDOM(WebDriver driver,String locator, String attributeName) {
//        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].getAttribute('" + attributeName + "');", getWebElement(driver,locator));
//    }

    public String getElementValidationMessage(WebDriver driver,String locator) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", getWebElement(driver,locator));
    }

    public boolean isImageLoaded(WebDriver driver,String locator) {
        return (boolean) ((JavascriptExecutor) driver).executeScript(
                "return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0", getWebElement(driver,locator));

    }

    public void waitForElementVisible(WebDriver driver,String locator){
        new WebDriverWait(driver,Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
    }

    public void waitForListElementVisible(WebDriver driver,String locator){
        new WebDriverWait(driver,Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfAllElements(getListWebElement(driver,locator)));
    }

    public void waitForElementInvisible(WebDriver driver,String locator){
        new WebDriverWait(driver,Duration.ofSeconds(30)).until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(locator)));
    }

    public void waitForListElementInvisible(WebDriver driver,String locator){
        new WebDriverWait(driver,Duration.ofSeconds(30)).until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver,locator)));
    }

    public void waitForElementClickable(WebDriver driver, String locator){
        new WebDriverWait(driver,Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(getWebElement(driver,locator)));
    }








}


