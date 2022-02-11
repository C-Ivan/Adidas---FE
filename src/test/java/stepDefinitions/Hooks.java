package stepDefinitions;

import com.google.common.io.Files;
import cucumber.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;


public class Hooks {

    TestContext testContext;

    public Hooks(TestContext context) {
        testContext = context;
    }

    @Before
    public void BeforeSteps() {
        testContext.getPageObjectManager().getHomePage().navigate();
    }

    @After(order = 1)
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            try {
                //This takes a screenshot from the driver and save it to the specified location
                File sourcePath = ((TakesScreenshot) testContext.getWDriverManager().getDriver()).getScreenshotAs(OutputType.FILE);

                //Destination path for the screenshot
                File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/" + screenshotName + ".png");

                //Copy taken screenshot from source location to destination location
                Files.copy(sourcePath, destinationPath);

            }
            catch (IOException e) {
                System.out.println(e);
            }
        }
    }


    @After(order = 0)
    public void AfterSteps() {
        testContext.getWDriverManager().closeDriver();
    }

}