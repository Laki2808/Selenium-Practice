import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Vezba {

    WebDriver driver;



    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }

    @BeforeMethod
    public void setUpPage() {
        driver.manage().window().maximize();
        driver.navigate().to("http://the-internet.herokuapp.com/login");

    }

    @Test(priority = 10)
    public void successfulLogIn() {


        WebElement userName = driver.findElement(By.id("username"));
        userName.clear();
        userName.sendKeys("tomsmith");


        WebElement password = driver.findElement(By.id("password"));
        password.clear();
        password.sendKeys("SuperSecretPassword!");


        WebElement clickButton = driver.findElement(By.cssSelector(".fa.fa-2x.fa-sign-in"));
        clickButton.click();
        Assert.assertEquals(driver.getCurrentUrl(), "http://the-internet.herokuapp.com/secure");

        WebElement logOutButton = driver.findElement(By.cssSelector(".icon-2x.icon-signout"));
        Assert.assertTrue(logOutButton.isDisplayed());

        WebElement notificationMessage = driver.findElement(By.id("flash"));
        Assert.assertTrue(notificationMessage.isDisplayed());

    }

    @Test(priority = 30)
    public void unsuccessfulLogInBadPasswordFormat(){
        WebElement userName = driver.findElement(By.id("username"));
        userName.clear();
        userName.sendKeys("tomsmith");


        WebElement password = driver.findElement(By.id("password"));
        password.clear();
        password.sendKeys("supersecretsassword!");


        WebElement clickButton = driver.findElement(By.cssSelector(".fa.fa-2x.fa-sign-in"));
        clickButton.click();

       WebElement visibleMassage=driver.findElement(By.id("flash-messages"));
       Assert.assertTrue(visibleMassage.isDisplayed());
       Assert.assertTrue(visibleMassage.getText().contains("Your username is invalid!"));





    }
    @Test(priority = 20)
    public void unsuccessfulLogInBadNameFormat() {
        WebElement userName = driver.findElement(By.id("username"));
        userName.clear();
        userName.sendKeys("tom");


        WebElement password = driver.findElement(By.id("password"));
        password.clear();
        password.sendKeys("SuperSecretPassword!");


        WebElement clickButton = driver.findElement(By.cssSelector(".fa.fa-2x.fa-sign-in"));
        clickButton.click();

        WebElement visibleMassage = driver.findElement(By.id("flash-messages"));
        Assert.assertTrue(visibleMassage.isDisplayed());
        Assert.assertTrue(visibleMassage.getText().contains("Your username is invalid!"));


    }

        @Test
    public void testLogOut() {

        WebElement userName = driver.findElement(By.id("username"));
        userName.clear();
        userName.sendKeys("tomsmith");


        WebElement password = driver.findElement(By.id("password"));
        password.clear();
        password.sendKeys("SuperSecretPassword!");


        WebElement clickButton = driver.findElement(By.cssSelector(".fa.fa-2x.fa-sign-in"));
        clickButton.click();


        WebElement logOut = driver.findElement(By.cssSelector(".icon-2x.icon-signout"));
        logOut.click();


        Assert.assertEquals(driver.getCurrentUrl(), "http://the-internet.herokuapp.com/login");
        WebElement loginButton = driver.findElement(By.cssSelector(".fa.fa-2x.fa-sign-in"));

        Assert.assertTrue(loginButton.isDisplayed());
    }


}
