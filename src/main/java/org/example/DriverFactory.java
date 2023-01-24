package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory{
    public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<>();
    public WebDriver driver_init(String browser){
        if (browser.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            tldriver.set(new FirefoxDriver());

        }
        else if (browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            tldriver.set(new ChromeDriver());
        }

        return getdriver();

    }

    public static synchronized WebDriver getdriver(){

        return tldriver.get();
    }


}