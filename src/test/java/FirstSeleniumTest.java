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

    @Test
    public void simplePageTest1() {
        MainPage mainPage = new MainPage(this.driver);

        System.out.println(mainPage.getBodyText());
        Assert.assertTrue(mainPage.getBodyText().contains("This is a collection of sample web pages"));
        
        mainPage.openSearchToggler();
        SearchResultPage searchResultPage = mainPage.search("Feras");

        System.out.println(searchResultPage.getBodyText());
        Assert.assertTrue(searchResultPage.getBodyText().contains("A new password has been sent to Feras"));
        
    }

    @Test
    public void simplePageTest2() {
        MainPage mainPage = new MainPage(this.driver);

        System.out.println(mainPage.getBodyText());
        Assert.assertTrue(mainPage.getBodyText().contains("This is a collection of sample web pages"));
        
        mainPage.openSearchToggler();
        SearchResultPage searchResultPage = mainPage.search("something");

        System.out.println(searchResultPage.getBodyText());
        Assert.assertTrue(searchResultPage.getBodyText().contains("A new password has been sent to something"));
        
    }
    
    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
