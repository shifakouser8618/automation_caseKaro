package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

public class CartPage {

    private Page page;

    public CartPage(Page page) {
        this.page = page;
    }

    public void openCart() {
        page.navigate("https://casekaro.com/cart");
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
        System.out.println("✅ Opened cart page");
    }

    public String getCartContent() {
        return page.locator(".cart-item").allTextContents().toString();
    }

    public int getCartItemCount() {
        return page.locator(".cart-item").count();
    }

    public void printCartDetails() {
        int itemCount = getCartItemCount();

        System.out.println("\n======================================");
        System.out.println("        CART ITEMS DETAILS            ");
        System.out.println("======================================");

        for (int i = 0; i < itemCount; i++) {
            Locator item = page.locator(".cart-item").nth(i);

            String name = item.locator(".cart-item__name").textContent().trim();

            String fullText = item.locator(".cart-item__details").textContent()
                    .replaceAll("\\s+", " ").trim();
            String material = fullText.contains("Material:")
                    ? fullText.split("Material:")[1].trim().split(" ")[0].trim()
                    : "N/A";

            String price = item.locator(".price").first().textContent().trim();

            String link = "https://casekaro.com" + item.locator("a").first().getAttribute("href");

            System.out.println("\nItem " + (i + 1) + ":");
            System.out.println("  Name     : " + name);
            System.out.println("  Material : " + material);
            System.out.println("  Price    : " + price);
            System.out.println("  Link     : " + link);
        }

        System.out.println("\n======================================");
        System.out.println(" All item details printed");
    }
}