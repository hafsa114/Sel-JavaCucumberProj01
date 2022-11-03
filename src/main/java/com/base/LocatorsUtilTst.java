package com.base;

import org.openqa.selenium.By;

public class LocatorsUtilTst {
    public static By alertcrossIcon     =By.xpath("//*[local-name()='svg' and contains(@class,'iHVDng')]/*[local-name()='path']");

    public static By signupCancelBtn     =By.xpath("//button[contains(text(),'Maybe later')]");
    public static By cookiesCancelBtn     =By.xpath("//div[contains(@class,'cookie-policy-banner__close')]");

    public static By showRowsDropdownVal=By.xpath("(//p[contains(normalize-space(text()),'Show rows')])[position()=1]/parent::div/div/*[local-name()='svg']");
    public static By selTotalRowsDDVal=By.xpath("//button[text()='100']");
    public static By totalRows          =By.xpath("//table[contains(@class,'cmc-table')]//tbody/tr");
//Filter Btn
    public static By FilterBtn          =By.xpath("(//span[@class='icon-Slider']//ancestor::button[contains(text(),'Filters')])[last()]");
    public static By AddFilterBtn       =By.xpath("//button[contains(normalize-space(text()),'+')]");
    public static By MoreFilterTxt       =By.xpath("//h4[contains(normalize-space(text()),'More Filters')]");

    public static By marketCapDDArrow   =By.xpath("//button[contains(normalize-space(text()),'Market Cap')]//*[local-name()='svg']");
    public static By marketCapMinInput  =By.xpath("//div[@data-qa-id='range-filter-mcap']//input[@data-qa-id='range-filter-input-min']");
    public static By marketCapMaxInput  =By.xpath("//div[@data-qa-id='range-filter-mcap']//input[@data-qa-id='range-filter-input-max']");
    public static By priceDDArrowBtn    =By.xpath("//button[contains(normalize-space(text()),'Price')]//*[local-name()='svg']");
    public static By priceMinInput      =By.xpath("//div[@data-qa-id='range-filter-price']//input[@data-qa-id='range-filter-input-min']");
    public static By priceMaxInput      =By.xpath("//div[@data-qa-id='range-filter-price']//input[@data-qa-id='range-filter-input-max']");
    public static By applyFilterBtn     =By.xpath("//button[contains(normalize-space(text()),'Apply Filter')]");
    public static By marketCapFilteredTxt     =By.xpath("//button[contains(normalize-space(text()),'Market Cap')]//h5");
    public static By priceFilteredTxt     =By.xpath(" //button[contains(normalize-space(text()),'Price')]//h5");
    public static By showResultsBtn     =By.xpath("//button[contains(normalize-space(text()),'Show results')]");
    public static By listMarketCapVal   =By.cssSelector("tbody>tr>td:nth-child(8)");
    public static By priceHeader   =By.cssSelector("//table/thead//p[contains(text(),'Price')]");


    public static By listpriceVal       =By.cssSelector("tbody>tr>td:nth-child(4)");





}
