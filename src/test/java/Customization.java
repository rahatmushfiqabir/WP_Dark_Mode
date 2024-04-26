import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.sql.SQLOutput;
import java.util.List;

public class Customization {
    @FindBy(className = "deactivate-wp-dark-mode")
    WebElement active;

    @FindBy(className = "wp-menu-name")
    List<WebElement> menuItem;

    @FindBy(className = "page-title-action")
    WebElement addPlugins;

    @FindBy(id = "search-plugins")
    WebElement searchBar;

    @FindBy(className = "wp-dark-mode-white")
    List<WebElement> WpDarkMenuBar;

    @FindBy(className = "nav-item-child")
    List<WebElement> WpDarkSubMenuBar;

    @FindBy(className = "relative")
    List<WebElement> toggleSwitchBackend;

    @FindBy(className = "border-blue-500")
    WebElement saveButton;

    @FindBy(className = "duration-75")
    List<WebElement> switchSelect;

    @FindBy(xpath = "//a[contains(text(),'Accessibility')]")
    WebElement accessibility;





    public Customization(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void checkActivation(WebDriver driver) {
        try {
            menuItem.get(7).click(); //2
            String textActual = driver.findElement(By.id("deactivate-wp-dark-mode")).getText(); //2
            Assert.assertTrue(textActual.contains("Deactivate")); //2
            menuItem.get(5).click(); //4,6
            WpDarkSubMenuBar.get(1).click(); //4
            toggleSwitchBackend.get(2).click(); //4
            saveButton.click(); //4

            WpDarkMenuBar.get(1).click();               //click customization (7)
            WpDarkSubMenuBar.get(2).click();            //click switch settings (7)
            switchSelect.get(2).click();                //click 3rd switch (7)

//            WpDarkMenuBar.get(1).click();            //click customization
            WpDarkSubMenuBar.get(2).click();           //click switch settings

            Utils.scroll(driver,0,800);            //scroll

            switchSelect.get(21).click();               //click L
//            Thread.sleep(1000);

            switchSelect.get(24).click();               // click custom //8
            driver.findElements(By.className("text-gray-800")).get(0).click(); //8
            driver.findElements(By.className("text-gray-800")).get(0).sendKeys(Keys.CONTROL+"a"); //8
            driver.findElements(By.className("text-gray-800")).get(0).sendKeys("220"); //8


            switchSelect.get(25).click();               //click Left //9
            Utils.scroll(driver,0,2000);

            accessibility.click();  //10
            driver.findElements(By.className("h-full")).get(1).click(); //keyboard shortcut off //10
            Utils.scroll(driver,0,1000);
            driver.findElement(By.xpath("//button[normalize-space()='Save Changes']")).click(); //save



        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}

