package StepDefinitions;

import static utils.ExtentReport.startTest;

import org.json.JSONObject;
import org.openqa.selenium.WebDriver;

import PageObjects.CCPMenu;
import PageObjects.DefineTheTarget;
import PageObjects.IBAobj;
import PageObjects.MenuGrid;
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
	MenuGrid menuGrid;
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

	@Then("User is able to search menu by Search By Menu Name\\/Distribution\\/Notes")
	public void user_is_able_to_search_menu_by_search_by_menu_name_distribution_notes() {

		TestBase.Logger = startTest("User goes to Ingredient Based Analysis page and Validate  ", "Validate the different field validation");
		ibaobj=new IBAobj(driver);
		TestBase.result("Validate Search filter on RHS" , ibaobj.VerifyMenuSearchIBA());

	}


	@Then("User is able to Check Pagination Functionality")
	public void user_is_able_to_check_pagination_functionality() {

		TestBase.Logger = startTest("User goes to Ingredient Based Analysis page and Check Pagination Functionality ", "Validate the different field validation");
		ibaobj=new IBAobj(driver);
		TestBase.result("Validate Pagination on MenuIBA" , ibaobj.Check_PaginationFunctionalityIBA());
	}

	@Then("User Checks the Export IBA and Its data")
	public void user_checks_the_export_iba_and_its_data() throws InterruptedException {


		TestBase.Logger = startTest("User goes to Ingredient Based Analysis page and Check Export Data", "Validate the different field validation");
		ibaobj=new IBAobj(driver);
		TestBase.result("Validate Export File data  on MenuIBA" , ibaobj.CheckExportTableData());
	}

	@Then("Total occurrences in descending order")
	public void total_occurrences_in_descending_order() {

		TestBase.Logger = startTest("User goes to Ingredient Based Analysis page and Check TotalOccurence order", "Validate the different field validation");
		ibaobj=new IBAobj(driver);
		TestBase.result("Validate Export File data  on MenuIBA" , ibaobj.TotalOccurenceOrder());
	}

	@Then("User Verify the GI Overview Table")
	public void user_verify_the_gi_overview_table() {

		TestBase.Logger = startTest("User goes to Ingredient Based Analysis page and Check GI Recipies ", "Validate the different field validation");
		ibaobj=new IBAobj(driver);
		TestBase.result("Validate Export File data  on MenuIBA" , ibaobj.Verify_GI_For_IBA_on_Menurgrid());

	}


	@Then("User Verify  Substitute item should not get displayed as GI under GI tab")
	public void user_verify_substitute_item_should_not_get_displayed_as_gi_under_gi_tab() {

		TestBase.Logger = startTest("User goes to Ingredient Based Analysis page and Check GI Recipies ", "Validate the different field validation");
		ibaobj=new IBAobj(driver);
		TestBase.result("Validate Substitute item should not get displayed as GI under GI tab" , ibaobj.VerifySubstituteItem());

	}

	@Then("User Swap Recipe manually and recommended")
	public void user_swap_recipe_manually_and_recommended() {
		TestBase.Logger = startTest("User goes to Ingredient Based Analysis page and Swap Recipies ", "Validate the Recipe Swap Functionality");
		ibaobj=new IBAobj(driver);
		TestBase.result("Validate User Swap Recipe manually and recommended method" , ibaobj.SwapRecipe());

	}

	@Then("User Update IBA Region Name and Verify")
	public void user_update_iba_region_name_and_verify() {

		TestBase.Logger = startTest("User goes to Ingredient Based Analysis page and Swap Recipies ", "Validate the Recipe Swap Functionality");
		ibaobj=new IBAobj(driver);
		TestBase.result("Validate User Swap Recipe manually and recommended method" , ibaobj.validateRegionNameandVerify());

	}


}
