package GooglePages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class SearchResultPage extends BasePage{

    @FindBy(xpath = "//h3[@class='r']")
    private List<WebElement> resultsWebElementList;

    @FindBy(id = "resultStats")
    private WebElement resultsNumber;

    @FindBy(xpath = "//*[@aria-label='Page 2']")
    private WebElement page2Icon;


    /**
     * Constructor of SearchResultPage class that takes WebDriver instance from BasePage class
     * and initialise SearchResultPage WebElements via PageFactory.
     * @param driver - WebDriver instance
     */
    public SearchResultPage (WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Wait until resultsNumber icon is visible;
     * get all search result headers into List of Strings;
     * @return - List of Strings with search result headers
     */
    public List<String> getResults() {
        waitUntilElementIsVisible(resultsNumber, 10);
        List<String> resultsStringList = new ArrayList();
        for (WebElement result : resultsWebElementList) {
            String cardTitle = result.getText();
            resultsStringList.add(cardTitle);
        }
        return resultsStringList;
    }

    /**
     * Click on "2" link to switch to next page
     */
    public void clickTo2Page() {
        page2Icon.click();
    }
}
