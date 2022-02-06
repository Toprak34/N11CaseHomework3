Feature: N11 Test Automation

  Scenario: Search products and list free shipping
    Given User go to n11 home page and search "telefon"
    When User sort by comments and select to free shipping filter
