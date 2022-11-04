package com.base;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.File;

public class ControllerSelTest {
    private static WebDriver driver;
    private static final String CHROME_PATH="src/main/resources/chromedriver.exe";

    static {
        chromeDriverProperties();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static WebDriver getDriver(String browser) {
        if (null != driver) {
            if (browser == "CHROME") {
                return driver;
            }
            driver.quit();
        }


        switch (browser) {
            case "CHROME":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("start-maximized");
                options.addArguments("enable-automation");
                options.addArguments("–no-sandbox");
                options.addArguments("–disable-infobars");
                options.addArguments("–disable-extensions");
                options.addArguments("–dns-prefetch-disable");
                options.addArguments("–disable-dev-shm-usage");
                options.addArguments("–disable-browser-side-navigation");
                options.addArguments("–disable-gpu");
                options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver = new ChromeDriver();
                break;
            default:
                throw new IllegalArgumentException("Must supply a supported Browser type!");
        }
        return driver;
    }

    private static void chromeDriverProperties() {
        if (System.getProperty("webdriver.chrome.driver") == null && new File(CHROME_PATH).exists()) {
            System.setProperty("webdriver.chrome.driver", CHROME_PATH);
        }
    }


}
