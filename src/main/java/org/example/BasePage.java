package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage{

    //driver
    WebDriver driver=DriverFactory.getdriver();

    public void jClick(WebElement element) throws InterruptedException {
        Thread.sleep(10000);
        if(element.isDisplayed()) {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) DriverFactory.getdriver();
            javascriptExecutor.executeScript("arguments[0].click();", element);
            System.out.println("clicked : " + element);

            Actions action = new Actions(driver);
            action.click(element);
            System.out.println("Action click : " + element);



        }
        else{
            System.out.println("Disabled element : " + element);
        }
    }

    public void  waitAndClick(WebElement addCartBtn){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(addCartBtn));
        element.click();
    }

    public void scroll() throws InterruptedException {
        Thread.sleep(4000);
        JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getdriver();
        js.executeScript("window.scrollBy(0,500)");
//        js.executeScript("window.scrollBy(0,500)");
}




    /*
    public  boolean checkElementIsAvailableByXpath(String path) {
            boolean status = false;
            List<WebElement> elements = driver.findElements(By.xpath(path));
            if (elements.size() > 0) {
                status = true;
            }
            return status;
        }*/

    }
