import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Parameters("browser")
    @Test
    public void validateHomePageTitle(){
//        System.out.println(homePage.getHomePageTitle());
        Assert.assertEquals(homePage.getHomePageTitle(),"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
    }


}
