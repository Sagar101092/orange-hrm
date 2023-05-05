package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utilities.Utility;
import org.openqa.selenium.By;

public class AdminPage extends Utility {

    By addButton = By.xpath("//button[normalize-space()='Add']");

    By addUserText = By.xpath("//h6[normalize-space()='Add User']");



    public void clickOnAddButton() throws InterruptedException {
        Thread.sleep(1000);
        clickOnElement(addButton);
    }

    public String getAddUserText() throws InterruptedException {
        Thread.sleep(1000);
        return getTextFromElement(addUserText);
    }




}
