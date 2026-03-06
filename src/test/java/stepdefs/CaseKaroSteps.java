package stepdefs;

import org.testng.Assert;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;
import pages.SearchPage;

public class CaseKaroSteps {

    Playwright playwright;
    Browser browser;
    Page page;

    HomePage homePage;
    SearchPage searchPage;
    ProductPage productPage;
    CartPage cartPage;

    @Before
    public void setup() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );
        page = browser.newPage();
        homePage = new HomePage(page);
        searchPage = new SearchPage(page);
        productPage = new ProductPage(page);
        cartPage = new CartPage(page);
    }

    @After
    public void teardown() {
        browser.close();
        playwright.close();
    }

    @Given("User navigates to CaseKaro website")
    public void user_navigates_to_casekaro() {
        homePage.navigateTo();
    }

    @When("User clicks on Mobile Covers")
    public void user_clicks_mobile_covers() {
        homePage.clickMobileCovers();
    }

    @And("User searches for {string}")
    public void user_searches_for(String query) {
        searchPage.searchFor(query);
    }

    @Then("Other brands should not be visible in search results")
    public void other_brands_not_visible() {
        String[] nonAppleBrands = {"Samsung", "Vivo", "OnePlus", "Redmi", "Realme", "Oppo", "Moto", "Nokia"};
        for (String brand : nonAppleBrands) {
            Assert.assertFalse(
                    searchPage.isBrandVisible(brand),
                    "Brand " + brand + " should NOT appear in Apple search results"
            );
            System.out.println("Verified: " + brand + " is not in results");
        }
    }

    @When("User navigates to iPhone 16 Pro collection")
    public void user_navigates_to_iphone16pro() {
        productPage.navigateToIphone16ProCollection();
    }

    @And("User opens the first product page")
    public void user_opens_first_product() {
        productPage.openFirstProduct();
    }

    @And("User adds Hard material to cart")
    public void user_adds_hard_to_cart() {
        productPage.addMaterialToCart("Hard");
    }

    @And("User adds Soft material to cart")
    public void user_adds_soft_to_cart() {
        productPage.addMaterialToCart("Soft");
    }

    @And("User adds Glass material to cart")
    public void user_adds_glass_to_cart() {
        productPage.addMaterialToCart("Glass");
    }

    @When("User opens the cart")
    public void user_opens_cart() {
        cartPage.openCart();
    }

    @Then("Cart should contain all 3 materials")
    public void cart_should_contain_all_materials() {
        String cartContent = cartPage.getCartContent();
        Assert.assertTrue(cartContent.contains("Hard"), "Cart should contain Hard material");
        Assert.assertTrue(cartContent.contains("Soft") || cartContent.contains("Black Soft"), "Cart should contain Soft material");
        Assert.assertTrue(cartContent.contains("Glass"), "Cart should contain Glass material");
        System.out.println("All 3 materials found in cart");
    }

    @And("User prints all cart item details")
    public void user_prints_cart_details() {
        cartPage.printCartDetails();
    }
}