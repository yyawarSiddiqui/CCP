Feature: IBA and its Validation
 
 Background: Login to CCP Portal 	
  Given User is on Prima Web Master Homepage
  When USer login to the portal

  
  
   Scenario: Verifying the IBA Page
  Given User goes to IBA Section
  Then Validate Navigation and UI on IBA Page
  
  

   Scenario: Verifying the IBA Page
  Given User goes to IBA Section
  Then Validate General Item Search Functionality
  
  
   Scenario: Verifying the IBA Page
  Given User goes to IBA Section
  Then Validate Menu lIst Items on RHS
  
  
  @test
  Scenario: Verifying the IBA Page
  Given User goes to IBA Section
  Then User is able to search menu by Search By Menu Name/Distribution/Notes
  