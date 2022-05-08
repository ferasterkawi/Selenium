import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;


public class MainPage extends PageBase {

    private final By logInLocator = By.xpath("//ul[@id = 'top-menu']/li[@class='menu-item menu-item-type-custom menu-item-object-custom menu-item-20399']/a");

    private ConfigFileReader configFileReader;

    public MainPage(WebDriver driver){
        super(driver);
        configFileReader= new ConfigFileReader();
        this.driver.get(configFileReader.getURL());
    }

    // Open LogInPage using Mouse Hover
    public LogInPage openLoginPage(){
        WebElement loginButtonElement = waitVisibiiltyAndFindElement(logInLocator);
        //loginButtonElement.click();
        Actions action = new Actions(driver);
        action.moveToElement(loginButtonElement).perform();
        action.click().build().perform();
        System.out.println("Done Mouse hover on loginButtonElement");

        return new LogInPage(this.driver);
    }
}