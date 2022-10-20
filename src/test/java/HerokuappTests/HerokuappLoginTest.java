
package HerokuappTests;

import HerokuappBase.HerokuappBaseTest;
import HerokuappPages.HerokuappLogInPage;
import HerokuappPages.HerokuappLogOutPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
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

    @Test
    public void userCanSuccessfullyLogIn() {
        herokuappLogInPage.insertUsername(validUsername);
        herokuappLogInPage.insertPassword(validPassword);
        herokuappLogInPage.clickOnLoginButton();
        Assert.assertTrue(herokuappLogOutPage.logoutButton.isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), LOGOUTPAGE);
        Assert.assertEquals(herokuappLogOutPage.notificationMessage(), expectedMessageLogin);

    }

}