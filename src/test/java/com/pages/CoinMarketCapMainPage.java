package com.pages;

import com.base.CommonUtilityClass;
import com.base.ControllerSelTest;
import com.base.ReadConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import java.math.BigDecimal;
import java.util.*;
import static com.base.LocatorsUtilTst.*;


public class CoinMarketCapMainPage extends ControllerSelTest {
 final static Logger log=  LoggerFactory.getLogger(CoinMarketCapMainPage.class);
    static CommonUtilityClass commonUtils=new CommonUtilityClass();
    private  static ReadConfig prop=new ReadConfig();

    public static void selRowCount(String noOfRows, WebDriver driver){
        commonUtils.ScrollIntoView(showRowsDropdownVal,driver);
        commonUtils.moveToElement(showRowsDropdownVal,driver);
        commonUtils.wait(driver,4000);
        commonUtils.ScrollIntoView(selTotalRowsDDVal,driver);
        commonUtils.clickEle(selTotalRowsDDVal,driver);
        log.info("Rows count is selected successfully");

}

  public static void validateNoOfRowsShow(String noOfRows, WebDriver driver){
      commonUtils.ScrollIntoView(totalRows,driver);
      commonUtils.wait(driver,40);
      List<WebElement> totalRowsDisplayed=commonUtils.getWebElements_List(totalRows,driver);
      Assert.assertEquals(String.valueOf(totalRowsDisplayed.size()),noOfRows,"UI displays total "+noOfRows +"as selected");
   }

   public static void clickFilterButton(WebDriver driver){
       commonUtils.wait(driver,40);
       commonUtils.ScrollIntoView(FilterBtn,driver);
       commonUtils.moveToElement(FilterBtn,driver);
       CommonUtilityClass.isElementDisplayed(AddFilterBtn,driver);
       log.info("Filter Button is clicked and Add filter button display");

   }
    public static void addFilterButton(WebDriver driver){
        commonUtils.wait(driver,40);
        commonUtils.ScrollIntoView(AddFilterBtn,driver);
        commonUtils.moveToElement(AddFilterBtn,driver);
        commonUtils.ScrollIntoView(MoreFilterTxt,driver);
        Assert.assertEquals("More Filters",commonUtils.getText(MoreFilterTxt,driver));
        commonUtils.wait(driver,30);
        commonUtils.HandleAlertsSignup(driver);
        commonUtils.wait(driver,30);
        log.info("More Filter pop displays success to set filter range");
    }


    private static void filterArrowBtnClick(By element, WebDriver driver, By inputField){
        commonUtils.ScrollIntoView(element,driver);
        commonUtils.clickEle(element,driver);
        commonUtils. waitUntilVisibility_Ele(inputField,20,driver);
    }
    private static void inputFilterValues(By minValField, By maxValField, String minValue, String maxValue, WebDriver driver){
        commonUtils.ScrollIntoView(minValField,driver);
        commonUtils.clickEle(minValField,driver);
        commonUtils.sendText(minValField,minValue,driver);
        commonUtils.clickEle(maxValField,driver);
        commonUtils.sendText(maxValField,maxValue,driver);
        log.info("Filter Range Set Successfully");


    }
    public static void setFilterMarketCapField(String fieldName ,String minValue, String maxValue,WebDriver driver) {
        addFilterButton(driver);
        filterArrowBtnClick(marketCapDDArrow, driver, marketCapMaxInput);
        inputFilterValues(marketCapMinInput, marketCapMaxInput, minValue, maxValue, driver);
        log.info(fieldName+"Filter Range Set Successfully");
    }
    public static void setFilterPriceField(String fieldName ,String minValue, String maxValue, WebDriver driver){

        filterArrowBtnClick(priceDDArrowBtn,driver,priceMaxInput);
        inputFilterValues(priceMinInput,priceMaxInput,minValue,maxValue,driver);
        log.info(fieldName+"Filter Range Set Successfully");

    }

    public static void applyFilter(WebDriver driver){
        commonUtils.wait(driver,20);
        commonUtils.ScrollIntoView(applyFilterBtn,driver);
        commonUtils.clickEle(applyFilterBtn,driver);
        log.info("Applied filter");

    }
    public static void showResultsClick(String marketCapFilterRange, String priceFilterRange, WebDriver driver){
        commonUtils.ScrollIntoView(marketCapFilteredTxt,driver);
        commonUtils.wait(driver,20);
         Assert.assertEquals(marketCapFilterRange,commonUtils.getText(marketCapFilteredTxt,driver),"Selected marketcap filter range matches with given range i.e;"+prop.getMarketRangeVal());
         Assert.assertEquals(priceFilterRange,commonUtils.getText(priceFilteredTxt,driver),"Selected price filter range matches with given range i.e;"+prop.getPriceRangeVal());
         commonUtils.clickEle(showResultsBtn,driver);
         log.info("Selected filter range is validated and clicked on show results successfully");

    }


    public static void verifyFilteredData(By by,String minVal, String maxVal,WebDriver driver){
        commonUtils.ScrollIntoView(priceHeader,driver);
        commonUtils.wait(driver,5);
        List<WebElement> weList;
        try{
            weList = commonUtils.getWebElements_List(by,driver);
        }catch(Exception e){
            weList = commonUtils.getWebElements_List(by,driver);
        }
        commonUtils.wait(driver,5);
        Set<BigDecimal> mySet = new HashSet<>();
        for(int i =0;i<weList.size();i++){
            String temp = weList.get(i).getText().replace("$","").replace(",","");
            BigDecimal price = new BigDecimal(temp);
            mySet.add(price);
        }
        BigDecimal expectedMin = new BigDecimal(minVal);
        BigDecimal expectedMax = new BigDecimal(maxVal);
        BigDecimal actualMin = Collections.min(mySet);
        BigDecimal actualMax = Collections.max(mySet);
        Boolean flag;
        if((expectedMin.max(actualMin).equals(actualMin)) && (expectedMax.min(actualMax).equals(actualMax))){
            flag=true;
        }else{
            flag=false;
        }
        Boolean expectedFlag=true;
       Assert.assertEquals(flag,expectedFlag,"The values displayed after applying filters are as expected in given range");

    }


}
