Feature: MenuReview Page and it's Validation

  Background: Login to CCP Portal
    Given User is on Prima Web Master Homepage
    When USer login to the portal

  Scenario: Verifying the RegionName Column
    Given User goes to Menu Review Section
    Then User Verify Region Name column


  Scenario: Verifying the RegionName and updates it
    Given User goes to Menu Review Section
    Then User Verify Region Name column
    Then User Update Region Name and Verify


  
