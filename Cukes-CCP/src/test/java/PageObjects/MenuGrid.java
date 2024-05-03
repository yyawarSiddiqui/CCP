package PageObjects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
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
		
		String CycleWeeks_Grid=Element(Target_Cycle_Value).getText().substring(5);
		
		List<String> Target_values= ListStringElements(Target_Values);
		
	    String[] Calories_Grid= Target_values.get(0).split(" k");
	    String  Calories_Grid1 =Calories_Grid[0];
	  //  System.out.println(Calories_Grid1);
	    
		String Calorie_Targettype_Grid= Target_values.get(1);
		
		String Meal_Periods_Grid= Target_values.get(2);
		String[] Meal_Periods_Grid_Actual=Meal_Periods_Grid.split(", ");
		
		for(String Value:Meal_Periods_Grid_Actual) {		
			Final.add(Value);
		}
		
		String Cost_Per_Meal_Target_Grid_Raw= Target_values.get(3);
		//System.out.println(Cost_Per_Meal_Target_Grid);
		String[] Cost_Per_Meal =Cost_Per_Meal_Target_Grid_Raw.split(".00");
		String Cost_Per_Meal_Target_Grid=Cost_Per_Meal[0];
	     String Cost_Per_Meal_Target_Grid_Actual =Cost_Per_Meal_Target_Grid.substring(1);
	     
	     
		String Cost_Bucket_Grid= Target_values.get(4);
		
		String Service_Type_Grid= Target_values.get(5);
		
		Final.add(CycleWeeks_Grid);
	//	Final.add(Calories_Grid1);
	//	Final.add(Calorie_Targettype_Grid);
	  //Final.add(Cost_Per_Meal_Target_Grid_Actual);
		Final.add(Cost_Bucket_Grid);
		//Final.add(Service_Type_Grid);
		
		Collections.sort(Final);
		
		for(String Val:Final) {
			
			System.out.println(Val);
		}
		
		if(Initial.equals(Final)) {
			
			return true;
		}
		
		return false;
		
		

	}
}