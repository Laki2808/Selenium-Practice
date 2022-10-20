package HerokuappPages;

import HerokuappBase.HerokuappBaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HerokuappLogOutPage extends HerokuappBaseTest {

    public HerokuappLogOutPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "flash")
    public WebElement notificationMessage;

    @FindBy (css = ".icon-2x.icon-signout")
    public WebElement logoutButton;

    //-----------------------------

    public String notificationMessage() {
        return notificationMessage.getText();
    }

    public void clickOnLogOutButton() {
        logoutButton.click();
    }

}