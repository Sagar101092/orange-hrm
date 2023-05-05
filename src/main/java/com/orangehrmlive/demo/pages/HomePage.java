package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utilities.Utility;
import org.openqa.selenium.By;

public class HomePage extends Utility {

    By adminTab = By.xpath("//a[normalize-space()='Admin']");
    By systemUsers = By.xpath("//h5[normalize-space()='System Users']");

    public void clickOnAdminTab() throws InterruptedException {
        Thread.sleep(1000);
        clickOnElement(adminTab);
    }

    public String getSystemUserText() throws InterruptedException {
        Thread.sleep(1000);
       return getTextFromElement(systemUsers);
    }


}
