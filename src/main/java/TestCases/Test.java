package TestCases;

import Pages.*;
import Utils.SetUp;
import Utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.util.Properties;

public class Test<properties> {

    public WebDriver driver;

    HomePage homePage;
    BasePage basePage;
    OrderSummaryy orderSummaryy;
    PaymentPage paymentPage;
    PaymentConfirmation paymentConfirmation;

    @BeforeClass
    public void tearUp() {
        driver = SetUp.LaunchBrowser("chrome");
        homePage= new HomePage(driver);
        basePage= new BasePage(driver);
        orderSummaryy = new OrderSummaryy(driver);
        paymentPage= new PaymentPage(driver);
        paymentConfirmation = new PaymentConfirmation(driver);
    }
    @BeforeMethod
    public void launchWebsite() {
        driver.get(basePage.properties.getProperty("url"));
    }

    @org.testng.annotations.Test(priority = 1, groups = {"Regression"})
    public void addToCart(){
        homePage.clickBuyNow();
        Assert.assertTrue(homePage.verifyTotal());
        homePage.getTotal();
    }
    @org.testng.annotations.Test(priority = 2, groups = {"Regression","Smoke"})
     public void clickBuyNoww(){
        homePage.verifyPrice();
        homePage.clickBuyNow();
        Assert.assertTrue(homePage.verifyCheckout());
    }
    @org.testng.annotations.Test(priority = 3, groups = {"Regression"})
    public void getDetails(){
        homePage.clickBuyNow();
        Utils.holdExecutionForSeconds(2);
        homePage.getCustomerDetails();

    }
    @org.testng.annotations.Test(priority = 4, groups = {"Regression"})
    public void fillDetails(){
        homePage.clickBuyNow();
        Utils.holdExecutionForSeconds(2);
        homePage.enterDetails();
    }
    @org.testng.annotations.Test(priority = 5, groups = {"Regression", "Smoke"})
     public void redirectToOrderSummary(){

    }

    @org.testng.annotations.Test (priority = 6)
    public void continuePayment(){
        fillDetails();
        homePage.clickCheckout();
        orderSummaryy.clickOnContinue();

    }
    @org.testng.annotations.Test (priority = 7)
    public void selectPayment(){
        homePage.clickBuyNow();
        Utils.holdExecutionForSeconds(3);
        homePage.enterDetails();
        homePage.clickCheckout();
        driver.switchTo().frame(0);
        Utils.holdExecutionForSeconds(3);
        orderSummaryy.clickOnContinue();
        orderSummaryy.verifySelectPayment();
    }
    @org.testng.annotations.Test(priority = 8)
    public void getCardDetails(){
        selectPayment();
        paymentPage.getCard();
    }
    @org.testng.annotations.Test(priority = 9)
    public void clickCredit(){
        selectPayment();
        paymentPage.clickCreditCard();

    }
    @org.testng.annotations.Test(priority = 10)
    public void verifyOrdAmount(){
        clickCredit();
        paymentPage.verifyAmount();
        Utils.holdExecutionForSeconds(2);
        paymentPage.selectCheckbox();
        paymentPage.getNewPrice();
    }
    @org.testng.annotations.Test(priority = 11)
    public void clickOnPayNow(){
        clickCredit();
        paymentPage.selectCheckbox();
        paymentPage.EnterCardDetails();
        paymentPage.PayNow();
    }
    @org.testng.annotations.Test(priority = 12)
    public void verifyPaymentDetail(){
        clickOnPayNow();
        Utils.holdExecutionForSeconds(2);
        paymentConfirmation.getPaymentDetails();

    }
    @org.testng.annotations.Test(priority = 13)
    public void enterOTP(){
        clickOnPayNow();
        paymentConfirmation.enterOTP();
        paymentConfirmation.clickOK();
    }
    @org.testng.annotations.Test(priority = 15)
    public void clickCancelButton(){
        clickOnPayNow();
        paymentConfirmation.cancelButton();
    }
    }
 /*   @AfterClass
    public void tear(){

        driver.quit();
    }*/


