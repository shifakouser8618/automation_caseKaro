CaseKaro Test Automation 

Automated end-to-end BDD test suite for [casekaro.com](https://casekaro.com) using Java, Playwright, Cucumber and TestNG.

Tech Stack
- Java 17
- Playwright 1.44.0
- Cucumber 7.14.0 (BDD)
- TestNG 7.9.0
- Maven

Project Structure


automation_caseKaro/
├── src/
│   └── test/
│       ├── java/
│       │   ├── pages/
│       │   │   ├── HomePage.java
│       │   │   ├── SearchPage.java
│       │   │   ├── ProductPage.java
│       │   │   └── CartPage.java
│       │   ├── stepdefs/
│       │   │   └── CaseKaroSteps.java
│       │   └── runner/
│       │       └── TestRunner.java
│       └── resources/
│           └── features/
│               └── casekaro.feature
├── pom.xml
├── testng.xml
└── README.md

 Test Scenarios 

  1.  Navigate to casekaro.com 
  2. Click on Mobile Covers 
  3.  Search for Apple brand 
  4. Negative validation - other brands not visible 
  5.  Navigate to iPhone 16 Pro collection 
  6.  Open first product page 
  7. Add Hard, Soft and Glass materials to cart 
  8.  Open cart 
  9.  Validate all 3 items are in cart 
 10.  Print item details to console 

 How to Run

 Prerequisites
- Java 17 or above
- Maven installed

Clone the project
--bash
git clone https://github.com/shifakouser8618/automation_caseKaro.git
cd automation_caseKaro


Install Playwright browsers
--bash
mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="install chromium"


Run the tests
--bash
mvn clean test


Feature File (BDD)
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


 Author
Name:Shifa Kouser
