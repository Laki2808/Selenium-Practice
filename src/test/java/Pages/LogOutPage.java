package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogOutPage {
    WebDriver driver;
    WebElement notificationMessage;
    WebElement logOutButton;

    public LogOutPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getNotificationMessage() {
        return driver.findElement(By.id("flash"));
    }

    public WebElement getLogOutButton() {
        return driver.findElement(By.cssSelector(".icon-2x.icon-signout"));
    }

    //--------------------------

    public String notificationMessage() {
        return getNotificationMessage().getText();
    }

    public void clickOnLogOutButton() {
        getLogOutButton().click();
    }

}