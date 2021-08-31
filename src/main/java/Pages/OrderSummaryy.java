package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class OrderSummaryy extends BasePage{
    public WebDriver driver;

    public OrderSummaryy(WebDriver driver1){
        super(driver1);
        this.driver=driver1;
        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath = "//span[contains(text(),'Midtrans Pillow')]")
    WebElement ProductName;
    @FindBy(xpath = "//td[contains(.,'20,000')]")
    WebElement ProductPrice;
    @FindBy(xpath = "//a[@class='button-main-content']")
    WebElement Continue;
    @FindBy(xpath = "//h1[normalize-space()='COCO STORE']")
    WebElement CocoStoreLabel;
    @FindBy(xpath = "//p[contains(text(),'Select Payment')]")
    WebElement SelectPayment;
    @FindBy(xpath = "//*[@id='container']/div/div/div[1]/div[3]")
    WebElement Overlay;

    public boolean verifyProductName(){
        boolean flag= wait(ProductName).isDisplayed();
        return flag;

    }
    public void clickOnContinue(){
        WebDriverWait wait1= new WebDriverWait(driver,20);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='button-main-content']")));
        Continue.click();
        frameSwitchTo(0);
    }
    public boolean verifySelectPayment(){
       boolean flag= wait(SelectPayment).isDisplayed();
       return  flag;
    }
    public boolean verifyPageLabel(){
        boolean flag= wait(CocoStoreLabel).isDisplayed();
        return flag;
    }
    public boolean verifyProductPrice(){
        boolean flag= wait(ProductPrice).isDisplayed();
        return flag;
    }
}
