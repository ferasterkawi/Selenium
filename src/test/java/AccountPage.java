import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AccountPage extends PageBase {
    private final By accountLocator = By.xpath("//div[@class ='d-flex']");
    private final By logoutLocator = By.xpath("//div[@id ='obj-header-profile-logout']/div");
    private final By logInLocator = By.xpath("//*[@id='obj-btn-login']");
    private final By searchLocator = By.xpath("//div[@class='v-toolbar__content']/div[2]/div[1]/div/div/div[2]/input");
    private final By allResultsLocator = By.xpath("//div[@class='v-card__subtitle']/span/a");
    private final By searchResultsLocator = By.xpath("//div[@class='container']/h3");

    protected WebDriverWait wait;

    public AccountPage(WebDriver driver){
        super(driver);
        this.wait = new WebDriverWait(driver, 10);
    }

    public void pressAccount(){
        WebElement acountButtonElement = waitVisibiiltyAndFindElement(accountLocator);
        acountButtonElement.click();
    }

    public LogInPage pressLogout(){
        WebElement logoutButtonElement = waitVisibiiltyAndFindElement(logoutLocator);
        logoutButtonElement.click();
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(logInLocator));
        return new LogInPage(this.driver);
    }

    public SearchResultPage search(String searchQuery){
        WebElement searchBarElement = waitVisibiiltyAndFindElement(searchLocator);
        searchBarElement.sendKeys(searchQuery + "\n");
        searchBarElement.click();
        WebElement allResultsElement = waitVisibiiltyAndFindElement(allResultsLocator);
        allResultsElement.click();
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(searchResultsLocator));
        return new SearchResultPage(this.driver);
    }

}