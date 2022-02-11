package stepDefinitions;

import cucumber.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageObjects.CartPage;


public class CartPageSteps {

    TestContext testContext;
    CartPage cartPage;


    public CartPageSteps(TestContext context) {
        testContext = context;
        cartPage = testContext.getPageObjectManager().getCartPage();
    }

    @When("the user removes {string} from the cart")
    public void theUserRemovesAnItemFromTheCart(String item) {
        cartPage.navigate();
        cartPage.deleteItem(item);
    }

    @Then("the user should see {string} items in the cart")
    public void theUserShouldSeeItemsInTheCart(String items)  {
        cartPage.navigate();
        Assert.assertTrue("The total amount of items in the cart doesn't match the expected value ("+items+")", cartPage.correctAmountOfItemsInCart(Integer.parseInt(items)));
    }

    @When("the user places the order")
    public void theUserPlacesTheOrder() {
        cartPage.navigate();
        cartPage.clickOnPlaceOrder();
    }

    @Then("a form should be displayed")
    public void aFormShouldBeDisplayed() {
        Assert.assertTrue("The purchase form isn't displayed", cartPage.isPurchaseFormDisplayed());
    }

    @And("the user fills and confirms the purchase form")
    public void theUserFillsThePurchaseForm() {
        cartPage.completeForm(new CartPage.PurchaseForm("Ivan", "Argentina", "Buenos Aires", "123654789", "2025", "12"));
        cartPage.clickOnPurchase();
    }

    @Then("a confirmation with the information of the purchase should appear")
    public void aConfirmationWithTheInformationOfThePurchaseShouldAppear() {
        Assert.assertTrue("The confirmation of the purchase isn't correctly displayed", cartPage.isPurchaseConfirmationDisplayed());
    }

    @Then("the total purchase amount should be {string}")
    public void theTotalPurchaseAmountShouldBe(String expectedTotalPrice){
        Assert.assertTrue("The total price doesn't match the expected ("+expectedTotalPrice+")" , cartPage.purchaseTotalPrice(expectedTotalPrice));
        cartPage.logIdAndAmount();
        cartPage.clickOnOk();
    }
}