package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.ScreenshotUtil;

import java.util.List;
import java.util.stream.Collectors;

public class ProductPage extends BasePage {

    private static By productAmountLocator=By.xpath("(//span[@class='a-price-whole'])[1]");

    public ProductPage(WebDriver driver){
        super();
        this.driver=driver;
    }

    public String getProductPageTitle(){
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

    public String getDellPageTitle(String menuItem,String subMenuItem){
        clickOnDellLink(menuItem,subMenuItem);
        return driver.getTitle();
    }

    public void clickOnDellLink(String menuItem,String subMenuItem){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(menuItemsLocator));
        menuItemLocator=menuItemLocator.replace("$$",menuItem);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(menuItemLocator)));
        hoverOnElement(By.xpath(menuItemLocator));
        subMenuItemLocator=subMenuItemLocator.replace("$$",subMenuItem);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(subMenuItemLocator)));
        clickOnELementUsingActions(By.xpath(subMenuItemLocator));
        wait.until(ExpectedConditions.titleContains("Dell"));
    }


    public void clickOnFirstDellProduct(){
        enterText(searchField,"Gaming Laptop");
        clickOnElement(searchButtonLocator);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(laptopProductListLocator));
        List<WebElement> laptopProductList=getListOfItems(laptopProductListLocator);
        String productTitle="";
        for(WebElement laptop:laptopProductList){
            if(laptop.getText().contains("Dell")){
                productTitle=laptop.getText();
                clickOnELementUsingActions(laptop);
                break;
            }
        }
    }

    public void clickOnProduct() {
        clickOnFirstDellProduct();
        switchToWindow();
        return new ProductsPage();

    }


    public String getProductAmount(){
        return getText(productAmountLocator).replace(",","");
    }



}
