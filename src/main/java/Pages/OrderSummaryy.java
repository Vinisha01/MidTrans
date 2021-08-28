package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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

    public void verifyProductName(){
        Assert.assertEquals(ProductName.getText(),"MidTrans Pillow");
    }





}
