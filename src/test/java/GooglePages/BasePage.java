package GooglePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    WebDriver driver;

    /**
     * Constructor of BasePage class which takes WebDriver instance initialized in @BeforeMethod
     * for reuse in BasePage class methods
     * @param driver- WebDriver instance
     */
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Method to wait until webElement is clickable
     * @param webElement - webElement to wait for
     * @param timeOutInSeconds - how long in seconds to wait for webElement
     */
    public void waitUntilElementIsClickable (WebElement webElement, int timeOutInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    /**
     * Method to wait until webElement is visible
     * @param webElement - webElement to wait for
     * @param timeOutInSeconds - how long in seconds to wait for webElement
     */
    public void waitUntilElementIsVisible (WebElement webElement, int timeOutInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

}
