package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utilities.Utility;
import org.openqa.selenium.By;

public class DashboardPage extends Utility {
    By dashbordText= By.xpath("//h6[normalize-space()='Dashboard']");
    By logOut= By.xpath("//a[normalize-space()='Logout']");
    By profileTab= By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']");

    public String getDashbordText() throws InterruptedException {
        Thread.sleep(1000);
        return getTextFromElement(dashbordText);
    }

    public void clickOnProfile() throws InterruptedException {
        Thread.sleep(1000);
        clickOnElement(profileTab);
    }

    public void mouseHoverAndClickOnLogOut() throws InterruptedException {
        Thread.sleep(1000);
        mouseHoverToElementAndClick(logOut);
    }


}
