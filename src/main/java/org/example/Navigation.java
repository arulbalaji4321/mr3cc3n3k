package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.Properties;

public class Navigation extends reader {

    WebDriver driver;
    Properties P = reader();

    public Navigation() throws IOException {
        driver=DriverFactory.getdriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[@class ='_2KpZ6l _2doB4z']")
    public WebElement btn1;

    @FindBy(xpath = "//a[@class = '_1_3w1N']")
    public WebElement loginBtn;

    // this section is for filling credential
    @FindBy(xpath = "//input[@class = '_2IX_2- VJZDxU']")
    public WebElement mobile;

    @FindBy(xpath = "//input[@class = '_2IX_2- _3mctLh VJZDxU']")
    public WebElement pass;

    //this section is for clicking login btn

    @FindBy(xpath = "//button[@class = '_2KpZ6l _2HKlqd _3AWRsL']")
    public WebElement LoginBtn2;

    //this section is to check whether user login inside user profile

    @FindBy(xpath = "//div[@class = 'exehdJ']")
    public WebElement checker;




    public  void gotoFlipkart() throws InterruptedException {
        driver.get(P.getProperty("url"));
        System.out.println(P.getProperty("url"));
        Thread.sleep(3000);

    }

    public void closeAlert(){

        btn1.click();
    }

    public void clickLoginBtn(){
        loginBtn.click();
    }

    public void fillCred(){

        try {
            System.out.println(mobile);
            mobile.sendKeys(P.getProperty("mobile"));
            pass.sendKeys(P.getProperty("password"));

        }
        catch(Exception e ){
            System.out.println(e);
            System.out.println("otp validation feature cannot be automated");

        }
    }

    public void clickLoginBtn2(){
        LoginBtn2.click();
    }

    public void checkLogin() throws Exception {
        Thread.sleep(3000);
        String x = checker.getText();
        System.out.println(x);
        try {
            if (x.equalsIgnoreCase(P.getProperty("confirmLogin"))) {
                System.out.println("[*] Login successful!");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }



}