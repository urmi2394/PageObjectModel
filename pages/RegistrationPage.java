package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {
    WebDriver driver;
    Utils utils;

    By gender = By.id("gender-female");
    By fName = By.name("FirstName");
    By lName = By.name("LastName");
    WebElement Day = (WebElement) By.name("DateOfBirthDay");
    WebElement Month =(WebElement) By.name("DateOfBirthMonth");
    WebElement Year = (WebElement) By.name("DateOfBirthYear");
    By email = By.id("Email");
    By coName = By.id("Company");
    By Letter = By.id("Newsletter");
    By pwd = By.id("Password");
    By confirmPwd = By.id("ConfirmPassword");
    By regButton = By.className("register-next-step-button");

    public RegistrationPage(WebDriver driver){
        this.driver =driver;
        utils = new Utils(driver);
    }

    public String getPageTitle(){
        String title = driver.getTitle();
        utils.waitForTitlePresent(title, 10);
        System.out.println("Register page title is :" + title);
        return title;
    }

    public boolean verifyRegisterButton(){
        return driver.findElement(regButton).isDisplayed();
    }
    public void doRegister(String property){
        utils.waitForElementToBeVisible(gender,10);
        utils.doClick(gender);
        utils.doSendKeys(fName,"urmi");
        utils.doSendKeys(lName,"Patel");
        utils.selectValueFromDropDown(Day,"23");
        utils.selectValueFromDropDown(Month,"January");
        utils.selectValueFromDropDown(Year,"1994");
        utils.doSendKeys(email, "urmi2301@gmail.com");
        utils.doSendKeys(coName,"unify");
        utils.isSelected(Letter);
        utils.doSendKeys(pwd, "urmi123");
        utils.doSendKeys(confirmPwd, "urmi123");
        utils.doClick(regButton);


    }
}
