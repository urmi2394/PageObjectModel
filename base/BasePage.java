package com.nopcommerce.demo.base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BasePage {
    WebDriver driver;
    Properties prop;

    public WebDriver initialiseDriver(String browserName) {
        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\baps\\IdeaProjects\\pageobjectmodel\\src\\test\\resources\\BrowserDriver\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if(browserName.equals("firefox")){
            System.setProperty("webdriver.firefox.driver","C:\\Users\\baps\\IdeaProjects\\pageobjectmodel\\src\\test\\resources\\BrowserDriver\\geckodriver.exe");

        }else if(browserName.equals("edge")){
            System.setProperty("webdriver.edge.driver","C:\\Users\\baps\\IdeaProjects\\pageobjectmodel\\src\\test\\resources\\BrowserDriver\\msedgedriver.exe");

        } else{
            System.out.println("Browser is invalid, please enter correct browser name");
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        return driver;
    }

    public Properties initialiseProperties(){

        prop = new Properties();

        try{
            FileInputStream ip = new FileInputStream("C:\\Users\\baps\\IdeaProjects\\pageobjectmodel\\src\\test\\resources\\TestData\\config.properties");

            prop.load(ip);
        } catch (FileNotFoundException e) {
            System.out.println("Config file is missing, please check...");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("properties could not be loaded...");
            e.printStackTrace();
        }
        return prop;
    }
}
