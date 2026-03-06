package pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

public class ProductPage {

    private Page page;

    public ProductPage(Page page) {
        this.page = page;
    }

    public void navigateToIphone16ProCollection() {
        page.navigate("https://casekaro.com/collections/iphone-16-pro-back-covers");
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
        System.out.println("✅ Navigated to iPhone 16 Pro collection");
    }

    public void openFirstProduct() {
        page.navigate("https://casekaro.com/products/classic-porsche-911-iphone-16-pro-back-cover");
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
        System.out.println("✅ Opened first product page");
    }

    public void addMaterialToCart(String material) {
        page.navigate("https://casekaro.com/products/classic-porsche-911-iphone-16-pro-back-cover");
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
        page.waitForTimeout(2000);

        page.locator("label:has-text('" + material + "')").first().click();
        page.waitForTimeout(1000);

        page.locator("button[name='add']").click();
        page.waitForTimeout(2000);

        System.out.println(" Added to cart: " + material);
    }
}