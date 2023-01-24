package org.example;


import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class AddCart extends Navigation {

    // this section search for product
    @FindBy(xpath="//input[@class='_3704LK']")
    public WebElement search;

    @FindBy(xpath = "//button[@class='L0Z3Pu']")
    public WebElement searchBtn;

 //   @FindBy(xpath = "//div[contains(text(),'OPPO F19 Pro+ 5G (Space Silver, 128 GB)')]")
  //  public WebElement ProductList;

    @FindBy(xpath = "//div[@class = '_1YokD2 _3Mn1Gg']/div")
    public WebElement ProductList;

    @FindBy(xpath = "//ul[@class = 'row']/li[1]")
    public WebElement addCartBtn;


    @FindBy(xpath = "//span[contains(text(),'Price details')]")
    public WebElement checkCart;


    WebDriver driver;
   BasePage basePage= new BasePage();
    public AddCart() throws IOException {
        this.driver= DriverFactory.getdriver();
        PageFactory.initElements(this.driver,this);
    }

    public void searchProduct(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        search.sendKeys(P.getProperty("item"));
        searchBtn.click();


    }

    public void selectProduct() throws InterruptedException {
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        List<WebElement> l = driver.findElements(By.xpath("//div[@class='_13oc-S']"));
        l.get(4).click();

       //basePage.jClick(ProductList);

        }
    public void addToCart() throws InterruptedException {
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        basePage.scroll();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        basePage.waitAndClick(addCartBtn);


    }

    public void checkCart() throws Exception {


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String x = checkCart.getText();
        if(x.equalsIgnoreCase(P.getProperty("verify"))){
            System.out.println("[+] Product Successfully added to cart");
        }
        else{
            throw new Exception("[-] product not added to cart!");
        }


    }


}