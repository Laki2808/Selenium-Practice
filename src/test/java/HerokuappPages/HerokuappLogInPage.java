package HerokuappPages;

import HerokuappBase.HerokuappBaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HerokuappLogInPage extends HerokuappBaseTest {

    public HerokuappLogInPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "username")
    public WebElement username;

    @FindBy (id = "password")
    public WebElement password;

    @FindBy (css = ".fa.fa-2x.fa-sign-in")
    public WebElement loginButton;

    @FindBy (id = "flash")
    public WebElement notificationMessage;

    //--------------------------------

    public void insertUsername(String name) {
        username.clear();
        username.sendKeys(name);
    }

    public void insertPassword(String passwordValue) {
        password.clear();
        password.sendKeys(passwordValue);
    }

    public void clickOnLoginButton() {
        loginButton.click();
    }

    public String notificationMessage() {
        return notificationMessage.getText();
    }

}