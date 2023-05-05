package com.orangehrmlive.demo.testsuite;


import com.orangehrmlive.demo.pages.*;
import com.orangehrmlive.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

/**
 * Created by Sagar Goswami
 */
public class UsersTest extends BaseTest {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    AdminPage adminPage = new AdminPage();
    AddUserPage addUserPage = new AddUserPage();
    ViewSystemUsersPage viewSystemUsersPage = new ViewSystemUsersPage();

    @Test
    public void adminShouldAddUserSuccessFully() throws InterruptedException {

        String name = UUID.randomUUID().toString();
        // email = name + "@gmail.com";
        loginPage.enterUserName("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickOnLogin();
        homePage.clickOnAdminTab();

        String exceptedMessage = "System Users";
        String aceptedMessage = homePage.getSystemUserText();
        Assert.assertEquals(exceptedMessage, aceptedMessage);
        adminPage.clickOnAddButton();
        exceptedMessage = "Add User";
        aceptedMessage = adminPage.getAddUserText();
        Assert.assertEquals(exceptedMessage, aceptedMessage);
        addUserPage.selectUserRole("Admin");
        addUserPage.enterEmployeeName("Peter");
        addUserPage.enterUserName(name);
        addUserPage.selectUserStatus("Disabled");
        addUserPage.enterPassword("Admin@123");
        addUserPage.enterConfirmPassword("Admin@123");
        addUserPage.clickOnSaveButton();
        exceptedMessage = "Successfully Saved";
        aceptedMessage = addUserPage.getSuccessfulText();
        String[] actualmsg = aceptedMessage.split("\n");
        Assert.assertEquals(exceptedMessage, actualmsg[1]);

    }

    @Test
    public void searchTheUserCreatedAndVerifyIt() throws InterruptedException {
        String name = UUID.randomUUID().toString();
        loginPage.enterUserName("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickOnLogin();
        homePage.clickOnAdminTab();
        String exceptedMessage = "System Users";
        String aceptedMessage = homePage.getSystemUserText();
        Assert.assertEquals(exceptedMessage, aceptedMessage);
        adminPage.clickOnAddButton();
        addUserPage.selectUserRole("Admin");
        addUserPage.enterUserName(name);
        addUserPage.selectUserStatus("Disabled");
        // addUserPage.enterEmployeeName("Peter");
        Assert.assertTrue(addUserPage.verifyUserDisplay("Peter"));
    }

    @Test
    public void verifyThatAdminShouldDeleteTheUserSuccessFully() throws InterruptedException {
        loginPage.enterUserName("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickOnLogin();
        homePage.clickOnAdminTab();
        String exceptedMessage = "System Users";
        String aceptedMessage = homePage.getSystemUserText();
        Assert.assertEquals(exceptedMessage, aceptedMessage);
       // viewSystemUsersPage.enterUserName("john");
        viewSystemUsersPage.selectUserRole("Admin");
        viewSystemUsersPage.enterEmployeeName("Charlie");
      //  viewSystemUsersPage.selectUserStatus("Enabled");
        viewSystemUsersPage.clickOnSearchButton();
        Assert.assertTrue(viewSystemUsersPage.verifyUserIsDisplayInList());
        viewSystemUsersPage.clickOnUserCheckBox();
        viewSystemUsersPage.clickOnDeleteButton();
        viewSystemUsersPage.clickOnOkButton();
        exceptedMessage = "Successfully Saved";
        aceptedMessage = viewSystemUsersPage.getSuccessfulText();
        String[] actualmsg = aceptedMessage.split("\n");
        Assert.assertEquals(exceptedMessage, actualmsg[1]);

    }

    @Test
    public void searchTheDeletedUserAndVerifyTheMessageNoRecordFound() throws InterruptedException {
        loginPage.enterUserName("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickOnLogin();
        homePage.clickOnAdminTab();
        String exceptedMessage = "System Users";
        String aceptedMessage = homePage.getSystemUserText();
        Assert.assertEquals(exceptedMessage, aceptedMessage);
        viewSystemUsersPage.enterUserName("john");
        viewSystemUsersPage.selectUserRole("Admin");
        viewSystemUsersPage.enterEmployeeName("Smith");
        viewSystemUsersPage.selectUserStatus("Enabled");
        viewSystemUsersPage.clickOnSearchButton();
        exceptedMessage = "No Records Found";
        aceptedMessage = viewSystemUsersPage.getNoRecordFoundText();
        String[] actualmsg = aceptedMessage.split("\n");
        Assert.assertEquals(exceptedMessage, actualmsg[1]);
    }

}
