package StepDefinitions;

import org.openqa.selenium.WebDriver;
import PageObjects.CCPMenu;
import PageObjects.DefineTheTarget;
import PageObjects.Modules;
import PageObjects.TraditionalMenu;
import PageObjects.loginpage;
import io.cucumber.java.en.*;



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
	 
	 @And("User Verify RulePage Screen Title")
	 public void user_verify_rule_page_screen_title()  {
		 traditionalMenu=new TraditionalMenu(driver);
		 TestBase.result("Validate Menu Grid Screen is Displayed", traditionalMenu.Validate_EditRules_Page()); 
			
	 }
	 
	 
	 @Given("User Copies Menu")
	 public void user_copies_menu() throws InterruptedException {
		 
		 traditionalMenu=new TraditionalMenu(driver);
		 TestBase.result("Validate DTT screen should get displayed for Copy Menu", traditionalMenu.User_Move_to_EditDTT()); 
	 }
	 
	 
	 @And("validates The name field should display the same name as the copied menu")
	 public void validates_the_name_field_should_display_the_same_name_as_the_copied_menu() {
	  
		 traditionalMenu=new TraditionalMenu(driver);
		 TestBase.result("validates The name field should display the same name as the copied menu", traditionalMenu.User_Validates_Copied_Menu_Name()); 
	 }
	 
	 @And("validates The Description field should display the same Description as the copied menu")
	 public void validates_the_description_field_should_display_the_same_description_as_the_copied_menu()  {
	     
		 traditionalMenu=new TraditionalMenu(driver);
		 try {
			TestBase.result("validates The Description field should display the same Description as the copied menu", traditionalMenu.User_Validates_Copied_Description_Name());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	 
	 }
	 
	 @Given("Validate Status Field")
	 public void validate_status_field() {
	     
		 traditionalMenu=new TraditionalMenu(driver);
		 TestBase.result("validates Status Field on the Opened copied menu", traditionalMenu.User_validate_Status_on_Copymenu()); 
	 
	 }
	
	 @Then("User Create full Menu")
	 public void user_create_full_menu() throws InterruptedException {
		 
		  definethetarget=new DefineTheTarget(driver);
		 TestBase.result("validates User Creates Full Menu", definethetarget.Create_Menu_allFields());
	 }
	 
	 
	 @Then("Validate the data Provided during Creation of Menu")
	 public void validate_the_data_provided_during_creation_of_menu()  {
		 
		 traditionalMenu=new TraditionalMenu(driver);
		 TestBase.result("validates the data Provided during Creation of Menu is Same in Copy Menu", traditionalMenu.User_validate_Fields_on_Copymenu());
		 
	     
	 }
}
