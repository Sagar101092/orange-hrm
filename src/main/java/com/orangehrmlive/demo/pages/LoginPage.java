package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utilities.Utility;
import org.openqa.selenium.By;

public class LoginPage extends Utility {
    By userName = By.xpath("//input[@placeholder='Username']");
    By password = By.xpath("//input[@placeholder='Password']");
    By logIn = By.xpath("//button[normalize-space()='Login']");

    /**
     * Enter Username
     *
     * @param value
     * @throws InterruptedException
     */
    public void enterUserName(String value) throws InterruptedException {
        Thread.sleep(1000);
        sendTextToElement(userName, value);
    }

    public void enterPassword(String value) throws InterruptedException {
        Thread.sleep(1000);
        sendTextToElement(password, value);
    }

    public void clickOnLogin() throws InterruptedException {
        Thread.sleep(1000);
        clickOnElement(logIn);
    }

    public boolean verifyCompanyLogoIsDisplayed() throws InterruptedException {
        Thread.sleep(1000);
        return driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
    }

    public boolean verifyLoginPanel(){
        return driver.findElement(By.xpath("//h5[normalize-space()='Login']")).isDisplayed();
    }

}
