package StepDefinitions;

import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import PageObjects.CCPMenu;
import PageObjects.DefineTheTarget;
import PageObjects.Modules;
import PageObjects.TraditionalMenu;
import PageObjects.loginpage;
import io.cucumber.java.en.*;
import static utils.ExtentReport.*;



public class DTTVAlidation {	
	loginpage login ;
	Modules modules;
	CCPMenu ccpmenu;
	TraditionalMenu traditionalMenu;
	DefineTheTarget definethetarget;
	 public JSONObject Value;
	
 private WebDriver driver;
	
	 public DTTVAlidation() {
	        this.driver = TestBase.getDriver();
	    }
	 

	@Given("User is on Prima Web Master Homepage")
	public void user_is_on_prima_web_master_homepage()  {
		TestBase.Logger = startTest("Login to Portal ", "User login to ccp "); 
		
		
	}
	@When("USer login to the portal")
	public void u_ser_login_to_the_portal() throws InterruptedException  {
		
		login=new loginpage(driver);
		TestBase.result("Click on login" , login.click());
		
		
	}
	@Then("User goes to Menu Section")
	public void user_goes_to_menu_section() throws InterruptedException {
		
		TestBase.Logger = startTest("User goes to DTT page ", "Validate the different field validation");
		
		modules=new Modules(driver);
		TestBase.result("Click on Menu" , modules.clickonMenu());
		
		ccpmenu =new CCPMenu(driver);
		TestBase.result("Click on MenuOption" , ccpmenu.clickonMenuOption());
		
	}
	
	@Then("User Move to  DTT page")
	public void user_move_to_dtt_page() {
		traditionalMenu=new TraditionalMenu(driver);
		TestBase.result("Click on ADD", traditionalMenu.clickonAdd());	
	}
	
	@And("validates the ScreenTitle")
	public void validates_the_screen_title()   {

		definethetarget=new DefineTheTarget(driver);
		TestBase.result("Verify the DTTPage_Title" , definethetarget.VerifyDTTScreenVisibility());	
		
	}
	
	@And("Validate Name is Required field")
	public void validate_name_is_required_field() throws InterruptedException {
        
		definethetarget=new DefineTheTarget(driver);
		TestBase.result("Should show message as Fields marked with * are required" , definethetarget.validate_Name_Field());
		
	}
	
	@And("Validate MealPeriod is Required field")
	public void validate_meal_period_is_required_field() throws InterruptedException {
	    
		definethetarget=new DefineTheTarget(driver);
	TestBase.result("Should show message as Fields marked with * are required", definethetarget.Validate_Meal_Period());	
		
	}
	@And("Validate RDAtype is Required field")
	public void validate_rd_atype_is_required_field() throws InterruptedException {
	   
		definethetarget=new DefineTheTarget(driver);
		TestBase.result("Should show message as Fields marked with * are required", definethetarget.Validate_RDAType());
	}
	@And("Validate Description is Non-MAndatory field")
	public void validate_description_is_non_m_andatory_field() throws InterruptedException {
		definethetarget=new DefineTheTarget(driver);
	TestBase.result("Should show Message : Menu created Successfully", definethetarget.Validate_Description());	
		
	}
	
	@And("Validate Name field should accept only Hundered characters")
	public void validate_name_field_should_accept_only_hundered_characters() throws InterruptedException {
	   
		definethetarget=new DefineTheTarget(driver);
	TestBase.result("Name field should accept only 100 characters", definethetarget.Validate_NameFIeld_Limit());	
	}
	
	@And("Validate Service channel should be Corrections and auto populated always")
	public void validate_service_channel_should_be_corrections_and_auto_populated_always() {
	   
		definethetarget=new DefineTheTarget(driver);
		TestBase.result("Service channel should be Corrections and auto populated ", definethetarget.Service_Channel_Validation());
		
	}
	
	@And("Validate Calorie Level Functionality")
	public void validate_calorie_level_functionality() {
	   
		definethetarget=new DefineTheTarget(driver);
		definethetarget.Verify_Calorie_Level();
		
	}
	
	@Then("Verify the functionality of the Status dropdown")
	public void verify_the_functionality_of_the_status_dropdown() {
	    
		definethetarget=new DefineTheTarget(driver);
		TestBase.result("Validate the functionality of the Status dropdown" , definethetarget.User_validate_Status_on_DTT());
		
	}
	
	@Then("Verify the functionality of the Number of Cycle Weeks dropdown")
	public void verify_the_functionality_of_the_number_of_cycle_weeks_dropdown() {
		
		definethetarget=new DefineTheTarget(driver);
		TestBase.result("Validate the functionality Number of Cycle Weeks dropdown" , definethetarget.User_Validate_the_functionality_of_the_Number_of_Cycle_Weeks_dropdown());
		
	}



	
	
}
