package Utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.function.Function;

public class Utils<properties> extends SetUp{


        public boolean isDisplayedElement(WebElement xpath) {
            boolean flag = false;
            try {
                WebElement element = driver.findElement(By.xpath(String.valueOf(xpath)));
                if (element.isDisplayed()) {
                    flag = true;
                }
            } catch (NoSuchElementException e) {
                flag = false;
            }
            return flag;
        }

        public static void holdExecutionForSeconds(int seconds) {
            try {
                Thread.sleep(seconds * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public WebElement wait(WebElement element) {
            return wait.until(ExpectedConditions.visibilityOf(element));
        }



        public static boolean areDisplayed(List<WebElement> elements) {
            boolean flag = false;
            for (WebElement e : elements) {
                if (e.isDisplayed())
                    flag = true;
                else {
                    flag = false;
                    break;
                }
            }
            return flag;
        }


        public void enterTextForListOfWebElements(List<WebElement> elements, List<String> details) {
            for (int i = 0; i < details.size(); i++) {
                enterText(elements.get(i), details.get(i));
            }
        }

        public void enterText(WebElement element, String text) {
            try {
                wait(element).clear();
                element.sendKeys(text);
            } catch (StaleElementReferenceException e) {
                Utils.holdExecutionForSeconds(5);
                element.sendKeys(text);
            } catch (NoSuchElementException e) {
                Utils.holdExecutionForSeconds(5);
                element.sendKeys(text);
            } catch (InvalidElementStateException e) {
                Utils.holdExecutionForSeconds(5);
                element.sendKeys(text);
            }
        }

        public void scrollTillTheElementIsVisible(WebElement element) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(false)", element);
        }

        public void scrollDown() {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,1600)");
        }
    public void frameSwitchTo(int index)
    {
        holdExecutionForSeconds(5);
        try {
            driver.switchTo().frame(index);
        }catch (NoSuchWindowException e)
        {
            driver.switchTo().window(driver.getWindowHandle());
            driver.switchTo().frame(index);
        }
    }



        public void enterTextUsingKeys(WebElement element, Keys key) {
            try {
                wait(element).clear();
                element.sendKeys(key);
            } catch (StaleElementReferenceException e) {
                Utils.holdExecutionForSeconds(5);
                element.sendKeys(key);
            } catch (NoSuchElementException e) {
                Utils.holdExecutionForSeconds(5);
                element.sendKeys(key);
            } catch (InvalidElementStateException e) {
                Utils.holdExecutionForSeconds(5);
                element.sendKeys(key);
            }

        }
    }
