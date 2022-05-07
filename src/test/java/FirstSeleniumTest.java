import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


public class FirstSeleniumTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private ConfigFileReader configFileReader;
    private final By bodyLocator = By.tagName("body");

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        configFileReader= new ConfigFileReader();
        wait = new WebDriverWait(driver, configFileReader.getTimeout());
    }

    // Login + Searching + Logout Tests
    // @Test
    // public void simplePageTest1() {
    //     // Open the mainPage
    //     MainPage mainPage = new MainPage(this.driver);
    //     System.out.println(mainPage.getBodyText());
    //     Assert.assertTrue(mainPage.getBodyText().contains(configFileReader.getMainPagePhrase()));

    //     // Open loginPage
    //     LogInPage loginPage = mainPage.openLoginPage();
    //     loginPage.enterUserName(configFileReader.getUserName());
    //     loginPage.enterPassword(configFileReader.getPassword());

    //     // Open AccountPage
    //     AccountPage accountPage = loginPage.pressLogin();
    //     System.out.println(accountPage.getBodyText());
    //     Assert.assertTrue(accountPage.getBodyText().contains(configFileReader.getAccountPagePhrase()));
        
    //     // Start searching
    //     SearchResultPage searchResultPage = accountPage.search(configFileReader.getSearchPhrase());        
    //     System.out.println(searchResultPage.getBodyText());
    //     Assert.assertTrue(searchResultPage.getBodyText().contains(configFileReader.getResultPagePhrase()));

    //     // Back to accountPage Logout and return back to loginPage
    //     AccountPage accountPage2 = searchResultPage.pressHome();
    //     accountPage2.pressAccount();
    //     LogInPage loginPage2 = searchResultPage.pressLogout();
        
    // }

    // // Send 2 forms test
    // @Test
    // public void simplePageTest2() {
    //     // Open the mainPage
    //     MainPage mainPage = new MainPage(this.driver);
    //     System.out.println(mainPage.getBodyText());
    //     Assert.assertTrue(mainPage.getBodyText().contains(configFileReader.getMainPagePhrase()));

    //     // Open loginPage
    //     LogInPage loginPage = mainPage.openLoginPage();
    //     loginPage.enterUserName(configFileReader.getUserName());
    //     loginPage.enterPassword(configFileReader.getPassword());

    //     // Open AccountPage
    //     AccountPage accountPage = loginPage.pressLogin();
    //     System.out.println(accountPage.getBodyText());
    //     Assert.assertTrue(accountPage.getBodyText().contains(configFileReader.getAccountPagePhrase()));

    //     // Enter My Profile
    //     accountPage.pressAccount();
    //     ProfilePage profilePage = accountPage.pressProfile();
    //     System.out.println(profilePage.getBodyText());
    //     Assert.assertTrue(profilePage.getBodyText().contains(configFileReader.getProfilePagePhrase()));

    //     // Add social account
    //     profilePage.openEditProfile();
    //     profilePage.fillForm1(configFileReader.firstname(),configFileReader.lastname(),configFileReader.place(),configFileReader.info(),configFileReader.twitter(),configFileReader.github());

    //     // Add new experience
    //     profilePage.addExperience();
    //     profilePage.fillForm2(configFileReader.title(), configFileReader.description(), configFileReader.company(),configFileReader.website());
    // }

    @Test
    public void multiplePagesTest() {
        String[] urls;
        urls= configFileReader.urlArray();
        String[] titles;
        titles= configFileReader.titleArray();

        for (int i = 0; i < urls.length; ++ i) {
            System.out.println("OPENING: ");
            System.out.print(urls[i]);
            System.out.println("LOOKING FOR: ");
            System.out.print(titles[i]);
            
            AnyPage anyPage = new AnyPage(driver,urls[i]);
            System.out.println(anyPage.getBodyText());
            Assert.assertTrue(anyPage.getBodyText().contains(titles[i]));
        }
    }
    
    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}

//janal97815@bamibi.com
//janal97815
//hbUpw4yNLXVz83j
//janal st