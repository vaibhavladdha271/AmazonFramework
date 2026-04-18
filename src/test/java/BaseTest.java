import utilities.DriverFactory;

import java.sql.Driver;

public class BaseTest {

    public void tearDown(){
        if(DriverFactory.initDriver("chrome") !=null) {
            DriverFactory.initDriver("chrome").quit();
        }
    }

}
