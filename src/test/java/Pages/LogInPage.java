package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInPage {
    WebDriver driver;
    WebElement username;
    WebElement password;
    WebElement loginButton;
    WebElement notificationMessage;

    public LogInPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getUsername() {
        return driver.findElement(By.id("username"));
    }

    public WebElement getPassword() {
        return driver.findElement(By.id("password"));
    }

    public WebElement getLoginButton() {
        return driver.findElement(By.cssSelector(".fa.fa-2x.fa-sign-in"));
    }

    public WebElement getNotificationMessage() {
        return driver.findElement(By.id("flash"));
    }

    //-------------------------------

    public void insertUsername(String name) {
        getUsername().clear();
        getUsername().sendKeys(name);
    }

    public void insertPassword(String password) {
        getPassword().clear();
        getPassword().sendKeys(password);
    }

    public void clickOnLoginButton() {
        getLoginButton().click();
    }

    public String notificationMessage() {
        return getNotificationMessage().getText();
    }

}