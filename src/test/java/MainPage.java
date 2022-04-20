import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MainPage extends PageBase {

    private final By searchTogglerLocator = By.id("requestPassword");
    private final By searchLocator = By.id("account");

    public MainPage(WebDriver driver){
        super(driver);
        this.driver.get("http://selenium.thinkcode.se");
    }

    public void openSearchToggler(){
        WebElement searchTogglerElement = waitVisibiiltyAndFindElement(searchTogglerLocator);
        searchTogglerElement.click();
    }

    public SearchResultPage search(String searchQuery){
        WebElement searchBarElement = waitVisibiiltyAndFindElement(searchLocator);
        searchBarElement.sendKeys(searchQuery + "\n");
        return new SearchResultPage(this.driver);
    }
}
