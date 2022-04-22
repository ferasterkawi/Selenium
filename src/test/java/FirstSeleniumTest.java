import org.junit.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.support.ui.*;


public class FirstSeleniumTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
    }

    // Searching Test
    @Test
    public void simplePageTest1() {
        // Open the mainPage
        MainPage mainPage = new MainPage(this.driver);
        System.out.println(mainPage.getBodyText());
        Assert.assertTrue(mainPage.getBodyText().contains("Develop the Robots of the Future"));

        // Open loginPage
        LogInPage loginPage = mainPage.openLoginPage();
        loginPage.enterUserName("janal97815");
        loginPage.enterPassword("hbUpw4yNLXVz83j");

        // Open AccountPage
        AccountPage accountPage = loginPage.pressLogin();
        System.out.println(accountPage.getBodyText());
        Assert.assertTrue(accountPage.getBodyText().contains("Learning Paths"));
        
        // Start searching
        SearchResultPage searchResultPage = accountPage.search("ros basics in 5 days");        
        System.out.println(searchResultPage.getBodyText());
        Assert.assertTrue(searchResultPage.getBodyText().contains("Search Courses"));
        searchResultPage.pressHome();
        searchResultPage.pressAccount();

        // Logout and return back to loginPage
        LogInPage loginPage2 = searchResultPage.pressLogout();
        
    }

    // @Test
    // public void simplePageTest2() {
    //     // Open the mainPage
    //     MainPage mainPage = new MainPage(this.driver);
    //     System.out.println(mainPage.getBodyText());
    //     Assert.assertTrue(mainPage.getBodyText().contains("Develop the Robots of the Future"));

    //     // Open loginPage
    //     LogInPage loginPage = mainPage.openLoginPage();
    //     loginPage.enterUserName("janal97815");
    //     loginPage.enterPassword("hbUpw4yNLXVz83j");

    //     // Open AccountPage
    //     AccountPage accountPage = loginPage.pressLogin();
    //     System.out.println(accountPage.getBodyText());
    //     Assert.assertTrue(accountPage.getBodyText().contains("Learning Paths"));
        
    // }
    
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