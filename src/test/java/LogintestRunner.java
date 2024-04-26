import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogintestRunner extends Setup {
    @Test
    public void doLogin () {
        Login login = new Login(driver);
        login.doLogin("admin_0xciff19", "KU$M5l7SH@#rq*N5");
        WebElement imgProfile = driver.findElement(By.className("avatar-26"));
        Assert.assertTrue(imgProfile.isDisplayed());
    }
}
