package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.DriverFactory;

public class BasePage {
    DriverFactory driverFactory=new DriverFactory();
    static WebDriver driver;
    public static void initialize(){
           driver=DriverFactory.initDriver("chrome");
    }
    public static void clickOnElement(By locator){

    }
}
