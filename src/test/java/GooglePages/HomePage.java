package GooglePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{

    @FindBy(id = "lst-ib")
    private WebElement searchField;

    @FindBy(name= "btnK")
    private WebElement searchButton;

    /**
     * Constructor of HomePage class that takes WebDriver instance from BasePage class
     * and initialise HomePage WebElements via PageFactory.
     * @param driver - WebDriver instance
     */
    public HomePage(WebDriver driver) {
        super (driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Wait until searchField is clickable,
     * input searchTerm into searchField and press searchButton named "Search in Google"
     * @param searchTerm - term to search for
     * @return new pageObject of class SearchResultPage
     */
    public SearchResultPage searchByTerm(String searchTerm) {
        waitUntilElementIsClickable(searchField, 10);
        searchField.sendKeys(searchTerm);
        searchButton.click();
        return new SearchResultPage(driver);
    }
}
