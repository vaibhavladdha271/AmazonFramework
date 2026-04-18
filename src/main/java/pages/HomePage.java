package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    private static By mobileMenuLocator=By.xpath("//a[contains(@data-csa-c-content-id,'mobiles')]");


    public HomePage(WebDriver driver){
        super();
        this.driver=driver;
    }
    public String getHomePageTitle(){
        wait.until(ExpectedConditions.titleContains("Online Shopping"));
        return driver.getTitle();
    }

    public void goToHomePage(String url){
        driver.get(url);
    }

    public MobilesPage clickOnMobileMenu(){
        clickOnElement(mobileMenuLocator);
        return new MobilesPage(driver);
    }




}
