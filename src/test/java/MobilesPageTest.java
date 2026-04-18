import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MobilesPage;

import java.util.Arrays;
import java.util.List;

public class MobilesPageTest extends BaseTest {

    public MobilesPage mobilePage;
    @Test(priority = 1)
    public void validateMobilePageTitle(){
        mobilePage=homePage.clickOnMobileMenu();
        Assert.assertEquals(mobilePage.getMobilePageTitle(),"Mobile Phones: Buy New Mobiles Online at Best Prices in India | Buy Cell Phones Online - Amazon.in");
    }

    @Test(priority = 2)
    public void validateMobilePageMenuItems(){
        mobilePage=homePage.clickOnMobileMenu();
        mobilePage.getMenuItems();
    }

    @Test(priority = 3)
    public void validateDellPageTitle(){
        mobilePage=homePage.clickOnMobileMenu();
        String dellPageTitle=mobilePage.clickOnDellLink("Laptops & Accessories","Dell");
        Assert.assertEquals("Buy Dell Laptop Online at Best Price In India - Amazon.in",dellPageTitle);
    }
}
