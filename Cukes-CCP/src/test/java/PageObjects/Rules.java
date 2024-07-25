package PageObjects;

import org.openqa.selenium.WebDriver;
import StepDefinitions.TestBase;

public class Rules extends TestBase {

	public  WebDriver driver;
	MenuGrid menugrid;

	public Rules(WebDriver driver) {

		this.driver=driver;

	}

	private static final String Create_Menu_Rules="//button[@type='button' and text()='Create Menu']";
	private static final String Loader_CreateMenu="//span[@class='pwm-spinner-message']//span[text()='Loading Menu Items...']";
	private static final String Build_closeset_Menu="//span[contains(text(),'I want to build a menu by using an existing menu, which is close to the target')]";
	private static final String Loader="//span[@class='pwm-spinner-message']";
	private static final String Beverages="//input[@id='beveragess']/following-sibling::*";
	private static final String milkAny="//input[  @id='m1' ]/following-sibling::*";
	private static final String milkAnyofServings="((//input[@id='m8']/following-sibling::*/following::*//select[@class=\"form-control w-100\"])[1]/following::*//input[@placeholder='# of servings'])[1]";
	private static final String milkAnyFrequency="(//input[@id='m8']/following-sibling::*/following::*//select[@class=\"form-control w-100\"])[2]";
	private static final String SaveRules="//button[@type='button' and text()='Save']";
	private static final String LoaderSaveRules="//span[@class='pwm-spinner-message']//span[text()='Saving Menu Rules...']";
	private static final String CreateMenuButton="//button[@type='button' and text()='Create Menu']";
	private static final String BuildFromScratchButton="//span[@class='btn-role']//span[contains(text(),'I want to build from scratch')]";
	private static final String LoadingMenuItems="//span[@class='pwm-spinner-message']//span[text()='Loading Menu Items...']";
	private static final String Save_and_Checkrules="(//button[@type='button']//i)[2]";
	private static final String LoaderValidatingRules="//span[@class='pwm-spinner-message']//span[text()='Validating Rules...']";
	private static final String MorningAny="//input[@id='cofe511' ]/following-sibling::*";
	private static final String MorningAnyofServing="(((//table[@class='table tlayout-fixed w-100'])[3]//tr)[4]//input)[9]";
	private static final String MorningBeverageVegan="//input[@id='cofe51' ]/following-sibling::*";
	private static final String OnepercentMilk="//input[@id='cofe11' ]/following-sibling::*";
	private static final String OnepercentMilkofServing="(((//table[@class='table tlayout-fixed w-100'])[2]//tr)[4]//input)[9]";
	private static final String OnepercentMilkServingSizeNumber="(((//table[@class='table tlayout-fixed w-100'])[2]//tr)[4]//input)[10]";
	private static final String FruitsandVegetables="//input[@id='fav']/following-sibling::*";
	private static final String FruitsServing="//table//tbody//strong[.='Fruit Servings']";
	
	
	public boolean Click_On_CreateMenu() {

		InvisibilityofElement(Loader, 30);
		click(Create_Menu_Rules);
		InvisibilityofElement(Loader_CreateMenu, 40);
		TestBase.result("Create Menu is Successfully Clicked" , true);
		return true;


	}

	public boolean Click_to_BuildCLosestMenu() {

		jsClick(Build_closeset_Menu);
		InvisibilityofElement(Loader, 30);
		TestBase.result("Click to Build Closest Menu Is Successfully Clicked" , true);		
		return true;

	}


	public boolean FillBeverage_Milk() {


		try {

			menugrid=new MenuGrid(driver);
			click(Beverages);
			MoveAction(Element(milkAny));
			jsClick(milkAny);
			getallBeverageDropDown(17, "898");
			Sendval(milkAnyofServings, "2");
			SelectDropDown(milkAnyFrequency, "1");
			Thread.sleep(4000);
			click(SaveRules);
			VisibilityofELement(LoaderSaveRules, 8);
			InvisibilityofElement(LoaderSaveRules, 20);
			click(CreateMenuButton);
			click(BuildFromScratchButton);
			VisibilityofELement(LoadingMenuItems, 8);
			InvisibilityofElement(LoadingMenuItems, 20);
			menugrid.AddStation();
			menugrid.User_AddRecipe_Milk(prop.getProperty("recipemilk"));
			menugrid.User_SaveAndCheckRules();
			menugrid.User_AddRecipe_Milk2(prop.getProperty("recipemilk2"));
			Boolean isTestVerified=menugrid.User_SaveAndCheckRules2();

			if (isTestVerified==true) {

				return true;

			} else {

				return false;
			}


		} catch (Exception e) {

		}


		return false;

	}


	public boolean FillBeverage_Morning() {


		try {
			prop.load(fs);
			menugrid=new MenuGrid(driver);
			click(Beverages);
			MoveAction(Element(MorningAny));
			jsClick(MorningAny);
			getallBeverageDropDown(25, "902");
			Sendval(MorningAnyofServing, "2");
			getallBeverageDropDown(26, "1");
			Thread.sleep(4000);
			click(SaveRules);
			VisibilityofELement(LoaderSaveRules, 8);
			InvisibilityofElement(LoaderSaveRules, 20);
			click(CreateMenuButton);
			click(BuildFromScratchButton);
			VisibilityofELement(LoadingMenuItems, 8);
			InvisibilityofElement(LoadingMenuItems, 20);
			menugrid.AddStation();
			menugrid.User_AddRecipe_Milk(prop.getProperty("recipemorning"));
			menugrid.User_SaveAndCheckRules();
			menugrid.User_AddRecipe_Milk2(prop.getProperty("recipemorning2"));
			Boolean isTestVerified=menugrid.User_SaveAndCheckRules2();

			if (isTestVerified==true) {

				return true;

			} else {

				return false;
			}


		} catch (Exception e) {

		}


		return false;

	}

	public boolean FillBeverage_MorningVegan() {


		try {
			prop.load(fs);
			menugrid=new MenuGrid(driver);
			click(Beverages);
			MoveAction(Element(MorningBeverageVegan));
			jsClick(MorningBeverageVegan);
			getallBeverageDropDown(23, "903");
			Sendval(MorningAnyofServing, "1");
			getallBeverageDropDown(24, "1");
			Thread.sleep(2000);
			click(SaveRules);
			VisibilityofELement(LoaderSaveRules, 8);
			InvisibilityofElement(LoaderSaveRules, 20);
			click(CreateMenuButton);
			click(BuildFromScratchButton);
			VisibilityofELement(LoadingMenuItems, 8);
			InvisibilityofElement(LoadingMenuItems, 20);
			menugrid.AddStation();
			menugrid.User_AddRecipe_Milk(prop.getProperty("recipemorningvegan"));
			Boolean isTestVerified=menugrid.User_SaveAndCheckRulesFinal();

			if (isTestVerified==true) {

				return true;

			} else {

				return false;
			}


		} catch (Exception e) {

		}


		return false;

	}

	public boolean OnePercentMilk() {


		try {
			prop.load(fs);
			menugrid=new MenuGrid(driver);
			click(Beverages);
			MoveAction(Element(OnepercentMilk));
			jsClick(OnepercentMilk);
			getallBeverageDropDown(1, "898");
			Sendval(OnepercentMilkofServing, "1");
			getallBeverageDropDown(2, "1");
			Thread.sleep(2000);
			click(SaveRules);
			VisibilityofELement(LoaderSaveRules, 8);
			InvisibilityofElement(LoaderSaveRules, 20);
			click(CreateMenuButton);
			click(BuildFromScratchButton);
			VisibilityofELement(LoadingMenuItems, 8);
			InvisibilityofElement(LoadingMenuItems, 20);
			menugrid.AddStation();
			menugrid.User_AddRecipe_Milk(prop.getProperty("recipemilkonepercent"));
			menugrid.User_SaveAndCheckRulesIgnored();
			menugrid.User_AddRecipe_Milk(prop.getProperty("recipemilkonepercentSecond"));
			menugrid.User_SaveAndCheckRulesIgnored2();
			menugrid.User_AddRecipe_Milk(prop.getProperty("recipemilkPC"));
			Boolean isTestVerified =menugrid.User_SaveAndCheckRulesIgnored3();

			if (isTestVerified==true) {

				return true;

			} else {

				return false;
			}


		} catch (Exception e) {

		}


		return false;

	}

	public boolean OnePercentMilkServing() {


		try {
			prop.load(fs);
			menugrid=new MenuGrid(driver);
			click(Beverages);
			MoveAction(Element(OnepercentMilk));
			jsClick(OnepercentMilk);
			Sendval(OnepercentMilkofServing, "2");
			getallBeverageDropDown(2, "1");
			getallBeverageDropDown(4, "139");
			Sendval(OnepercentMilkServingSizeNumber,"1");
			Thread.sleep(2000);
			click(SaveRules);
			VisibilityofELement(LoaderSaveRules, 8);
			InvisibilityofElement(LoaderSaveRules, 20);
			click(CreateMenuButton);
			click(BuildFromScratchButton);
			VisibilityofELement(LoadingMenuItems, 8);
			InvisibilityofElement(LoadingMenuItems, 20);
			menugrid.AddStation();
			menugrid.User_AddRecipe_Milk(prop.getProperty("recipemilkonepercent"));
			menugrid.User_SaveAndCheckNoVerification();
			menugrid.User_AddRecipe_Milk(prop.getProperty("recipemilkonepercentSecond"));
			menugrid.User_SaveAndCheckRulesIgnored2();
			menugrid.User_AddRecipe_Milk(prop.getProperty("recipemilkPC"));
			Boolean isTestVerified =menugrid.User_SaveAndCheckRulesIgnored3();

			if (isTestVerified==true) {

				return true;

			} else {

				return false;
			}


		} catch (Exception e) {

			e.printStackTrace();

		}


		return false;

	}

	
	public boolean FruitsandVeg() {


		try {
			prop.load(fs);
			menugrid=new MenuGrid(driver);
			click(FruitsandVegetables);
			MoveAction(Element(FruitsServing));
			insertFruitVegofserving(1,"2");
			selectFruitVegFrequency(1,"1");
			
			insertFruitVegofserving(2,"2");
			selectFruitVegFrequency(2, "1");
			Thread.sleep(2000);
			click(SaveRules);
			VisibilityofELement(LoaderSaveRules, 8);
			InvisibilityofElement(LoaderSaveRules, 20);
			click(CreateMenuButton);
			click(BuildFromScratchButton);
			VisibilityofELement(LoadingMenuItems, 8);
			InvisibilityofElement(LoadingMenuItems, 20);
			menugrid.AddStation();
			menugrid.User_AddRecipe_Milk(prop.getProperty("recipefruit1"));
			menugrid.User_AddRecipe_Milk(prop.getProperty("recipefruit2"));
			menugrid.User_AddRecipe_Milk(prop.getProperty("recipefruit3"));
			Boolean isTestVerified =menugrid.User_SaveAndCheckRulesFinal();

			if (isTestVerified==true) {

				return true;

			} else {

				return false;
			}


		} catch (Exception e) {

			e.printStackTrace();

		}


		return false;

	}

	public boolean getallBeverageDropDown(int i, String Values) {



		String SelectPackagingType="(//input[@id='cofe18']/following-sibling::*/following::*//select[@class='form-control w-100'])["+i+"]";
		SelectDropDown(SelectPackagingType,Values );

		return true;

	}

	public boolean insertFruitVegofserving(int i, String Values) {


		String FruitOfServing="(//table//tbody//strong[.='Fruit Servings']/following::*//input)["+i+"]";

		try {
			Sendval(FruitOfServing, Values );
			
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		return true;

	}

	public boolean selectFruitVegFrequency(int i, String Values) {


		String Frequency="(//table//tbody//strong[.='Fruit Servings']/following::*//select)["+i+"]";

		SelectDropDown(Frequency, "1");

		return true;

	}
	
	


	
	





}
