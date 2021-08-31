package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.internal.Utils;

import java.util.List;

public class PaymentConfirmation extends BasePage {

    public WebDriver driver;

    public PaymentConfirmation(WebDriver driver1){
        super(driver1);
        this.driver=driver1;
        PageFactory.initElements(driver1,this);
    }
    @FindBy(xpath = "//div[@class='form-group']")
    List <WebElement> PaymentDetails;
    @FindBy(xpath = "//span[normalize-space()='112233']")
    WebElement Text;
    @FindBy(xpath = "//div/input[@id='PaRes']")
    WebElement OTP;
    @FindBy(xpath = "//button[normalize-space()='OK']")
    WebElement OK;
    @FindBy(xpath = "//button[normalize-space()='Cancel']")
    WebElement Cancel;

    public void getPaymentDetails(){
        List <WebElement> details = PaymentDetails;
        for( WebElement detail : details){
            System.out.println(detail.getText());
        }
    }
    public void verifyText(){
        Assert.assertEquals(Text,"112233");
    }
    public void enterOTP(){
        WebDriverWait wait1= new WebDriverWait(driver,10);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/input[@id='PaRes']")));
        OTP.clear();
        enterText(OTP,"112233");
    }
    public void clickOK(){
        OK.click();
    }
    public void cancelButton(){
        wait(Cancel);
        Cancel.click();
        frameSwitchTo(0);
    }
}
