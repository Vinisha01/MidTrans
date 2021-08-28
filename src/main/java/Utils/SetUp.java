package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SetUp {


        public static WebDriver driver;
        public  static WebDriverWait wait;



        public static WebDriver LaunchBrowser(String browserName){
            if (browserName.equalsIgnoreCase("chrome")){
                System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
                driver = new ChromeDriver();
            }else if (browserName.equalsIgnoreCase("firefox")){
                System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
                driver = new FirefoxDriver();
            } else {
                System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
                driver = new ChromeDriver();
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30000, TimeUnit.MICROSECONDS);
            wait = new WebDriverWait(driver,30);
            return driver;
        }

    }

