Feature: Menu Page and it's Validation

  Background: Login to CCP Portal
    Given User is on Prima Web Master Homepage
    When USer login to the portal


  Scenario: Verifying the Menu Created
    Given User goes to Menu Section
    Then User Move to  DTT page
    And User Creates and validates the Created Menu

  Scenario: Verifying the RulePage Title
    Given User goes to Menu Section
    Then User Move to  DTT page
    And User Creates and validates RulePage Title

  Scenario: Verifying the Menu Created
    Given User goes to Menu Section
    Then User Move to  DTT page
    And User Verify Rules are successfully saved

  Scenario: Verifying the MenuGrid Title
    Given User goes to Menu Section
    And User Verify Menu Grid Screen Title

  Scenario: Verifying the RulePage Title
    Given User goes to Menu Section
    And User Verify DTT Title

  Scenario: Verifying the Edit Menu DTT Title
    Given User goes to Menu Section
    And User Copies Menu
    And validates the ScreenTitle

  Scenario: Verifying the Copy Menu Name
    Given User goes to Menu Section
    And validates The name field should display the same name as the copied menu

  Scenario: Verifying the Copy Menu Description field
    Given User goes to Menu Section
    And validates The Description field should display the same Description as the copied menu

  Scenario: Verifying the Copy Menu Service channel
    Given User goes to Menu Section
    And User Copies Menu
    And Validate Service channel should be Corrections and auto populated always

  Scenario: Verifying the Copy Menu Status field
    Given User goes to Menu Section
    And User Copies Menu
    And Validate Status Field

  Scenario: Verifying the Copy Menu fields
    Given User goes to Menu Section
    Then User Create full Menu
    And Validate the data Provided during Creation of Menu

  Scenario: Verifying the Duplicate Check while Copying Menu
    Given User goes to Menu Section
    And User Copies Menu
    And verify duplicate menu is not getting created

  Scenario: Verifying User Updates CopyMenu Name and Checks it
    Given User goes to Menu Section
    And User Copies Menu
    And verify User Updates the MenuName and Check it

  
  Scenario: Verifying User Updates CopyMenu Name and Checks it
    Given User goes to Menu Section
    And User Copies Menu
    And verify User Updates the MenuName and Check it
    Then Create New Menu With it and Swap Recipies
  