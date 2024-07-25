package PageObjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import StepDefinitions.TestBase;

public class MenuGrid extends TestBase {
	DefineTheTarget dtt;
	Rules rules;
	IBAobj iBAobj;
	public  WebDriver driver;

	public MenuGrid(WebDriver driver) {

		this.driver=driver;

	}

	private static final String Recipe="//div[@class='recipe-card w-full row-flex']";
	private static final String Meal_Period="(//select)[2]";
	private static final String Days_Selected="//span[@id='react-select-9--value-0']//div[text()='All']";
	private static final String Week_Selected="	//span[@id='react-select-8--value-0' and text()='1']";
	private static final String KPI_Arrow_Down= "//div[@class='top-side-arrow']//i[@class='side-btn fa fa-angle-double-down radius-c']";
	private static final String KPI_Values="//div[@class='card']/*//b";
	private static final String Target_Cycle_Value="(//div//p)[3]";
	private static final String Target_Values="//div[@class='details dash']//p//span";
	private static final String KPI_Arrow_Right= "//div[@class='sidebar-right-arrow']//i[@class='side-btn fas fa-angle-double-left radius-c']";
	private static final String GI_OverviewButton="//ul//li//a[text()='GI Overview']";
	private static final String GIHeading="//div[@id='IBA']//strong";
	private static final String GIRecipiesTable="//div[@id='IBA']//table";
	private static final String GIRecipiesTable_HeaderValues="//div[@id='IBA']//table//th//span";
	private static final String ListOfWeek="//div[@id='IBA']//tbody//tr//td[1]";
	private static final String Add_Recipe_Monday="//div[@class='week-top mb-1 d-flex justify-content-between pl-2 pr-3']//div[text()='Monday']/following-sibling::*//div/..";
	private static final String ADDRecipeButton="//button[@type='submit' and text()='Add']";
	private static final String InputRecipe="//input[@id='focus-input' and @placeholder='Search by id']";
	private static final String loader="//span[@class='pwm-spinner-message']//span[text()='Loading Recipes...']";
	private static final String SaveAddedRecipe="//button[@type='button']//span[text()='Save']";
	private static final String LoaderOnSave="//div[@class='pwm-spinner-content']";
	private static final String Loadermenu="//span[@class='pwm-spinner-message']//span[text()='Loading Menu Items...']";
	private static final String MenuInsights="//li//a[contains(text(),'Menu Insights')]";
	private static final String GIName="//div[@id='generalItems']//table//tr//td[2]";
	private static final String KpiArrowLeft="//div[@class='left-side-arrow']";
	private static final String Dots_3="//i[@role='button' and @data-toggle='dropdown']";
	private static final String Add_Station="(//i[@class='fa fa-plus ml-1']/following::*)[1]";
	private static final String from_scratch="//label[@class='form-check-label ' and @for='inlineRadio_4']";
	private static final String Station_Name="//input[@type='text' and @class='form-control form-control-sm']";
	private static final String saveStation="//div[@class='button-wrap d-flex']//button[@type='button' and text()='Save']";
	private static final String StationWeeks="//div[@class='week-list-sec row-flex pl-20']";
	private static final String Selectalldays="(//span[@class='mr-1 ml-1']/following-sibling::*)[7]";
	private static final String Selectallweek="(//div[@class='d-flex w-100']//a[text()='Select for all Weeks'])[3]";
	private static final String Save_CheckRules="//button[@type='button' and @class='btn btn-save active mb-2 mr-2 mb-md-0']";
	private static final String RulesValidattionCheck="(//div[@id='rulesWarning']//label//div[@class='acord-btn'])[1]/..";
	private static final String RulesValidattionCheckTexttoseeRed="//div[@id='t1b1-0']//p";
	private static final String Recipes_Red="//div[contains(@class,'selected-red')]";
	private static final String RulesValidationText="//div[@id='t1b1-0']//p";
	private static final String RulesWarning="//div[@id='rulesWarning']//p[text()=' No warnings for the defined Rules']";
	private static final String IgnoreMicroMacro="//div[@id='t1b1-0']//a[@class='ignorItem']";
	private static final String loaderIgnoreRules="//span[@class='pwm-spinner-message']//span[text()='Rules Ignoring....']";
	private static final String MacroRUlesCheck="(//div[@id='rulesWarning']//label//div[@class='acord-btn'])[1]/..//h3[.='Macro-Micro Nutrients']";
	private static final String IgnoreRules="//a//div[@class='toltip']//i";
	private static final String EditTargetsButton="//button[.='Edit Targets']";
	





public boolean ClickKPIArrowDown() {
	 
	jsClick(KPI_Arrow_Down);
	
	return true;
	
}

public boolean ClickEditTargetButton() {
	 
	jsClick(EditTargetsButton);
	
	return true;
	
}



	public boolean User_validate_Recipes_And_OtherField() throws InterruptedException {

		dtt=new DefineTheTarget(driver);
		rules=new Rules(driver);
		dtt.User_Update_CopyMenuName();
		rules.Click_On_CreateMenu();
		VisibilityofELement(Recipe, 15);
		Boolean val=Element(Days_Selected).isDisplayed();
		Boolean val2=Element(Week_Selected).isDisplayed();
		String Actual_MealPeriod=GetSelectedDropDown(Meal_Period).getText();
		String Given_Meal_Period=prop.getProperty("Mealperiod");


		if (Element(Recipe).isDisplayed()==true && Actual_MealPeriod.equalsIgnoreCase(Given_Meal_Period) && val==true && val2==true) {

			return true;	

		}

		return false;
	}



	public boolean User_Verify_KPI_Values()   {

		int count=0;
		dtt=new DefineTheTarget(driver);
		rules=new Rules(driver);
		dtt.User_Update_CopyMenuName();
		rules.Click_On_CreateMenu();
		VisibilityofELement(Recipe, 10);
		click(KPI_Arrow_Down);

		for(WebElement kp:ListWebElement(KPI_Values)) {

			kp.isDisplayed();
			count++;
		}

		//System.out.println(count);

		if(count==5) {
			return true;
		}
		return false;


	}



	public boolean User_validate_TargetValues() throws InterruptedException {

		List<String> Final=new ArrayList<String>();
		dtt=new DefineTheTarget(driver);
		rules=new Rules(driver);
		List<String> Initial=dtt.User_getCopyMenu_TargetValues();
		rules.Click_On_CreateMenu();
		VisibilityofELement(Recipe, 15);
		jsClick(KPI_Arrow_Down);

		String CycleWeeks_Grid=Element(Target_Cycle_Value).getText().substring(5).trim();


		List<String> Target_values= ListStringElements(Target_Values);

		String[] Calories_Grid= Target_values.get(0).split(" k");
		String  Calories_Grid1 =Calories_Grid[0];

		String Calorie_Targettype_Grid= Target_values.get(1);

		String Meal_Periods_Grid= Target_values.get(2);
		String[] Meal_Periods_Grid_Actual=Meal_Periods_Grid.split(", ");

		for(String Value:Meal_Periods_Grid_Actual) {		
			Final.add(Value);
		}

		String Cost_Per_Meal_Target_Grid_Raw= Target_values.get(3);

		/*
		 * System.out.println("------------------------");
		 * System.out.println(Cost_Per_Meal_Target_Grid_Raw);
		 */


		String[] Cost_Per_Meal =Cost_Per_Meal_Target_Grid_Raw.split("\\.");
		/*
		 * System.out.println(Cost_Per_Meal[0]);
		 *  System.out.println(Cost_Per_Meal[1]);
		 */
		String Cost_Per_Meal_Target_Grid=Cost_Per_Meal[0];
		String Cost_Per_Meal_Target_Grid_Actual =Cost_Per_Meal_Target_Grid.substring(1);


		String Cost_Bucket_Grid= Target_values.get(4);

		if (Target_values.get(5).contains(", ")) {

			String[] Service_Type_Grid_Values =Target_values.get(5).split(", ");

			for(String Service_Type_Grid_Value:Service_Type_Grid_Values) {

				Final.add(Service_Type_Grid_Value);
			}
		}

		else if(Target_values.get(5).contains(", ")!=true) {

			String Service_Type_Grid=Target_values.get(5).trim();
			Final.add(Service_Type_Grid);
		}




		Final.add(CycleWeeks_Grid);
		Final.add(Calories_Grid1);
		Final.add(Calorie_Targettype_Grid);
		Final.add(Cost_Per_Meal_Target_Grid_Actual);
		Final.add(Cost_Bucket_Grid);

		Collections.sort(Final);


		//System.out.println("------------------------");

		/*
		 * for(String Val:Final) {
		 * 
		 * System.out.println(Val); }
		 */

		if(Initial.containsAll(Final)) {

			return true;
		}

		return false;


	}

	public boolean User_MoveTo_GI_Overview()   {

		List<String> list=new ArrayList<String>(Arrays.asList("Wk #","Day","MP","Recipe Id","Recipe Name"));

		click(KPI_Arrow_Right);

		try {

			Thread.sleep(15000);

		} catch (Exception e) {

		}

		Boolean IsButtonAvaialbe=VisibilityofELement(GI_OverviewButton, 10);
		Boolean IsRightHeadingVisible=Element(GIHeading).getText().contains(prop.getProperty("GIitemToClick"));
		Boolean IsRecipiesTableAvailable=VisibilityofELement(GIRecipiesTable, 10);
		Boolean IsTableheaderAvailable=ListStringElements(GIRecipiesTable_HeaderValues).containsAll(list);	
		Boolean IsColumnAscending=isAscendingOrder(ListIntElements(ListOfWeek));

		if (IsButtonAvaialbe==true && IsRightHeadingVisible==true && IsRecipiesTableAvailable==true && IsTableheaderAvailable==true && IsColumnAscending==true) {

			return true;

		} else {

			return false;

		}

	}

	public boolean User_AddRecipe()   {


		try {

			VisibilityofELement(Add_Recipe_Monday, 20);
			click(Add_Recipe_Monday);
			Sendval(InputRecipe, prop.getProperty("RECIPEID"));
			click(ADDRecipeButton);
			InvisibilityofElement(loader, 100);
			click(SaveAddedRecipe);
			InvisibilityofElement(LoaderOnSave, 200);
			VisibilityofELement(Loadermenu, 100);
			InvisibilityofElement(Loadermenu, 200);


			return true;

		} catch (Exception e) {

			e.printStackTrace();

		}
		return false;

	}

	public List<String> getGIfromMenuInsight() {

		click(KPI_Arrow_Right);

		try {

			Thread.sleep(15000);
			click(MenuInsights);
			List<String> GIMenus =ListStringElements(GIName);
			return GIMenus;

		} catch (Exception e) {

			e.printStackTrace();
			return null;

		}


	}


	public Boolean AddStation() {

		try {
			click(KpiArrowLeft);
			click(Dots_3);
			click(Add_Station);
			jsClick(from_scratch);
			Sendval(Station_Name, "main");
			click(saveStation);
			VisibilityofELement(Loadermenu, 3);
			InvisibilityofElement(Loadermenu, 20);
			Boolean isStationAvailable=VisibilityofELement(StationWeeks, 20);

			if (isStationAvailable==true) {

				TestBase.result("Verified User is able to add staion Succesfully " , true);
				return true;

			} else {

				return false;
			}

		} catch (InterruptedException e) {

			e.printStackTrace();	
			return false;


		}




	}

	public boolean User_AddRecipe_Milk(String Recipe)   {


		try {

			VisibilityofELement(Add_Recipe_Monday, 20);
			click(Add_Recipe_Monday);
			click(Selectalldays);
			click(Selectallweek);
			Sendval(InputRecipe, Recipe);
			click(ADDRecipeButton);
			VisibilityofELement(loader, 3);
			InvisibilityofElement(loader, 100);
			jsClick(SaveAddedRecipe);
			VisibilityofELement(Loadermenu, 10);
			Boolean isloaderInvisble=InvisibilityofElement(Loadermenu, 20);
			Thread.sleep(10000);
			if (isloaderInvisble==true) {

				return true;

			} else {

				return false;
			}


		} catch (Exception e) {

			e.printStackTrace();

		}
		return false;

	}



	public boolean User_SaveAndCheckRules()   {


		try {

			jsClick(KPI_Arrow_Down);
			click(Save_CheckRules);
			VisibilityofELement(LoaderOnSave,2);
			InvisibilityofElement(LoaderOnSave, 20);
			VisibilityofELement(LoaderOnSave,2);
			InvisibilityofElement(LoaderOnSave, 20);
			click(RulesValidattionCheck);
			VisibilityofELement(RulesValidattionCheckTexttoseeRed, 8);
			jsClick(RulesValidattionCheckTexttoseeRed);
			String 	ValidationText=getText(RulesValidationText);
			String TotalRecipe=ValidationText.substring(ValidationText.indexOf("(")+1, ValidationText.lastIndexOf(")"));	
			int TotalRecipevalue=Integer.parseInt(TotalRecipe);
			int TotalRecipeAvailable=ListElementsbyWait(Recipes_Red, 20).size();

			if (TotalRecipevalue==TotalRecipeAvailable) {

				TestBase.result("Verified Warning is displayed & all added recipes of milk are highlighted" , true);
				return true;

			} else {

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return false;

	}


	public boolean User_AddRecipe_Milk2(String Recipe)   {


		try {

			VisibilityofELement(Add_Recipe_Monday, 20);
			click(Add_Recipe_Monday);
			click(Selectalldays);
			click(Selectallweek);
			Sendval(InputRecipe, Recipe);
			click(ADDRecipeButton);
			VisibilityofELement(loader, 3);
			InvisibilityofElement(loader, 20);
			jsClick(SaveAddedRecipe);
			VisibilityofELement(Loadermenu, 10);
			Boolean isloaderInvisble=InvisibilityofElement(Loadermenu, 20);

			if (isloaderInvisble==true) {

				return true;

			} else {

				return false;
			}


		} catch (Exception e) {

			e.printStackTrace();

		}
		return false;

	}

	public boolean User_SaveAndCheckRules2()   {


		try {

			click(Save_CheckRules);
			VisibilityofELement(LoaderOnSave,2);
			InvisibilityofElement(LoaderOnSave, 20);
			VisibilityofELement(LoaderOnSave,2);
			InvisibilityofElement(LoaderOnSave, 20);
			int elements = ListElementsbyWait(RulesValidattionCheck, 20).size();

			if (elements==1 || Element(RulesWarning).isDisplayed()) {

				TestBase.result("Verified Warning is not displayed & rules are validated succesfully" , true);
				return true;

			} else {

				return false;
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return false;

	}

	public boolean User_SaveAndCheckRulesIgnored()   {


		try {

			jsClick(KPI_Arrow_Down);
			click(Save_CheckRules);
			VisibilityofELement(LoaderOnSave,2);
			InvisibilityofElement(LoaderOnSave, 20);
			VisibilityofELement(LoaderOnSave,2);
			InvisibilityofElement(LoaderOnSave, 20);
			click(RulesValidattionCheck);
			click(IgnoreMicroMacro);
			VisibilityofELement(loaderIgnoreRules, 2);
			Boolean val=InvisibilityofElement(loaderIgnoreRules, 9);

			if (val==true) {

				return true;

			} else {

				return false;

			}





		} catch (Exception e) {

			e.printStackTrace();

		}
		return false;

	}



	public boolean User_SaveAndCheckRulesFinal()   {


		try {

			jsClick(KPI_Arrow_Down);
			click(Save_CheckRules);
			VisibilityofELement(LoaderOnSave,2);
			InvisibilityofElement(LoaderOnSave, 20);
			VisibilityofELement(LoaderOnSave,2);
			InvisibilityofElement(LoaderOnSave, 20);
			int elements = ListElementsbyWait(RulesValidattionCheck, 20).size();

			if (elements==1 || Element(RulesWarning).isDisplayed()) {

				TestBase.result("Verified Warning is not displayed & rules are validated succesfully" , true);
				return true;

			} else {

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return false;

	}

	public boolean User_SaveAndCheckRulesIgnored2()   {


		try {


			click(Save_CheckRules);
			VisibilityofELement(LoaderOnSave,2);
			InvisibilityofElement(LoaderOnSave, 20);
			VisibilityofELement(LoaderOnSave,2);
			InvisibilityofElement(LoaderOnSave, 20);
			if (VisibilityofELement(MacroRUlesCheck,10)==true) {

				ignoreMacro_Micro();
				VisibilityofELement(LoaderOnSave,2);
				InvisibilityofElement(LoaderOnSave, 20);
			} 
			else if ( Element(RulesWarning).isDisplayed()) {

				TestBase.result("Verified Warning is not displayed & rules are validated succesfully" , true);
				return true;

			} else {
				return false;

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return false;

	}

	public boolean User_SaveAndCheckRulesIgnored3()   {


		try {

			click(Save_CheckRules);
			VisibilityofELement(LoaderOnSave,2);
			InvisibilityofElement(LoaderOnSave, 20);
			VisibilityofELement(LoaderOnSave,2);
			InvisibilityofElement(LoaderOnSave, 20);

			if ( Element(RulesValidattionCheck).isDisplayed()) {

				TestBase.result("Verified Warning is displayed & rules are validated succesfully" , true);
				return true;

			} else {

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return false;

	}

	public boolean User_SaveAndCheckNoVerification()   {


		try {

			jsClick(KPI_Arrow_Down);
			click(Save_CheckRules);
			VisibilityofELement(LoaderOnSave,2);
			InvisibilityofElement(LoaderOnSave, 20);
			VisibilityofELement(LoaderOnSave,2);
			Boolean val=InvisibilityofElement(LoaderOnSave, 20);

			if (val==true) {

				TestBase.result("Verified recipe is added" , true);
				return true;

			} else {

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return false;

	}


	public boolean ignoreMacro_Micro(){

		click(MacroRUlesCheck);
		click(IgnoreRules);
		return true;

	}

	
	public boolean SwapCopyRecipe(){

		try {
			iBAobj=new  IBAobj(driver);
			rules=new Rules(driver);
			rules.Click_On_CreateMenu();
			VisibilityofELement(LoaderOnSave, 3);
			InvisibilityofElement(LoaderOnSave, 40);
			Boolean val=iBAobj.SwapRecipeCopyMenu();
			return val;
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		return true;

	}


}