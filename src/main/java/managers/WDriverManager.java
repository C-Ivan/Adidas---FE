package managers;

import enums.DriverType;
import enums.EnvironmentType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import java.time.Duration;

public class WDriverManager {
    private WebDriver driver;
    private static DriverType driverType;
    private static EnvironmentType environmentType;

    public WDriverManager() {
        driverType = FileReaderManager.getInstance().getConfigFileReader().getBrowser();
        environmentType = FileReaderManager.getInstance().getConfigFileReader().getEnvironment();
    }

    public WebDriver getDriver() {
        if (driver == null) driver = createDriver();
        return driver;
    }

    private WebDriver createDriver() {
        switch (environmentType) {
            case LOCAL:
                driver = createLocalDriver();
                break;
            case REMOTE:
                driver = createRemoteDriver();
                break;
        }
        return driver;
    }

    private WebDriver createRemoteDriver() {
        throw new RuntimeException("RemoteWebDriver is not yet implemented");
    }

    private WebDriver createLocalDriver() {
        switch (driverType) {
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case CHROME:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case INTERNETEXPLORER:
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
            case EDGE:
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case SAFARI:
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
                break;
            case OPERA:
                WebDriverManager.operadriver().setup();
                driver = new OperaDriver();
                break;
        }

        if (FileReaderManager.getInstance().getConfigFileReader().getBrowserWindowSize())
            driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(FileReaderManager.getInstance().getConfigFileReader().getImplicitlyWait()));
        return driver;
    }

    public void closeDriver() {
        if (driverType == DriverType.FIREFOX) {
            driver.close();
        } else {
            driver.close();
            driver.quit();
        }
    }
}
