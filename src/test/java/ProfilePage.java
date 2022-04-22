import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ProfilePage extends PageBase {
    private final By accountLocator = By.xpath("//div[@class ='d-flex']");
    private final By logoutLocator = By.xpath("//div[@id ='obj-header-profile-logout']/div");
    private final By logInLocator = By.xpath("//*[@id='obj-btn-login']");
    private final By homeLocator = By.xpath("//div[@class='v-navigation-drawer__content']/div/a[1]");
    
    private final By editProfileLocator = By.xpath("//div[@class='row']/div[1]/div/button");
    private final By twitterLocator = By.xpath("//div[@class='v-card__text']/div[1]/div[2]/div[1]/div/input");
    private final By githubLocator = By.xpath("//div[@class='v-card__text']/div[2]/div[2]/div[1]/div/input");
    private final By firstNameLocator = By.xpath("//div[@class='row']/div[2]/div[1]/div[2]/div/div[1]/div[1]/div/div/div[1]/div/div/div[1]/div/input");
    private final By lastNameLocator = By.xpath("//div[@class='row']/div[2]/div[1]/div[2]/div/div[1]/div[1]/div/div/div[2]/div/div/div[1]/div/input");
    private final By placeLocator = By.xpath("//div[@class='v-text-field__slot']/input");
    private final By infoLocator = By.xpath("//div[@class='v-text-field__slot']/textarea");
    private final By confirmLocator = By.xpath("//div[@class='row']/div[1]/div/button[2]");

    private final By addExperience = By.xpath("//div[@class='d-flex justify-end']/span");
    private final By titleLocator = By.xpath("//div[@class='col col-12']/div[1]/div/div[1]/div/input");
    private final By descriptionLocator = By.xpath("//div[@class='col col-12']/div[2]/div/div[1]/div/textarea");
    private final By companyLocator = By.xpath("//div[@class='col-md-5 col-12']/div/div[2]/div[1]/div/input");
    private final By websiteLocator = By.xpath("//div[@class='col-md-7 col-12']/div/div[2]/div[1]/div/input");
    private final By yearLocator = By.xpath("//div[@class='row']/div[4]/div[1]/div[2]/div[1]/div");
    private final By year2022Locator = By.xpath("//div[@class='v-picker__body theme--light']/div/ul/li[1]");
    private final By mounthAPRLocator = By.xpath("//div[@class='v-date-picker-table v-date-picker-table--month theme--light']/table/tbody/tr[2]/td[1]/button/div");
    private final By day1Locator = By.xpath("//div[@class='v-date-picker-table v-date-picker-table--date theme--light']/table/tbody/tr[1]/td[6]/button");
    private final By addworkLocator = By.xpath("//form[@class='v-form']/div[2]/button");
    
    public ProfilePage(WebDriver driver){
        super(driver);
        this.wait = new WebDriverWait(driver, 10);
    }

    public AccountPage pressHome(){
        WebElement acountButtonElement = findElement(homeLocator);
        acountButtonElement.click();
        return new AccountPage(this.driver);
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

    public void openEditProfile(){
        WebElement acountButtonElement = waitVisibiiltyAndFindElement(editProfileLocator);
        acountButtonElement.click();
    }

    public void fillForm1(String firstname, String lastname, String place , String info, String twitter, String github){
        WebElement firstnameElement = waitVisibiiltyAndFindElement(firstNameLocator);
        firstnameElement.sendKeys(firstname + "\n");
        WebElement lastnameElement = waitVisibiiltyAndFindElement(lastNameLocator);
        lastnameElement.sendKeys(lastname + "\n");
        WebElement placeElement = waitVisibiiltyAndFindElement(placeLocator);
        placeElement.sendKeys(place + "\n");
        WebElement infoElement = waitVisibiiltyAndFindElement(infoLocator);
        infoElement.sendKeys(place + "\n");
        WebElement twitterElement = waitVisibiiltyAndFindElement(twitterLocator);
        twitterElement.sendKeys(twitter + "\n");
        WebElement githubElement = waitVisibiiltyAndFindElement(githubLocator);
        githubElement.sendKeys(github + "\n");
        WebElement confirmButtonElement = waitVisibiiltyAndFindElement(confirmLocator);
        confirmButtonElement.click();
    }

    public void addExperience(){
        WebElement addElement = waitVisibiiltyAndFindElement(addExperience);
        addElement.click();
    }

    public void fillForm2(String title, String description, String company, String website){
        WebElement titleElement = waitVisibiiltyAndFindElement(titleLocator);
        titleElement.sendKeys(title + "\n");
        WebElement descriptionElement = waitVisibiiltyAndFindElement(descriptionLocator);
        descriptionElement.sendKeys(description + "\n");
        WebElement companyElement = waitVisibiiltyAndFindElement(companyLocator);
        companyElement.sendKeys(company + "\n");
        WebElement websiteElement = waitVisibiiltyAndFindElement(websiteLocator);
        websiteElement.sendKeys(website + "\n");
        WebElement yearElement = waitVisibiiltyAndFindElement(yearLocator);
        yearElement.click();
        WebElement year2022Element = waitVisibiiltyAndFindElement(year2022Locator);
        year2022Element.click();
        WebElement aprElement = waitVisibiiltyAndFindElement(mounthAPRLocator);
        aprElement.click();
        WebElement dayElement = waitVisibiiltyAndFindElement(day1Locator);
        dayElement.click();

        WebElement addWorkElement = waitVisibiiltyAndFindElement(addworkLocator);
        addWorkElement.click();
        addWorkElement.click();
    }
}
