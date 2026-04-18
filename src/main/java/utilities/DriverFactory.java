package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    private static ThreadLocal<WebDriver> tlDriver=new ThreadLocal<>();

    public static void initDriver(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                tlDriver.set(new ChromeDriver());
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                tlDriver.set(new FirefoxDriver());
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                tlDriver.set(new EdgeDriver());
                break;
            default:
                throw new RuntimeException("Provided browser is not supported: " + browser);
        }
        tlDriver.get().manage().window().maximize();
    }

    public static WebDriver getDriver(){
            return tlDriver.get();
    }

    public static void quitDriver(){
        if(tlDriver.get()!=null) {
            tlDriver.get().quit();
            tlDriver.remove();
        }
    }
}
