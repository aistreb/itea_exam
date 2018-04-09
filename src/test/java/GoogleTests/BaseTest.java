package GoogleTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import GooglePages.HomePage;

public class BaseTest {
    WebDriver driver;
    HomePage homePage;

    /**
     * WebDriverManager download a binary file which allows WebDriver to handle browsers;
     * New Firefox browser is opened;
     * https://www.google.com/ is loaded
     */
    @BeforeMethod
    public void beforeTest(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://www.google.com/");
        homePage = new HomePage(driver);
        }

    /**
     * Close browser
     */
    @AfterMethod
    public void afterTest() {
        driver.close();
        }

}
