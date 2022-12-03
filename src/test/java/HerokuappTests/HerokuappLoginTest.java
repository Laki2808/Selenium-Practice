
package HerokuappTests;

import HerokuappBase.HerokuappBaseTest;
import HerokuappPages.HerokuappLogInPage;
import HerokuappPages.HerokuappLogOutPage;
import org.apache.hc.core5.reactor.Command;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static HerokuappHelpers.HerokuappStrings.*;
import static HerokuappHelpers.HerokuappURLs.LOGINPAGE;
import static HerokuappHelpers.HerokuappURLs.LOGOUTPAGE;


public class HerokuappLoginTest extends HerokuappBaseTest {

    HerokuappLogInPage herokuappLogInPage;
    HerokuappLogOutPage herokuappLogOutPage;

    @BeforeMethod
    public void pageSetUp() {
        herokuappLogInPage = new HerokuappLogInPage();
        herokuappLogOutPage = new HerokuappLogOutPage();
        driver.manage().window().maximize();
        driver.navigate().to(LOGINPAGE);
    }

    @AfterMethod
    public void pageCleanup() {
        driver.manage().deleteAllCookies();
    }

    @Test(priority = 10)
    public void userCanSuccessfullyLogIn() {
        herokuappLogInPage.insertUsername(validUsername);
        herokuappLogInPage.insertPassword(validPassword);
        herokuappLogInPage.clickOnLoginButton();
        Assert.assertTrue(herokuappLogOutPage.logoutButton.isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), LOGOUTPAGE);
        Assert.assertEquals(herokuappLogOutPage.notificationMessage(), expectedMessageLogin);

    }

    @Test(priority = 20)
    public void userCanNotLogInWithInvalidUserName() {
        for (int i=1; i <= excelReader.getLastRow("Login");i++){
            String invalidUserName = excelReader.getStringData("Login", i, 0);
            herokuappLogInPage.insertUsername(invalidUserName);
            herokuappLogInPage.insertPassword(validPassword);
            herokuappLogInPage.clickOnLoginButton();
            Assert.assertTrue(herokuappLogInPage.loginButton.isDisplayed());
            Assert.assertEquals(herokuappLogInPage.notificationMessage(), expectedMessageUsername);
        }

    }

    @Test(priority = 30)
    public void userCanNotLogInWithInvalidPassword() {
        for (int i=1;i<=excelReader.getLastRow("Login");i++){
            String invalidPassword = excelReader.getStringData("Login", i, 1);
            herokuappLogInPage.insertUsername(validUsername);
            herokuappLogInPage.insertPassword(invalidPassword);
            herokuappLogInPage.clickOnLoginButton();
            Assert.assertTrue(herokuappLogInPage.loginButton.isDisplayed());
            Assert.assertEquals(herokuappLogInPage.notificationMessage(), expectedMessagePassword);
        }


    }

}