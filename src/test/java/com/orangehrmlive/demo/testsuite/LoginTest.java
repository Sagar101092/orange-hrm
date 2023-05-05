package com.orangehrmlive.demo.testsuite;


import com.orangehrmlive.demo.pages.DashboardPage;
import com.orangehrmlive.demo.pages.LoginPage;
import com.orangehrmlive.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();

    @Test
    public void verifyUserShouldLoginSuccessFully() throws InterruptedException {
        loginPage.enterUserName("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickOnLogin();
        String exceptedMessage = "Dashboard";
        String aceptedMessage = dashboardPage.getDashbordText();
        Assert.assertEquals(exceptedMessage, aceptedMessage);
    }

    @Test
    public void VerifyThatTheLogoDisplayOnLoginPage() throws InterruptedException {
        Assert.assertTrue(loginPage.verifyCompanyLogoIsDisplayed());
    }

    @Test
    public void VerifyUserShouldLogOutSuccessFully() throws InterruptedException {
        loginPage.enterUserName("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickOnLogin();
        dashboardPage.clickOnProfile();
        dashboardPage.mouseHoverAndClickOnLogOut();
        Assert.assertTrue(loginPage.verifyLoginPanel());

    }
}
