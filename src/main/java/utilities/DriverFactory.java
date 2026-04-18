package utilities;

import constants.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    public ThreadLocal<WebDriver> driver=new ThreadLocal<>();
    public static WebDriver initDriver(String browserName){
            if (browserName.equals(Browser.CHROME)) {
                ChromeOptions options = new ChromeOptions();
                driver.get()
                driver.manage().window().maximize();
                return driver;
            } else if (browserName.equals(Browser.FIREFOX)) {
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                return driver;
            } else if (browserName.equals(Browser.EDGE)) {
                driver = new EdgeDriver();
                driver.manage().window().maximize();
                return driver;
            } else {
                driver = new ChromeDriver();
                return driver;
            }
        }
    }


}
