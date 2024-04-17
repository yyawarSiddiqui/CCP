package StepDefinitions;

import org.openqa.selenium.WebDriver;
import PageObjects.CCPMenu;
import PageObjects.DefineTheTarget;
import PageObjects.Modules;
import PageObjects.TraditionalMenu;
import PageObjects.loginpage;
import io.cucumber.java.en.*;
import static utils.ExtentReport.*;



public class Menus_Validation {	
	loginpage login ;
	Modules modules;
	CCPMenu ccpmenu;
	TraditionalMenu traditionalMenu;
	DefineTheTarget definethetarget;
	
	
 private WebDriver driver;
	
	 public Menus_Validation() {
	        this.driver = TestBase.getDriver();
	    }
	 
	 
	 @Then("User Creates and validates the Created Menu")
	 public void user_creates_and_validates_the_created_menu() {
		 traditionalMenu=new TraditionalMenu(driver);
		 traditionalMenu.Validate_Menucreated();
		
	 }
	 
	 
	 @Then("User Creates and validates RulePage Title")
	 public void user_creates_and_validates_rule_page_title() {
		 traditionalMenu=new TraditionalMenu(driver);
		 TestBase.result("Validate Rules page displayed ",  traditionalMenu.Validate_RulePage_Title());
		
	 }
	 
	 @Then("User Verify Rules are successfully saved")
	 public void user_verify_rules_are_successfully_saved() {
		 traditionalMenu=new TraditionalMenu(driver);
		 TestBase.result("Validate Rules are saved",   traditionalMenu.Validate_rules_are_saved());
		
	 }
	 
	 @Then("User Verify Menu Grid Screen Title")
	 public void user_verify_menu_grid_screen_Title() throws InterruptedException {
		 traditionalMenu=new TraditionalMenu(driver);
		TestBase.result("Validate Menu Grid Screen is Displayed", traditionalMenu.Validate_EditMenu_Title()); 
	 }
	 
	 @Given("User Verify RulePage Screen Title")
	 public void user_verify_rule_page_screen_title()  {
		 traditionalMenu=new TraditionalMenu(driver);
		 TestBase.result("Validate Menu Grid Screen is Displayed", traditionalMenu.Validate_EditRules_Page()); 
			
	 }
	
}
