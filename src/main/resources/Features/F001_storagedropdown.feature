Feature: Hover on “Storage”.

  Scenario: Verify that User can add products to the cart successfully
    Given User go to home page
    When User hover on "Storage"
    Then dropdown menu appears and including "Kitchen Storage" subcategory
    When User click on “Kitchen Storage” and choose two products and add them to cart
    And User open the cart preview
    Then Compare every product’s name and price in the cart with product details and check that the total price in the cart is calculated correctly.

