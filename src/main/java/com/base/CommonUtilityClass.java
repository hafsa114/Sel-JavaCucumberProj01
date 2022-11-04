package com.base;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static com.base.LocatorsUtilTst.*;

public class CommonUtilityClass extends ControllerSelTest {
private Actions actions;
 private  static ReadConfig prop=new ReadConfig();

    public static WebElement findEle(By element, WebDriver driver){
       return driver.findElement(element);

    }
    public static void navigateToBaseUrl(WebDriver driver){
        driver.get(prop.getApplicationURL());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        HandleAlerts(driver);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        handlecookiesCancelIcon(driver);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
  }


    private static void HandleAlerts(WebDriver driver) {
        if(isElementDisplayed(alertcrossIcon,driver))
            driver.findElement(alertcrossIcon).click();
        else
            System.out.println("No action needed");

    }
    public static void HandleAlertsSignup(WebDriver driver) {
        if(isElementDisplayed(signupCancelBtn,driver))
            driver.findElement(signupCancelBtn).click();
        else
            System.out.println("No action needed");

    }
    public static void handlecookiesCancelIcon(WebDriver driver) {
        if(isElementDisplayed(cookiesCancelBtn,driver))
            driver.findElement(cookiesCancelBtn).click();
        else
            System.out.println("No action needed");

    }
    public  List<WebElement> getWebElements_List(By element, WebDriver driver) {
        List<WebElement> webEleList = driver.findElements(element);
        return webEleList;
    }
    public  void scrollAction(By element,WebDriver driver ) {
        WebElement ele = findEle(element,driver);
        actions = new Actions(driver);
        actions.moveToElement(ele);
        actions.perform();
     }
    public  void sendText(By element, String text,WebDriver driver) {
        try {
            waitUntilElementLoad(element, 30,driver);
            findEle(element,driver).sendKeys(text);
    } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public  void sendKeys(By element, String text,WebDriver driver) {
       try {
            waitUntilElementLoad(element, 30,driver);
            WebElement ele =findEle(element,driver);
            ele.click();
            ele.sendKeys(Keys.chord(Keys.CONTROL, "a"));
            ele.sendKeys(Keys.BACK_SPACE);
            ele.sendKeys(text);
        } catch (Exception e) {
           e.printStackTrace();
        }

    }
    public  void ScrollIntoView(By element,WebDriver driver) {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
                    findEle(element,driver));
        } catch (Exception e) {
        }
    }
    public  void clickEle(By element,WebDriver driver) {

        try {
            findEle(element,driver).click();
         } catch (Exception e) {
              e.printStackTrace();
        }

    }
    public void moveToElement(By element,WebDriver driver){
        Actions actions = new Actions(driver);
        actions.moveToElement(findEle(element,driver));
        actions.perform();
        findEle(element,driver).click();

    }
    public static boolean verifyElementDisplayed(By element,WebDriver driver) {
        return findEle(element,driver).isDisplayed();
    }

    public static boolean isElementDisplayed(By element,WebDriver driver) {
        try {
            return verifyElementDisplayed(element, driver);
        } catch (Exception e) {
            return false;
        }
    }
    public  String getText(By element,WebDriver driver) {
        return findEle(element,driver).getText();
    }

    public  void wait(WebDriver driver, int waitSeconds) {
        driver.manage().timeouts().implicitlyWait(waitSeconds, TimeUnit.SECONDS);

    }

    public void waitUntilVisibility_Ele(By element, int waitSeconds,WebDriver driver) {

        WebDriverWait wait = new WebDriverWait(driver, waitSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public static void waitUntilElementLoad(By element, int waitSeconds,WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, waitSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));

    }
    public static void waitUntilEle_ToBe_Clickable(By element, int waitSeconds,WebDriver driver) {

        WebDriverWait wait = new WebDriverWait(driver, waitSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

}
