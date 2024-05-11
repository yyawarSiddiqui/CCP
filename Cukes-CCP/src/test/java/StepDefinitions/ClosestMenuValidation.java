package StepDefinitions;

import static utils.ExtentReport.startTest;

import org.openqa.selenium.WebDriver;
import PageObjects.ClosestMenuObj;
import PageObjects.DefineTheTarget;
import io.cucumber.java.en.Then;

public class ClosestMenuValidation {

	DefineTheTarget  defineTheTarget;
	ClosestMenuObj closestMenuObj;
	private WebDriver driver;
	
	 public ClosestMenuValidation() {
	        this.driver = TestBase.getDriver();
	    }
	
	 
	 @Then("User Creates the menu and Moves to Closest Menu")
	 public void user_creates_the_menu_and_moves_to_closest_menu() {
	     
		 TestBase.Logger = startTest("User Verify CLosestMenuPageTitle ", "Validate the Screen Title");
			
		 closestMenuObj =new ClosestMenuObj(driver);
		 TestBase.result("Verify closest Menu" , closestMenuObj.GetCLosestMenuPageTitle());
			
	 }
	 
	 
	 @Then("User Creates the menu and Check list of filters on Closest Menu screen")
	 public void user_creates_the_menu_and_check_list_of_filters_on_closest_menu_screen() {
	  
		 TestBase.Logger = startTest("User Verify Filter on Closest Menu ", "Validate the Filter and CLosestMenu");
			
		 closestMenuObj =new ClosestMenuObj(driver);
			 TestBase.result("Check ClosestMenu Filters" , closestMenuObj.VerifyClosestMenuPageFilter());
	 }
	 
	 
	 @Then("User Verify Filters are reset to there default filters")
	 public void user_verify_filters_are_reset_to_there_default_filters() {
	    
			
		 TestBase.Logger = startTest(" Check after clicking on 'Reset' button all the filters should get cleared and enabled ", "Validate the Reset Filter");
		 closestMenuObj =new ClosestMenuObj(driver);
			 TestBase.result("Check Functionality of Resest Filters" , closestMenuObj.Verify_Filters_are_reset_to_there_default_filters());
	 }
	 
	 @Then("User Verify  Search button functionality")
	 public void user_verify_search_button_functionality() {
	  
		 TestBase.Logger = startTest(" Check Functionality of Search Buttons  ", "Validate the Search button functionality");
		 closestMenuObj =new ClosestMenuObj(driver);
			 TestBase.result("Check Functionality of Search Filter" , closestMenuObj.Verify_Search_Filter_Result());
	 }
	 
	 @Then("User Verify CLosestMenu CopyFunctionality")
	 public void user_verify_c_losest_menu_copy_functionality() {
	    
		 TestBase.Logger = startTest(" Check ClosestMenu Copy Function ", "Validate the Copy Menu functionality");
		 closestMenuObj =new ClosestMenuObj(driver);
			 TestBase.result("Check User is able to Copy Closest Menu" , closestMenuObj.Verify_CLosestMenu_CopyFunctionality());
	 }

	 
	 

}
