package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Helpers.Strings.*;
import static Helpers.URLs.LOGINPAGE;
import static Helpers.URLs.LOGOUTPAGE;

public class LoginTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.navigate().to(LOGINPAGE);
    }

    @AfterMethod
    public void pageCleanup() {
        driver.manage().deleteAllCookies();
    }

    @Test(priority = 10)
    public void userCanSuccessfullyLogIn() {
        logInPage.insertUsername(validUsername);
        logInPage.insertPassword(validPassword);
        logInPage.clickOnLoginButton();
        Assert.assertTrue(logOutPage.getLogOutButton().isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), LOGOUTPAGE);
        Assert.assertEquals(logOutPage.notificationMessage(), expectedMessageLogin);
    }

    @Test(priority = 20)
    public void userCannotLogInWithInvalidUsername() {
        logInPage.insertUsername(invalidUsername);
        logInPage.insertPassword(validPassword);
        logInPage.clickOnLoginButton();
        Assert.assertTrue(logInPage.getLoginButton().isDisplayed());
        Assert.assertEquals(logInPage.notificationMessage(), expectedMessageUsername);
    }

    @Test(priority = 30)
    public void userCannotLogInWithInvalidPassword() {
        logInPage.insertUsername(validUsername);
        logInPage.insertPassword(invalidPassword);
        logInPage.clickOnLoginButton();
        Assert.assertTrue(logInPage.getLoginButton().isDisplayed());
        Assert.assertEquals(logInPage.notificationMessage(), expectedMessagePassword);
    }

    @Test(priority = 40)
    public void userCannotLogInWithInvalidUsernameAndPassword() {
        logInPage.insertUsername(invalidUsername);
        logInPage.insertPassword(invalidPassword);
        logInPage.clickOnLoginButton();
        Assert.assertTrue(logInPage.getLoginButton().isDisplayed());
        Assert.assertEquals(logInPage.notificationMessage(), expectedMessageUsername);
    }

    @Test(priority = 50)
    public void userCanLogOut() {
        logInPage.insertUsername(validUsername);
        logInPage.insertPassword(validPassword);
        logInPage.clickOnLoginButton();
        logOutPage.clickOnLogOutButton();
        Assert.assertTrue(logInPage.getLoginButton().isDisplayed());
        Assert.assertEquals(logInPage.notificationMessage(), expectedMessageLogout);
    }

}