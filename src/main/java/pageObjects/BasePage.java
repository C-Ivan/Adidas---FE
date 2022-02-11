package pageObjects;


import org.openqa.selenium.Alert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitForClickability(WebElement e, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.elementToBeClickable(e));
    }

    public void waitForVisibility(WebElement e, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOf(e));
    }

    public void clickElement(WebElement e, int seconds) {
        waitForClickability(e, seconds);
        e.click();
    }

    public void clickElement(WebElement e) {
        clickElement(e, 10);
    }

    public void inputKeys(WebElement e, int seconds, String value) {
        waitForVisibility(e, seconds);
        e.sendKeys(value);
    }

    public void inputKeys(WebElement e, String value) {
        inputKeys(e, 10, value);
    }

    public boolean isDisplayed(WebElement e) {
        boolean isDisplayed;
        try {
            isDisplayed = e.isDisplayed();
        } catch (NoSuchElementException ignore) {
            isDisplayed = false;
        }
        return isDisplayed;
    }

    public void acceptAlert(int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void acceptAlert() {
        acceptAlert(10);
    }

    public abstract void navigate();

}
