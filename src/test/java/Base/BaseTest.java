package Base;

import Helpers.URLs;
import Pages.LogInPage;
import Pages.LogOutPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {

    public WebDriver driver;
    public WebDriverWait wdwait;
    public LogInPage logInPage;
    public LogOutPage logOutPage;
    public URLs urls;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        logInPage = new LogInPage(driver);
        logOutPage = new LogOutPage(driver);
    }

    public void scrollIntoView(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void waitForElementVisibility(WebElement element) {
        wdwait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementClickability(WebElement element) {
        wdwait.until(ExpectedConditions.elementToBeClickable(element));
    }

    @AfterClass
    public void tearDown() {
        driver.close();
        driver.quit();
    }

}