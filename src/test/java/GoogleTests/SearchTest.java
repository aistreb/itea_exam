package GoogleTests;

import GooglePages.SearchResultPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTest extends BaseTest {

    /**
     * This test opens Firefox browser, navigate to https://www.google.com/ page,
     * input searchTerm into searchField, click on Search button,
     * assert number of search results is 11 on page 1,
     * assert that each result in a list contains searchTerm,
     * click on "2" link to switch to next page,
     * assert number of search results is 10 on page 1
     * assert that each result in a list contains searchTerm
     * close web browser
     */
    @Test
    public void seleniumSearchTest (){
        String searchTerm = "Selenium";
        SearchResultPage searchPage = homePage.searchByTerm(searchTerm);

        List<String> results1 = searchPage.getResults();
        Assert.assertEquals(results1.size(), 11, "Number of results is wrong on SearchResultsPage 1");
        for (String result : results1) {
            Assert.assertTrue(result.contains(searchTerm),
                    "Searchterm "+searchTerm+ " not found in cart");
        }

        searchPage.clickTo2Page();

        List<String> results2 = searchPage.getResults();
        Assert.assertEquals(results2.size(), 10, "Number of results is wrong on SearchResultsPage 2");
        for (String result : results2) {
            Assert.assertTrue(result.contains(searchTerm),
                    "Searchterm "+searchTerm+ " not found in cart");
        }
    }


}
