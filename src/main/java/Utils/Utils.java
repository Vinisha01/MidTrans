package Utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

public class Utils<properties> extends SetUp{


        public boolean isDisplayedElement(String xpath) {
            boolean flag = false;
            try {
                WebElement element = driver.findElement(By.xpath(xpath));
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

      /*  public void click(WebElement element) {
            element.click();
        }

        public void EnterText(WebElement element, String text) {
            element.sendKeys(text);
        }*/

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

        public void handleDropdownOfSelectTagUsingValue(WebElement element, String value) {
            Select select = new Select(element);
            select.selectByValue(value);
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

        public void hover(WebElement element) {
            Actions actions = new Actions(driver);
            actions.moveToElement(element);
            actions.perform();
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
