import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LogOut {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        driver.navigate().to("http://the-internet.herokuapp.com/login");
        WebElement userName = driver.findElement(By.id("username"));
        userName.clear();
        userName.sendKeys("tomsmith");


        WebElement password = driver.findElement(By.id("password"));
        password.clear();
        password.sendKeys("SuperSecretPassword!");


        WebElement clickButton = driver.findElement(By.cssSelector(".fa.fa-2x.fa-sign-in"));
        clickButton.click();


       WebElement logOut=driver.findElement(By.cssSelector(".icon-2x.icon-signout"));
       logOut.click();


        Assert.assertEquals(driver.getCurrentUrl(),"http://the-internet.herokuapp.com/login");
        WebElement loginButton=driver.findElement(By.cssSelector(".fa.fa-2x.fa-sign-in"));

        Assert.assertTrue(loginButton.isDisplayed());
    }
}