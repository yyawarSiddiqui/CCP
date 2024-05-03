Feature: Closest MenuPage and its Validation
 
 Background: Login to CCP Portal 	
  Given User is on Prima Web Master Homepage
  When USer login to the portal


   @test
   Scenario: Verifying the ClosestMenu Page
  Given User goes to Menu Section
  Then User Move to  DTT page 
  Then User Creates the menu and Moves to Closest Menu
  
  
  @test
   Scenario: Verifying the ClosestMenu Page
  Given User goes to Menu Section
  Then User Move to  DTT page 
  Then  User Creates the menu and Check list of filters on Closest Menu screen
  
  
