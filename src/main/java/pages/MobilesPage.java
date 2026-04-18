package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.ScreenshotUtil;

import java.util.List;
import java.util.stream.Collectors;

public class MobilesPage extends BasePage {

    private static By menuItemsLocator= By.xpath("//div[@id='nav-subnav']/ul/li");
    private static String menuItemLocator="//span[contains(text(),'$$')]";
    private static String subMenuItemLocator="//a[text()='$$']";

    public MobilesPage(WebDriver driver){
        super();
        this.driver=driver;
    }

    public String getMobilePageTitle(){
        wait.until(ExpectedConditions.titleContains("Mobile Phones"));
        return driver.getTitle();
    }
    public void getMenuItems(){
        List<WebElement> menuItemsList=getListOfItems(menuItemsLocator);
        List<String> menuList=menuItemsList.stream().map(menu->menu.getText()).collect(Collectors.toList());
        menuList.stream().forEach(System.out::println);
        System.out.println("Count of menu items: "+menuList.size());
        ScreenshotUtil.captureFullPage("Mobile page screenshot");
    }

    public String clickOnDellLink(String menuItem,String subMenuItem){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(menuItemsLocator));
        menuItemLocator=menuItemLocator.replace("$$",menuItem);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(menuItemLocator)));
        hoverOnElement(By.xpath(menuItemLocator));
        subMenuItemLocator=subMenuItemLocator.replace("$$",subMenuItem);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(subMenuItemLocator)));
        clickOnELementUsingActions(By.xpath(subMenuItemLocator));
        wait.until(ExpectedConditions.titleContains("Dell"));
        return driver.getTitle();
    }


}
