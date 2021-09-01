package Pages;

import Utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage {
    public WebDriver driver;

    public HomePage(WebDriver driver1) {
        super(driver1);
        this.driver = driver1;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//a[normalize-space()='BUY NOW']")
    WebElement BuyNow;
    @FindBy(xpath = "//div/span[contains(.,'20,000')]")
    WebElement Price20000;
    @FindBy(xpath = "//tr[@class='total']")
    WebElement Total;
    @FindBy(xpath = "//div[@class='cart-checkout']")
    WebElement Checkout;
    @FindBy(xpath = "//td[@class='input-label']")
    List<WebElement> CustomerDetails;
    @FindBy(xpath = "//nav[@id='header']")
    WebElement OrderSummary;
    @FindBy(xpath = "//input[@value='Budi']")
    WebElement Name;
    @FindBy(xpath = "//input[@value='budi@utomo.com']")
    WebElement Email;
    @FindBy(xpath = "//input[@value='081808466410']")
    WebElement phone;
    @FindBy(xpath = "//input[@value='Jakarta']")
    WebElement city;
    @FindBy(xpath = "//textarea[normalize-space()='MidPlaza 2, 4th Floor Jl.Jend.Sudirman Kav.10-11']")
    WebElement address;
    @FindBy(xpath = "//input[@value='10220']")
    WebElement Postalcode;
    @FindBy(xpath = "//span[normalize-space()='Thank you for your purchase.']")
    WebElement SuccessfulMessage;

    public boolean verifyPrice() {
        boolean flag = false;
        if (Price20000.isDisplayed()) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    public void clickBuyNow() {
        wait(BuyNow);
        BuyNow.click();
        wait(Checkout);
    }

    public boolean verifyTotal() {
        boolean flag = wait(Total).isDisplayed();
        return flag;
    }

    public void getTotal(){
        System.out.println(Price20000.getText());
    }

    public void displayTotal() {
        clickBuyNow();
        Utils.holdExecutionForSeconds(3);

    }
    public void clickCheckout() {
        Checkout.click();
        Utils.holdExecutionForSeconds(3);
        frameSwitchTo(0);
        //driver.switchTo().frame("snap-midtrans");
    }

    public boolean verifyCheckout() {
        boolean flag = wait(Checkout).isDisplayed();
        return flag;
    }

    public void getCustomerDetails() {
        List<WebElement> details = CustomerDetails;
        Utils.holdExecutionForSeconds(3);
        for (WebElement detail : details) {
            System.out.println(detail.getText());

        }
    }
    public void enterDetails(){
        wait(Checkout);
        enterText(Name,"Vinisha");
        Utils.holdExecutionForSeconds(2);
        enterText(Email,"vinisha@abc.com");
        enterText(phone,"9993737773");
        enterText(city,"Delhi");
        enterText(address,"Street 4443");
        enterText(Postalcode,"201303");
    }
    public boolean verifyMessage(){
        boolean flag= wait(SuccessfulMessage).isDisplayed();
        return flag;
    }
}


