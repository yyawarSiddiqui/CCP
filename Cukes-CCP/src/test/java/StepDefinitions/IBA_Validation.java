package StepDefinitions;

import static utils.ExtentReport.startTest;

import org.json.JSONObject;
import org.openqa.selenium.WebDriver;

import PageObjects.CCPMenu;
import PageObjects.DefineTheTarget;
import PageObjects.IBAobj;
import PageObjects.Modules;
import PageObjects.TraditionalMenu;
import PageObjects.loginpage;
import io.cucumber.java.en.*;

public class IBA_Validation {



	loginpage login ;
	Modules modules;
	CCPMenu ccpmenu;
	TraditionalMenu traditionalMenu;
	DefineTheTarget definethetarget;
	IBAobj ibaobj;
	public JSONObject Value;

	private WebDriver driver;

	public IBA_Validation() {
		this.driver = TestBase.getDriver();
	}



	@Given("User goes to IBA Section")
	public void user_goes_iba_section() {

		TestBase.Logger = startTest("User goes to Ingredient Based Analysis page ", "User Moves to IBA Page");

		modules=new Modules(driver);
		TestBase.result("Click on Menu" , modules.clickonMenu());

		ccpmenu =new CCPMenu(driver);
		TestBase.result("Click on MenuAnalysis" , ccpmenu.clickonMenuAnalysis());


		TestBase.result("Click on IBA" , ccpmenu.clickonIBA());

	}


	@Then("Validate Navigation and UI on IBA Page")
	public void validate_navigation_and_ui_on_iba_page() {

		TestBase.Logger = startTest("User goes to Ingredient Based Analysis page ", "Validate the different field validation");
		ibaobj=new IBAobj(driver);
		TestBase.result("Validate UI and title of IBA" , ibaobj.ValidateUI_IBA());

	}

	@Then("Validate General Item Search Functionality")
	public void validate_general_item_search_functionality() {

		TestBase.Logger = startTest("User Validate Ingredient Based Analysis Search GI Funtionality", "Validate the General Item (GI) Search");
		ibaobj=new IBAobj(driver);
		TestBase.result("Validate General Item Search Filter" , ibaobj.GISerchFilter());
	}

	@Then("Validate Menu lIst Items on RHS")
	public void validate_menu_l_ist_items_on_rhs() {


		TestBase.Logger = startTest("User goes to Ingredient Based Analysis page ", "Validate the different field validation");
		ibaobj=new IBAobj(driver);
		TestBase.result("Validate Menu List Search on Right hand Panel" , ibaobj.VerifyStatusDropDownFunctionality());
	}

}
