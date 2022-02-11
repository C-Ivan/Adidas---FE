package stepDefinitions;

import cucumber.TestContext;
import io.cucumber.java.en.Given;
import pageObjects.CartPage;
import pageObjects.HomePage;

public class BasePageSteps {

    TestContext testContext;
    HomePage homePage;
    CartPage cartPage;


    public BasePageSteps(TestContext context) {
        testContext = context;
    }

    @Given("the user is in the {string}")
    public void theUserIsInThePage(String page) {
        switch (page) {
            case "homepage":
                homePage = testContext.getPageObjectManager().getHomePage();
                homePage.navigate();
                break;
            case "cartpage":
                cartPage = testContext.getPageObjectManager().getCartPage();
                cartPage.navigate();
                break;
        }
    }
}
