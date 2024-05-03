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
	 
	 

}
