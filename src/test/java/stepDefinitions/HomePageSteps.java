package stepDefinitions;

import cucumber.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageObjects.HomePage;


public class HomePageSteps {

    TestContext testContext;
    HomePage homePage;

    public HomePageSteps(TestContext context) {
        testContext = context;
        homePage = testContext.getPageObjectManager().getHomePage();
    }

    @When("the user goes to the {string} category")
    public void theUserGoesToCategory(String category) {
        homePage.clickOn_Category(category);
    }

    @Then("the user should see the products belonging to the {string} category")
    public void theUserShouldSeeTheProductsBelongingToThatCategory(String category) {
        switch (category) {
            case "Monitors":
                Assert.assertTrue(homePage.isAppleMonitor24Displayed());
                Assert.assertFalse(homePage.isPhoneSamsungGalaxyS7Displayed());
                break;
            case "Phones":
                Assert.assertTrue(homePage.isPhoneNexus6Displayed());
                Assert.assertFalse(homePage.isAppleMonitor24Displayed());
                break;
            case "Laptops":
                Assert.assertTrue(homePage.isLaptopSonyVaioi5Displayed());
                Assert.assertFalse(homePage.isAppleMonitor24Displayed());
                break;
        }
    }

    @And("the user adds {string} from the {string} category to the cart")
    public void theUserAddsALaptopToTheCart(String item, String category) {
        homePage.navigate();
        homePage.clickOn_Category(category);
        homePage.addItemToCart(item);
    }
}
