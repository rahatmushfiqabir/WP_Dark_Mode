import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Set;

public class CustomizationTestRunner extends Setup {

    Login login;
    @BeforeTest
    public void doLogin () {
        login = new Login(driver);
        login.doLogin("admin_0xciff19", "KU$M5l7SH@#rq*N5");
    }

    @Test
    public void checkPluginActivation(){
        Customization customization=new Customization(driver);
        customization.checkActivation(driver);
    }
}
