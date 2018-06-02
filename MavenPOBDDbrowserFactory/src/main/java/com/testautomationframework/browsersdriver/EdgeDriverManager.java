package com.testautomationframework.browsersdriver;

import java.io.File;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class EdgeDriverManager extends AutomationGlobalDriverManager {

    private EdgeDriverService chService;

    @Override
    public void startService() {
        if (null == chService) {
            try {
                chService = new EdgeDriverService.Builder()
                    .usingDriverExecutable(new File(".\\BrowserDrivers\\MicrosoftWebDriver.exe"))
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
        DesiredCapabilities capabilities = DesiredCapabilities.edge();
        EdgeOptions options = new EdgeOptions();
        capabilities.setCapability(EdgeOptions.CAPABILITY, options);
        driver = new EdgeDriver(options);
    }

}
