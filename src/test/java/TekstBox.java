import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;

public class TekstBox {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com");

        List<WebElement> cards = driver.findElements(By.cssSelector(".card.mt-4.top-card"));

        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).getText().equals("Elements")) {
                cards.get(i).click();
                break;
            }
        }

        List<WebElement> textBoxButton = driver.findElements(By.id("item-0"));

        for (int i = 0; i < textBoxButton.size(); i++) {
            if (textBoxButton.get(i).getText().equals("Text Box")) {
                textBoxButton.get(i).click();
                break;
            }
        }

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement nameInput = driver.findElement(By.id("userName"));
        WebElement emailInput = driver.findElement(By.id("userEmail"));

        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));

        WebElement submitButton = driver.findElement(By.id("submit"));

        String name = "Name3";
        String email = "mail@mail.com";
        String address1 = "Adresa1";
        String address2 = "Adresa2";

        nameInput.clear();
        nameInput.sendKeys(name);
        emailInput.clear();
        emailInput.sendKeys(email);
        currentAddress.clear();
        currentAddress.sendKeys(address1);
        permanentAddress.clear();
        permanentAddress.sendKeys(address2);
        js.executeScript("arguments[0].scrollIntoView();", submitButton);
        submitButton.click();

        WebElement nameOutput = driver.findElement(By.id("name"));
        WebElement emailOutput = driver.findElement(By.id("email"));
        WebElement currentAddressOutput = driver.findElement(By.cssSelector(".border.col-md-12.col-sm-12")).findElement(By.id("currentAddress"));
        WebElement permanentAddressOutput = driver.findElement(By.cssSelector(".border.col-md-12.col-sm-12")).findElement(By.id("permanentAddress"));

        Assert.assertTrue(nameOutput.getText().contains(name));
        Assert.assertTrue(emailOutput.getText().contains(email));
        Assert.assertTrue(currentAddressOutput.getText().contains(address1));
        Assert.assertTrue(permanentAddressOutput.getText().contains(address2));


    }
}