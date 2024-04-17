
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
  And  User Verify Rules are successfully saved
  

  Scenario: Verifying the MenuGrid Title
  Given User goes to Menu Section  
  And  User Verify Menu Grid Screen Title
  
  
    @test
  Scenario: Verifying the RulePage Title
  Given User goes to Menu Section  
  And  User Verify RulePage Screen Title