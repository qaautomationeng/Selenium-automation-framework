package com.testautomationframework.browsersdriver;

import java.io.File;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;


public class ChromeDriverManager extends AutomationGlobalDriverManager {

    private ChromeDriverService chromeService;

    @Override
    public void startService() {
        if (null == chromeService) {
            try {
            	
                chromeService = new ChromeDriverService.Builder()
                    .usingDriverExecutable(new File(".\\BrowserDrivers\\chromedriver.exe"))
                    .usingAnyFreePort()
                    .build();
                chromeService.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void stopService() {
        if (null != chromeService && chromeService.isRunning())
            chromeService.stop();
    }

    @Override
    public void createDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("test-type");
        options.addArguments("--disable-extensions");
        System.setProperty("webdriver.chrome.driver",".\\BrowserDrivers\\chromedriver.exe");
        driver = new ChromeDriver(options);
    }

}
