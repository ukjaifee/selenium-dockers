package com.umesh.tests;

import com.umesh.Constants.Constants;
import com.umesh.util.Config;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class AbstractTest {

    protected WebDriver driver;
    protected RemoteWebDriver remoteWebDriver;

    @BeforeSuite
    public void setConfig(){
        Config.initialize();
    }

    @BeforeTest
    public void setDriver() throws MalformedURLException {
        this.driver=Boolean.parseBoolean(Config.get(Constants.GRID_ENABLED)) ? RemoteWebDriver() : getLocalDriver();
    }

    public WebDriver RemoteWebDriver() throws MalformedURLException {
        Capabilities capabilities;
        //if(Boolean.getBoolean("selenium.grid.enabled"))
         if(System.getProperty(Constants.BROWSER).equalsIgnoreCase(Constants.CHROME)){
            capabilities=new ChromeOptions();}
         else {
             capabilities=new FirefoxOptions();
         }
         String gridUrl=Config.get(Constants.GRID_URL_FORMAT);
         String gridHost=Config.get(Constants.GRID_HUB_HOST);
         String url= String.format(gridUrl,gridHost);
        System.out.println("the value of url is :"+url);
      return  new RemoteWebDriver(new URL(url), capabilities);
    }

    public WebDriver getLocalDriver(){
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    @AfterTest
    public void quitDriver(){
        this.driver.quit();
    }

    @AfterMethod
    public void sleep() throws InterruptedException {
        Thread.sleep(3000);

    }

    //docker-compose up --scale firefox=2 --scale chrome=0 -d

}
