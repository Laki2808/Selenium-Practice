package Tests;

import Base.MemeGeneratorBaseTest;
import Pages.MemeGeneratorHomePage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MemeGeneratorTest extends MemeGeneratorBaseTest {


    MemeGeneratorHomePage memeGeneratorHomePage;


    @BeforeMethod
    public void pageSetUp() {
        memeGeneratorHomePage = new MemeGeneratorHomePage();
        driver.manage().window().maximize();
        driver.navigate().to("https://imgflip.com/memegenerator");

    }

    @AfterMethod
    public void pageCleanUp() {
        driver.manage().deleteAllCookies();
    }

    @Test
    public void homePageTest() throws InterruptedException {
        memeGeneratorHomePage.clickOnUploadNewTemplateButton();
        memeGeneratorHomePage.uploadImageFromYourDevice();
        memeGeneratorHomePage.clickOnUploadButton();
        memeGeneratorHomePage.inputTopTextField("Rad");
        memeGeneratorHomePage.inputbottomTextField("Luko");
        memeGeneratorHomePage.creatMemeButton();
    }

}
