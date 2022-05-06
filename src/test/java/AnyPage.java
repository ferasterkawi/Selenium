import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AnyPage extends PageBase {

    private final By logInLocator = By.xpath("//ul[@id = 'top-menu']/li[@class='menu-item menu-item-type-custom menu-item-object-custom menu-item-20399']/a");

    private ConfigFileReader configFileReader;

    public AnyPage(WebDriver driver, String url){
        super(driver);
        configFileReader= new ConfigFileReader();
        this.driver.get(url);
    }

    public LogInPage openLoginPage(){
        WebElement loginButtonElement = waitVisibiiltyAndFindElement(logInLocator);
        loginButtonElement.click();
        return new LogInPage(this.driver);
    }
}