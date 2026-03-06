package pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

public class HomePage {

    private Page page;

    public HomePage(Page page) {
        this.page = page;
    }

    public void navigateTo() {
        page.navigate("https://casekaro.com");
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
        System.out.println(" Navigated to CaseKaro website");
    }

    public void clickMobileCovers() {
        page.locator("a[href='/pages/phone-cases-by-model']").nth(1).click();
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
        System.out.println("Clicked on Mobile Covers");
    }
}