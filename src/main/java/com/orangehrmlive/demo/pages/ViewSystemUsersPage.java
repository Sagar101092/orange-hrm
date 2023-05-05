package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utilities.Utility;
import org.openqa.selenium.By;

public class ViewSystemUsersPage extends Utility {
    By userName=By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']");
    By employeeName=By.xpath("//input[@placeholder='Type for hints...']");
    By deletButton=By.xpath("//div[@class='orangehrm-container']//button[1]");
    By okButton=By.xpath("//button[normalize-space()='Yes, Delete']");
    By successText=By.xpath("//*[@id='oxd-toaster_1']//*");
    By noRecord=By.xpath("//*[@id='oxd-toaster_1']/div");
    By userCheckBox = By.xpath("//div[@class='oxd-table-card-cell-checkbox']//i[@class='oxd-icon bi-check oxd-checkbox-input-icon']");
    public void enterUserName(String value) throws InterruptedException {
        Thread.sleep(1000);
        sendTextToElement(userName,value);
    }

    public void selectUserRole(String role) throws InterruptedException {
        Thread.sleep(1000);
        clickOnElement(By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[1]"));
        Thread.sleep(1000);
        clickOnElement(By.xpath("//div[@role='listbox']//*[contains(text(),'" + role + "')]"));
    }

    public void enterEmployeeName(String name) throws InterruptedException {
        Thread.sleep(1000);
        sendTextToElement(employeeName, name);
        Thread.sleep(2000);
        clickOnElement(By.xpath("//div[@role='listbox']//*[contains(text(),'" + name + "')]"));
    }

    public void selectUserStatus(String status) throws InterruptedException {
        Thread.sleep(1000);
        clickOnElement(By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[2]"));
        Thread.sleep(1000);
        clickOnElement(By.xpath("//div[@role='listbox']//*[contains(text(),'" + status + "')]"));
    }

    public void clickOnSearchButton() throws InterruptedException {
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[normalize-space()='Search']"));
    }

    public boolean verifyUserIsDisplayInList(){
        return driver.findElement(By.xpath("//div[contains(text(),'Charlie Carter')]")).isDisplayed();
    }

    public void clickOnUserCheckBox() throws InterruptedException {
        Thread.sleep(1000);
        clickOnElement(userCheckBox);
    }

    public void clickOnDeleteButton() throws InterruptedException {
        Thread.sleep(1000);
        clickOnElement(deletButton);
    }

    public void clickOnOkButton() throws InterruptedException {
        Thread.sleep(1000);
        clickOnElement(okButton);
    }

    public String getSuccessfulText() throws InterruptedException {
        Thread.sleep(2000);
        return getTextFromElement(successText);
        //return getTextFromAlert();
    }

    public String getNoRecordFoundText() throws InterruptedException {
        Thread.sleep(1000);
        return getTextFromElement(noRecord);
    }
}

