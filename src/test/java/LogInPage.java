import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LogInPage extends PageBase {

    private final By userNameLocator = By.xpath("//form[@id ='obj-form-login']/div[1]/div/div[1]/div[@class='v-text-field__slot']/input");
    private final By passWordLocator = By.xpath("//form[@id ='obj-form-login']/div[2]/div/div[1]/div[@class='v-text-field__slot']/input");
    private final By logInLocator = By.xpath("//*[@id='obj-btn-login']");
    private final By accountLocator = By.xpath("//div[@class ='d-flex']");

    protected WebDriverWait wait;

    public LogInPage(WebDriver driver){
        super(driver);
        this.wait = new WebDriverWait(driver, 10);

    }

    public void enterUserName(String userQuery){
        WebElement searchBarElement = waitVisibiiltyAndFindElement(userNameLocator);
        searchBarElement.sendKeys(userQuery + "\n");
    }

    public void enterPassword(String passQuery){
        WebElement searchBarElement = waitVisibiiltyAndFindElement(passWordLocator);
        searchBarElement.sendKeys(passQuery + "\n");
    }

    public AccountPage pressLogin(){
        WebElement loginButtonElement = waitVisibiiltyAndFindElement(logInLocator);
        loginButtonElement.click();
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(accountLocator));
        return new AccountPage(this.driver);
    }
}
