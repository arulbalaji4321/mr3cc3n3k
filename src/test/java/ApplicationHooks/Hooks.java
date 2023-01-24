package ApplicationHooks;


import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.example.DriverFactory;
import org.example.reader;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class Hooks extends reader {

    WebDriver driver;
    Properties P = reader();

    public Hooks() throws IOException {
    }

    @Before
    public void start(){
        String browserName = P.getProperty("browser");
        System.out.println("Browser Name: "+browserName+" Started.");
        DriverFactory driverFactory = new DriverFactory();
        driver = driverFactory.driver_init(browserName);
        driver.manage().window().maximize();
    }


    @AfterStep
    public void addScreenshot(Scenario scenario) throws IOException, InterruptedException {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        byte[] file = FileUtils.readFileToByteArray(screenshot);
        scenario.attach(file, "image/png", "");
    }




    @After
    public void stop(){
          driver.quit();
    }


}