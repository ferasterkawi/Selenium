import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SearchResultPage extends PageBase {
    private final By accountLocator = By.xpath("//div[@class ='d-flex']");
    private final By logoutLocator = By.xpath("//div[@id ='obj-header-profile-logout']/div");
    private final By logInLocator = By.xpath("//*[@id='obj-btn-login']");
    private final By homeLocator = By.xpath("//div[@class='v-navigation-drawer__content']/div/a[1]");

    public SearchResultPage(WebDriver driver){
        super(driver);
    }

    public void pressHome(){
        WebElement acountButtonElement = findElement(homeLocator);
        acountButtonElement.click();
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
}
