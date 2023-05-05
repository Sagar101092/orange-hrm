package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utilities.Utility;
import org.openqa.selenium.By;

public class AddUserPage extends Utility {

    By userName = By.xpath("//div[@class='oxd-form-row']//div[@class='oxd-grid-2 orangehrm-full-width-grid']//div[@class='oxd-grid-item oxd-grid-item--gutters']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']");
    By employeeName = By.xpath("//input[@placeholder='Type for hints...']");
    By confirmPassword = By.xpath("//div[@class='oxd-grid-item oxd-grid-item--gutters']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@type='password']");
    By password = By.xpath("//div[@class='oxd-grid-item oxd-grid-item--gutters user-password-cell']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@type='password']");

    By saveButton = By.xpath("//button[normalize-space()='Save']");

    public void selectUserRole(String role) throws InterruptedException {
        Thread.sleep(1000);
        clickOnElement(By.xpath("(//div[@class='oxd-select-text oxd-select-text--active']//i)[1]"));
        Thread.sleep(1000);
        clickOnElement(By.xpath("//div[@role='listbox']//*[contains(text(),'" + role + "')]"));
    }

    public void enterEmployeeName(String name) throws InterruptedException {
        Thread.sleep(1000);
        sendTextToElement(employeeName, name);
        clickOnElement(By.xpath("//div[@role='listbox']//*[contains(text(),'" + name + "')]"));
    }

    public void selectUserStatus(String status) throws InterruptedException {
        Thread.sleep(1000);
        clickOnElement(By.xpath("(//div[@class='oxd-select-text oxd-select-text--active']//i)[2]"));
        Thread.sleep(1000);
        clickOnElement(By.xpath("//div[@role='listbox']//*[contains(text(),'" + status + "')]"));
    }

    public void enterPassword(String name) throws InterruptedException {
        Thread.sleep(1000);
        sendTextToElement(password, name);
    }

    public void enterConfirmPassword(String name) throws InterruptedException {
        Thread.sleep(1000);
        sendTextToElement(confirmPassword, name);
    }

    public void clickOnSaveButton() throws InterruptedException {
        Thread.sleep(1000);
        clickOnElement(saveButton);
    }

    public void enterUserName(String name) throws InterruptedException {
        Thread.sleep(1000);
        sendTextToElement(userName, name);
    }

    public String getSuccessfulText() throws InterruptedException {
        Thread.sleep(2000);
        return getTextFromElement(By.xpath("//*[@id='oxd-toaster_1']/div"));
        //return getTextFromAlert();
    }

    public boolean verifyUserDisplay(String name) throws InterruptedException {
        Thread.sleep(1000);
        sendTextToElement(employeeName, name);
        Thread.sleep(1000);
        return driver.findElement(By.xpath("//div[@role='listbox']//*[contains(text(),'" + name + "')]")).isDisplayed();

    }
}
