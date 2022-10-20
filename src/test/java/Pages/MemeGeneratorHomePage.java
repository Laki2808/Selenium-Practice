package Pages;

import Base.MemeGeneratorBaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MemeGeneratorHomePage extends MemeGeneratorBaseTest {


    public MemeGeneratorHomePage() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "mm-show-upload")
    public WebElement uploadNewTemplateButton;
    @FindBy(id = "mm-upload-file")
    public WebElement uploadImageFromYourDevice;
    @FindBy(id = "mm-upload-btn")
    public WebElement uploadButton;
    @FindBy(className = "mm-text")
    public WebElement inputTopText;
    @FindBy(xpath = "//*[@id=\"mm-settings\"]/div[4]/div[2]/div[1]/textarea")
    public WebElement inputBottomText;
    @FindBy(css = ".mm-generate.b.but")
    public WebElement createMeme;


    //--------------

    public void clickOnUploadNewTemplateButton(){
        uploadNewTemplateButton.click();

    }
    public void uploadImageFromYourDevice(){
        uploadImageFromYourDevice.sendKeys("C:\\Users\\Win10\\Desktop\\beauty_of_nature_17.jpg");
    }
    public void clickOnUploadButton(){
        uploadButton.click();
    }
    public void inputTopTextField(String toptext){
        inputTopText.clear();
        inputTopText.sendKeys(toptext);
    }
    public void inputbottomTextField(String bottomtext){
        inputBottomText.clear();
        inputBottomText.sendKeys(bottomtext);
    }
    public void creatMemeButton(){
        createMeme.click();
    }

}
