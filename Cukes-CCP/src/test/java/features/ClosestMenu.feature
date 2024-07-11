Feature: Closest MenuPage and its Validation

  Background: Login to CCP Portal
    Given User is on Prima Web Master Homepage
    When USer login to the portal

  Scenario: Verifying the ClosestMenu Page
    Given User goes to Menu Section
    Then User Move to  DTT page
    Then User Creates the menu and Moves to Closest Menu

  Scenario: Verifying the ClosestMenu Page
    Given User goes to Menu Section
    Then User Move to  DTT page
    Then User Creates the menu and Check list of filters on Closest Menu screen

  Scenario: Verifying the ClosestMenu Page
    Given User goes to Menu Section
    Then User Move to  DTT page
    Then User Verify Filters are reset to there default filters

  Scenario: Verifying the ClosestMenu Page
    Given User goes to Menu Section
    Then User Move to  DTT page
    Then User Verify  Search button functionality

  Scenario: Verifying the ClosestMenu Page
    Given User goes to Menu Section
    Then User Move to  DTT page
    Then User Verify CLosestMenu CopyFunctionality

  Scenario: Verifying the ClosestMenu Page
    Given User goes to Menu Section
    Then User Move to  DTT page
    Then User Verify after creating new menu from the Closest menu screen , after editing targets and Menu name it is getting updated

  Scenario: Verifying the ClosestMenu Page
    Given User goes to Menu Section
    Then User Move to  DTT page
    Then User Verify the closest Menu pagination Functionality

  Scenario: Verifying the ClosestMenu Page
    Given User goes to Menu Section
    Then User Move to  DTT page
    Then User Verify  Search button functionality
    Then User Verify Summary Report open in new tab

  @test
  Scenario: Verifying the ClosestMenu Page
    Given User goes to Menu Section
    Then User Move to  DTT page
    Then User Verify  CasseroleSearch button functionality
