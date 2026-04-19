package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.DriverFactory;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    public BasePage(){
        this.driver=DriverFactory.getDriver();
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void clickOnElement(By locator){
        WebElement element=wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    public void enterText(By locator,String textToEnter){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(textToEnter);
    }

    public String getText(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }

    public void hoverOnElement(By locator){
        Actions actions=new Actions(driver);
        actions.moveToElement(driver.findElement(locator)).perform();
    }

    public void scrollAndViewElement(By locator){
        WebElement element=driver.findElement(locator);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true",element);
    }

    public void waitForPageTitle(String title){
        wait.until(ExpectedConditions.titleIs(title));
    }

    public void waitForInvisibilityOfElement(By locator){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
    public List<WebElement> getListOfItems(By locator){
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public void clickOnELementUsingActions(By locator){
        Actions actions=new Actions(driver);
        actions.moveToElement(driver.findElement(locator)).click(driver.findElement(locator)).build().perform();
    }

    public void clickOnELementUsingActions(WebElement element){
        Actions actions=new Actions(driver);
        actions.moveToElement(element).click(element).build().perform();
    }

    public void switchToWindow(){
        Set<String> windows=driver.getWindowHandles();
        Iterator<String> iterator=windows.iterator();
        String parentWindow=iterator.next();
        while(iterator.hasNext()){
            String childWindow=iterator.next();
            driver.switchTo().window(childWindow);
        }
    }
}
