package Pages;

import Utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
        BuyNow.click();
        Utils.holdExecutionForSeconds(2);
    }

    public boolean verifyTotal() {
        boolean flag = false;
        if (Total.isDisplayed()) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    public void displayTotal() {
        clickBuyNow();
        Utils.holdExecutionForSeconds(3);

    }
    public void clickCheckout(){
        Checkout.click();

    }
    public boolean verifyCheckout() {
        boolean flag;
        if (Checkout.isDisplayed()) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    public void getCustomerDetails() {
        List<WebElement> details = CustomerDetails;
        Utils.holdExecutionForSeconds(3);
        for (WebElement detail : details) {
            System.out.println(detail.getText());

        }
    /*public void frame(){
            Int size = driver.findElements(By.tagName("iframe")).size();

        } */
    }
}


