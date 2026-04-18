import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.HomePage;
import utilities.DriverFactory;

import java.sql.Driver;

public class BaseTest {
    protected WebDriver driver;
    HomePage homePage;

    @Parameters("browser")
    @BeforeMethod
    public void initialize(@Optional String browser) {
        DriverFactory.initDriver(browser);
        driver=DriverFactory.getDriver();
         homePage=new HomePage(driver);
         homePage.goToHomePage("https://amazon.in");
    }

    @AfterMethod
    public void tearDown(){
         DriverFactory.quitDriver();

    }

}
