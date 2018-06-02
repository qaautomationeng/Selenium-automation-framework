package com.testautomationframework.browsersdriver;

import java.io.File;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

public class GeckoDriverManager extends AutomationGlobalDriverManager {

    private GeckoDriverService chService;

    @Override
    public void startService() {
        if (null == chService) {
            try {
                chService = new GeckoDriverService.Builder()
                    .usingDriverExecutable(new File(".\\BrowserDrivers\\geckodriver.exe"))
                    .usingAnyFreePort()
                    .build();
                chService.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void stopService() {
        if (null != chService && chService.isRunning())
            chService.stop();
    }

    @Override
    public void createDriver() {
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("test-type");
        options.addArguments("--disable-extensions");
        capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
        driver = new FirefoxDriver(options);
    }

}
