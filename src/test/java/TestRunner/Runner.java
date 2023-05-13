package TestRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Features/Test.feature", //runner
        glue = {"Stepdefinitions", "ApplicationHooks"},
        plugin = {"pretty","html:target/cucumber-reports.html","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        tags = "@smoke",
        monochrome = true,
        dryRun = false
)

public class Runner{

}