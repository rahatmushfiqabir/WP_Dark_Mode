import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
    @FindBy(id = "user_login")
    WebElement userName;

    @FindBy(id = "user_pass")
    WebElement userPassword;

    @FindBy(id = "wp-submit")
    WebElement btnLogin;

    WebDriver driver;
    public Login(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void doLogin(String username, String password){
        userName.sendKeys(username); //1
        userPassword.sendKeys(password); //1
        btnLogin.click(); //1
//      pressClick.click();
    }
}
