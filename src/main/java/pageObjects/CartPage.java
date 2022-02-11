package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.Wait;

import java.util.List;

import java.util.concurrent.TimeUnit;


public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void navigate() {
        if (!driver.getCurrentUrl().contains("https://www.demoblaze.com/cart.html")) {
            driver.get("https://www.demoblaze.com/cart.html");
        }
    }

    @FindBy(xpath = "//tr[@class='success']/td[2]")
    private List<WebElement> itemsList;

    @FindBy(className = "btn-success")
    private WebElement btnPlaceOrder;

    @FindBy(id = "totalp")
    private WebElement totalPrice;

    @FindBy(id = "orderModalLabel")
    private WebElement purchaseForm;

    @FindBy(id = "name")
    private WebElement inputName;

    @FindBy(id = "country")
    private WebElement inputCountry;

    @FindBy(id = "city")
    private WebElement inputCity;

    @FindBy(id = "card")
    private WebElement inputCreditCardNumber;

    @FindBy(id = "month")
    private WebElement inputCreditCardMonth;

    @FindBy(id = "year")
    private WebElement inputCreditCardYear;

    @FindBy(className = "sweet-alert")
    private WebElement purchaseConfirmation;

    @FindBy(xpath = "//button[text()='Purchase']")
    private WebElement btnPurchase;

    @FindBy(xpath = "//button[text()='OK']")
    private WebElement btnOk;

    @FindBy(css = ".lead.text-muted")
    private WebElement purchaseConfirmationInformation;

    private int itemsAmount = 0;


    public boolean correctAmountOfItemsInCart(int itemsAmount) {
        Wait.untilJqueryIsDone(driver, 5L);
        return itemsList.size() == itemsAmount;
    }

    public void clickOnPlaceOrder() {
        clickElement(btnPlaceOrder);
    }

    public boolean isPurchaseFormDisplayed() {
        Wait.untilJqueryIsDone(driver, 5L);
        return isDisplayed(purchaseForm);
    }

    public void inputName(String name) {
        inputKeys(inputName, name);
    }

    public void inputCity(String city) {
        inputKeys(inputCity, city);
    }

    public void inputCountry(String country) {
        inputKeys(inputCountry, country);
    }

    public void inputCreditCardNumber(String creditCardNumber) {
        inputKeys(inputCreditCardNumber, creditCardNumber);
    }

    public void inputCreditCardMonth(String creditCardMonth) {
        inputKeys(inputCreditCardMonth, creditCardMonth);
    }

    public void inputCreditCardYear(String creditCardYear) {
        inputKeys(inputCreditCardYear, creditCardYear);
    }

    public void completeForm(PurchaseForm purchaseForm) {
        inputName(purchaseForm.name);
        inputCity(purchaseForm.city);
        inputCountry(purchaseForm.country);
        inputCreditCardNumber(purchaseForm.creditCardNumber);
        inputCreditCardMonth(purchaseForm.creditCardMonth);
        inputCreditCardYear(purchaseForm.creditCardYear);
    }

    public void clickOnPurchase() {
        clickElement(btnPurchase);
    }

    public boolean isPurchaseConfirmationDisplayed() {
        return isDisplayed(purchaseConfirmation);
    }

    public boolean purchaseTotalPrice(String expectedTotalPrice) {
        return purchaseConfirmationInformation.getText().contains(expectedTotalPrice);
    }

    public void logIdAndAmount() {
        String[] purchaseInformation = purchaseConfirmationInformation.getText().split("\n");
        System.out.println(purchaseInformation[0]);
        System.out.println(purchaseInformation[1]);
    }

    public void deleteItem(String item) {
        clickElement(driver.findElement(By.xpath("//td[text()='" + item + "']//following-sibling::td[2]//a")));
        Wait.untilJqueryIsDone(driver, 5L);
    }

    public void clickOnOk() {
        clickElement(btnOk);
    }

    public static class PurchaseForm {

        public PurchaseForm(String name, String country, String city, String creditCardNumber, String creditCardYear, String creditCardMonth) {
            this.name = name;
            this.country = country;
            this.city = city;
            this.creditCardNumber = creditCardNumber;
            this.creditCardYear = creditCardYear;
            this.creditCardMonth = creditCardMonth;
        }

        private String name;

        private String country;

        private String city;

        private String creditCardNumber;

        private String creditCardYear;

        private String creditCardMonth;
    }
}