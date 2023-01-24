package Stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.AddCart;
import org.example.Navigation;

import java.io.IOException;

public class Steps {

    Navigation nav = new Navigation();
    AddCart addCart = new AddCart();



    public Steps() throws IOException {
    }

    @Given("launch Flipkart homepage")
    public void launch_flipkart_homepage() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        nav.gotoFlipkart();

    }
    @When("Click login button")
    public void click_login_button() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        nav.closeAlert();
        Thread.sleep(3000);
        nav.clickLoginBtn();
        System.out.println("login");
    }
    @When("enter mobile no and password")
    public void enter_mobile_no_and_password() {
        // Write code here that turns the phrase above into concrete actions
        nav.fillCred();
    }
    @When("click login")
    public void click_login() {
        // Write code here that turns the phrase above into concrete actions
        nav.clickLoginBtn2();

    }
    @Then("user should login into my account page")
    public void user_should_login_into_my_account_page() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        nav.checkLogin();

    }

    @When("search product")
    public void search_product() {
        // Write code here that turns the phrase above into concrete actions
        addCart.searchProduct();
    }
    @When("select a product")
    public void select_a_product() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        addCart.selectProduct();

    }
    @When("Add it to cart")
    public void add_it_to_cart() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        addCart.addToCart();

    }
    @Then("product should be added in cart")
    public void product_should_be_added_in_cart() throws Exception {
        // Write code here that turns the phrase above into concrete actions
         addCart.checkCart();
    }





}