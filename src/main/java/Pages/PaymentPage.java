package Pages;

import Utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PaymentPage extends BasePage {

    public WebDriver driver;
    public PaymentPage(WebDriver driver1){
        super(driver1);
        this.driver=driver1;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//div[@class='list-content']")
    List<WebElement> CardDetails;
    @FindBy(xpath = "//a[@class='list with-promo']//div[@class='list-content']//div[1]")
    WebElement CreditCard;
    @FindBy(xpath = "//span[@class='text-amount-amount']")
    WebElement Amount;
    @FindBy(xpath = "//label[text()='Promo Demo MasterCard']")
    WebElement checkbox;
    @FindBy(xpath = "//span[@class='text-amount-amount']")
    WebElement newPrice;
    @FindBy(xpath = "//input[@name='cardnumber']")
    WebElement CardNumber;
    @FindBy(xpath = "//input[@placeholder='MM / YY']")
    WebElement ExpiryDate;
    @FindBy(xpath = "//input[@placeholder='123']")
    WebElement CVV;
    @FindBy(xpath = "//a[@class='button-main-content']")
    WebElement PayNow;



    public void getCard(){
        List<WebElement> carddetails= CardDetails;
        Utils.holdExecutionForSeconds(3);
        for( WebElement carddetail : carddetails){
            System.out.println(carddetail.getText());
        }
    }
    public void clickCreditCard(){
        wait(CreditCard);
        CreditCard.click();
    }
    public void verifyAmount(){
        System.out.println(Amount.getText());
    }
    public void selectCheckbox(){
        scrollTillTheElementIsVisible(checkbox);
        checkbox.click();
    }
    public void getNewPrice(){
        System.out.println(newPrice.getText());
    }
    public void EnterCardDetails(){
        enterText(CardNumber,"4811111111111114");
        enterText(ExpiryDate,"02/22");
        enterText(CVV,"123");
    }
    public void PayNow(){
        PayNow.click();
        frameSwitchTo(0);
    }
}
