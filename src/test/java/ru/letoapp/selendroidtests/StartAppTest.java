package ru.letoapp.selendroidtests;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.selendroid.common.SelendroidCapabilities;
import io.selendroid.standalone.SelendroidConfiguration;
import io.selendroid.client.SelendroidDriver;
import io.selendroid.standalone.SelendroidLauncher;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class StartAppTest {
    SelendroidConfiguration serverConfig;
    SelendroidLauncher server;
    SelendroidCapabilities capabilities;
    WebDriver driver;   

    @Test
    public void test() throws Exception {
        String appPath = "src/main/resources/Prometheus-0.6.9.8.apk";        
        boolean forceReinstall = true;
        boolean clearData = true;
        startServer(appPath, forceReinstall, clearData);
        String appUnderTestId = "ru.letobank.Prometheus:0.6.9.8";
        String serverUrl = "http://localhost:4444/wd/hub";        
        initDriver(appUnderTestId, serverUrl);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);        
        driver.findElement(By.id("sdl__positive_button")).click();     
    }

    private void startServer(String appPath, boolean forceReinstall, boolean clearData) {
        serverConfig = new SelendroidConfiguration();
        serverConfig.addSupportedApp(appPath);
        serverConfig.setPort(4444);
        serverConfig.setSelendroidServerPort(38080);
        serverConfig.setForceReinstall(forceReinstall);
        serverConfig.setNoClearData(clearData);
        serverConfig.setShouldKeepAdbAlive(true);
        serverConfig.setPrintHelp(true);
        server = new SelendroidLauncher(serverConfig);
        server.launchSelendroid();
    }

    private void initDriver(String appUnderTestId, String serverUrl, String appActivity) throws Exception {
        capabilities = new SelendroidCapabilities();
        capabilities.setAut(appUnderTestId);      
        capabilities.setLaunchActivity(appActivity);
        this.driver = new SelendroidDriver(new URL(serverUrl), capabilities);
    } 
    
    private void initDriver(String appUnderTestId, String serverUrl) throws Exception {
        capabilities = new SelendroidCapabilities();
        capabilities.setAut(appUnderTestId);      
        this.driver = new SelendroidDriver(new URL(serverUrl), capabilities);
    }
}