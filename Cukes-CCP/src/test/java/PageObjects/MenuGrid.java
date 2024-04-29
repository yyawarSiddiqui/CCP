package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
	private static final String KPI_Arrow= "//div[@class='top-side-arrow']";

	

	public boolean User_validate_Recipes_And_OtherField() throws InterruptedException {
	// current KPI Values	//div[@class='card']/*//b

		dtt=new DefineTheTarget(driver);
		rules=new Rules(driver);
		dtt.User_Update_CopyMenuName();
		rules.Click_On_CreateMenu();
		VisibilityofELement(Recipe, 10);
		Boolean val=Element(Days_Selected).isDisplayed();
		Boolean val2=Element(Week_Selected).isDisplayed();
		String Actual_MealPeriod=GetSelectedDropDown(Meal_Period).getText();
		String Given_Meal_Period=prop.getProperty("Mealperiod");
		
		if (Element(Recipe).isDisplayed()==true && Actual_MealPeriod.equalsIgnoreCase(Given_Meal_Period) && val==true && val2==true) {

			return true;	

		}

		return false;
	}
	
	

		public boolean User_Verify_KPI_Values()  {
			// current KPI Values	//div[@class='card']/*//b

				dtt=new DefineTheTarget(driver);
				rules=new Rules(driver);
				dtt.User_Update_CopyMenuName();
				rules.Click_On_CreateMenu();
				 VisibilityofELement(Recipe, 10);
				 jsClick(KPI_Arrow);
				Sleep(9);
				 
				 return true;

	}
	
	
	

}
