package pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

public class SearchPage {

    private Page page;

    public SearchPage(Page page) {
        this.page = page;
    }

    public void searchFor(String query) {
        page.navigate("https://casekaro.com/search?q=" + query + "&type=product");
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
        System.out.println(" Searched for: " + query);
    }

    public String getSearchResults() {
        return page.locator(".card__heading").allTextContents().toString();
    }

    public boolean isBrandVisible(String brand) {
        return getSearchResults().toLowerCase().contains(brand.toLowerCase());
    }
}