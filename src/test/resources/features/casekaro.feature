Feature: CaseKaro Shopping Flow

  Scenario: Add all 3 materials to cart for iPhone 16 Pro
    Given User navigates to CaseKaro website
    When User clicks on Mobile Covers
    And User searches for "Apple"
    Then Other brands should not be visible in search results
    When User navigates to iPhone 16 Pro collection
    And User opens the first product page
    And User adds Hard material to cart
    And User adds Soft material to cart
    And User adds Glass material to cart
    When User opens the cart
    Then Cart should contain all 3 materials
    And User prints all cart item details