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

	public  WebDriver driver;

	public MenuGrid(WebDriver driver) {

		this.driver=driver;

	}

	private static final String Recipe="(//div[@class='recipe-card w-full row-flex']//div[@class='sortable-part1 week-in']//div[@class='itemname'])[1]";
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

}