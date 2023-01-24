
Feature: Login Functionality of Flipkart
  @smoke
  Scenario: verification of login functionality of flipkart
    Given launch Flipkart homepage
    When Click login button
    And enter mobile no and password
    And click login
    Then user should login into my account page
    When search product
    And  select a product
    And  Add it to cart
    Then product should be added in cart



