package pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import selenium.Wait;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void navigate() {
        if (!driver.getCurrentUrl().contains("https://www.demoblaze.com/index.html")) {
            driver.get("https://www.demoblaze.com/index.html");
        }
    }

    @FindBy(linkText = "Phones")
    private WebElement phoneCategory;

    @FindBy(linkText = "Laptops")
    private WebElement laptopCategory;

    @FindBy(linkText = "Monitors")
    private WebElement monitorCategory;

    @FindBy(linkText = "Apple monitor 24")
    private WebElement monitorApple24;

    @FindBy(linkText = "Dell i7 8gb")
    private WebElement laptopDelli7;

    @FindBy(linkText = "Sony vaio i5")
    private WebElement laptopSonyVaioi5;

    @FindBy(linkText = "Samsung galaxy s7")
    private WebElement phoneSamsungGalaxyS7;

    @FindBy(linkText = "Nexus 6")
    private WebElement phoneNexus6;

    @FindBy(className = "btn-success")
    private WebElement btnAddToCart;


    public boolean isAppleMonitor24Displayed() {
        return isDisplayed(monitorApple24);
    }

    public boolean isLaptopSonyVaioi5Displayed() {
        return isDisplayed(laptopSonyVaioi5);
    }

    public boolean isPhoneSamsungGalaxyS7Displayed() {
        return isDisplayed(phoneSamsungGalaxyS7);
    }

    public boolean isPhoneNexus6Displayed() {
        return isDisplayed(phoneNexus6);
    }

    public void clickOn_Category(String category) {
        clickElement(driver.findElement(By.xpath("//a[text()='" + category + "']")));
    }

    public void clickOn_Item(String item) {
        clickElement(driver.findElement(By.xpath("//a[text()='" + item + "']")));
    }

    public void clickOn_addToCartBtn() {
        clickElement(btnAddToCart);
    }

    public void addItemToCart(String item) {
        try {
            clickOn_Item(item);
            clickOn_addToCartBtn();
            acceptAlert();
        } catch (org.openqa.selenium.StaleElementReferenceException ignore) {
            Wait.untilJqueryIsDone(driver, 5L);
            clickOn_Item(item);
            clickOn_addToCartBtn();
            acceptAlert();
        }
    }
}
