package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.*;

public class ReadConfig {
    static Properties prop;
    static String propertyFilePath= "src/main/resources/config.properties";


    public ReadConfig()
    {
        File src = new File(propertyFilePath);
        try
        {
            FileInputStream fis=new FileInputStream(src);
            prop=new Properties();
            prop.load(fis);
        }
        catch(Exception e)
        {
            System.out.println("Exception is "+e.getMessage());
        }
    }
    public String getApplicationURL()
    {
        String url=prop.getProperty("app_url");
        return url;

    }
    public String getBrowser()
    {
        String browser=prop.getProperty("browser");
        return browser;

    }

    public String getPropertyVal(String propertyKey)
    {
        String propertyVal=prop.getProperty(propertyKey);
        return propertyVal;
    }
    public String geRowCount()
    {
        String propertyVal=prop.getProperty("rowCount");
        return propertyVal;
    }
    public String getMarketRangeVal()
    {
        String propertyVal=prop.getProperty("marketCapFilterRange");
        return propertyVal;
    }
    public String getPriceRangeVal()
    {
        String propertyVal=prop.getProperty("priceFilterRange");
        return propertyVal;
    }

    public void putPriceRange(String priceRangeVal)
    {
        putVal("priceFilterRange",priceRangeVal);

    }
    public void putMarketRange(String marketCapRangeVal)
    {
        putVal("marketCapFilterRange",marketCapRangeVal);

    }
    public void putRowCount(String noOfRows)
    {
        putVal("rowCount",noOfRows);

    }
    public void putVal(String key,String value){
        try
        {
            FileOutputStream globalFileOut = new FileOutputStream(propertyFilePath);
            prop.setProperty(key, value);
            prop.store(globalFileOut, null);
            globalFileOut.close();
            System.out.println(value+" is stored in property file");

        }catch(Exception e)
        {
            System.out.println(value+" is not stored in property file");

        }
    }

}
