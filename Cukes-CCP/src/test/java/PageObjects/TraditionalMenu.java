package PageObjects;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import StepDefinitions.TestBase;

public class TraditionalMenu extends TestBase{

	public  WebDriver driver;
	CCPMenu ccp ;
	DefineTheTarget dtt ;
	
	//public JSONObject Value;




	public TraditionalMenu(WebDriver driver) {

		this.driver=driver;
		

	}
	
	

	private static final String Add="//button[@type='button' and text()='Add']";
	private static final String Serach="//button[@type='button' and text()='Search']";
	private static final String Clearbtn="//button[@type='button' and text()='Clear All']";
	private static final String Menu_Box="//input[@class='pwm-input-control']";
	private static final String Menu_Table_value="//table[@class='search-result']//tr//td[1]//p";
	private static final String Loader="//span[@class='pwm-spinner-message']";
	private static final String Heading_Rules_Page="//h2[@class='mb-0' and text()='Product Requirements & Restrictions']";
	private static final String Save="//button[@type='button' and text()='Save']";
	private static final String Nutmeg_Radio_No="(//span[@class='radiobtn'])[2]";
	private static final String Edit_Menu="//h2[@class='header-info-label' and text()='Edit Menu']";
	private static final String Edit_Rules="//button[@type='button' and text()='Edit Rules']";
	private static final String Copy_Icon="(//i[@class='pwm-icon fas fa-copy table-icon-copy menu-search-icon link'])[1]";
	private static final String Name="//input[@placeholder='Write menu name']";
	private static final String Menu_Table_Description="//table[@class='search-result']//tr//td[2]";
	private static final String Status_DropDown="(//select[@class='form-control'])[1]";
	private static final String Text_Value_for_Status="//option[@value='1'and text()='Recently Added']";
	private static final String Select_Cycle_Weeks="(//select[@class='form-control'])[2]";
	private static final String Gender="(//select[@class='form-control' ])[3]";
	private static final String Population_Type="//select[@id='mySelect1']";
	private static final String Selected_Meal="//div[@class=\"meal-period-btn-container pl-3 pt-3 pb-3\"]//div[@class='row mb-2']//div[@class='pl-3']//h4";
	private static final String Edit_Meal="(//*[name()='svg'])[1]";



	public  boolean clickonAdd() {

		
		VisibilityofELement(Add, 8);
		jsClick(Add);
		return true;

	}

	public  boolean clickCopyIcon(int i) {

		driver.findElement(By.xpath("(//i[@class='pwm-icon fas fa-copy table-icon-copy menu-search-icon link'])["+i+"]")).click();
		return true;



	}


	public  boolean Validate_Menucreated() {

		try {
			ccp=new CCPMenu(driver);
           dtt=new DefineTheTarget(driver);
			String Menu_Name=dtt.Create_Menu();
			ccp.clickonTraditional_Menus();
			Sendval(Menu_Box, Menu_Name);
			InvisibilityofElement(Loader, 10);
			click(Serach);
			VisibilityofELement(Menu_Table_value, 8);	
			boolean val=Element(Menu_Table_value).getText().equalsIgnoreCase(Menu_Name);

			if(val==true) {
				TestBase.result("Validate Menu created is Verified on Search Page", val);

				return true;
			}


		} catch (InterruptedException e) {

			e.printStackTrace();

		}
		return false;



	}

	public  boolean Validate_RulePage_Title() {


		try {
			dtt=new DefineTheTarget(driver);
			dtt.Create_Menu();
			boolean val=VisibilityofELement(Heading_Rules_Page, 8);
			if(val==true) {

				return val;		
			}
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		return false;

	}


	public  boolean Validate_rules_are_saved() {

		 dtt=new DefineTheTarget(driver);
		try {
			dtt.Create_Menu();
			InvisibilityofElement(Loader, 10);
			click(Nutmeg_Radio_No);
			click(Save);
			InvisibilityofElement(Loader, 10);
			return true;

		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		return false;

	}



	public  boolean Validate_EditMenu_Title() throws InterruptedException {

		InvisibilityofElement(Loader, 10);
		click(Serach);
		InvisibilityofElement(Loader, 10);
		WebElement Ele=ListWebElement(Menu_Table_value).get(0);
		Ele.click();
		InvisibilityofElement(Loader, 10);
		if (VisibilityofELement(Edit_Menu, 10)==true) {
			return true;
		}
		return false;


	}


	public  boolean Validate_EditRules_Page()  {

		InvisibilityofElement(Loader, 10);
		click(Serach);
		InvisibilityofElement(Loader, 10);
		WebElement Ele=ListWebElement(Menu_Table_value).get(0);
		Ele.click();
		InvisibilityofElement(Loader, 10);
		click(Edit_Rules);
		if (VisibilityofELement(Heading_Rules_Page, 10)==true) {
			return true;
		}
		return false;	
	}

	public  boolean User_Move_to_EditDTT()   {

		InvisibilityofElement(Loader, 10);
		click(Serach);
		InvisibilityofElement(Loader, 10);
		click(Copy_Icon);
		InvisibilityofElement(Loader, 20);
		return true;


	}

	public  boolean User_Validates_Copied_Menu_Name()   {

		InvisibilityofElement(Loader, 10);
		click(Serach);
		InvisibilityofElement(Loader, 10);
		String Copy_Name=ListStringElements(Menu_Table_value).get(0);
		click(Copy_Icon);
		InvisibilityofElement(Loader, 20);
		String Actual_Name=Element(Name).getAttribute("value");
		System.out.println(Copy_Name+" "+Actual_Name);

		if(Copy_Name.equalsIgnoreCase(Actual_Name)) {

			return true;	
		}
		return false;


	}

	public  boolean User_Validates_Copied_Description_Name()    {

		 dtt=new DefineTheTarget(driver);
		InvisibilityofElement(Loader, 10);
		click(Serach);
		InvisibilityofElement(Loader, 10);
		String Copy_Name=ListStringElements(Menu_Table_Description).get(3);
		System.out.println(Copy_Name);
		clickCopyIcon(4);
		InvisibilityofElement(Loader, 30);
		String Actual_Name=dtt.getDescriptionText();
		//System.out.println(Copy_Name+" "+Actual_Name);

		if(Copy_Name.equalsIgnoreCase(Actual_Name)) {


			return true;	
		}
		return false;


	}

	public  boolean User_validate_Status_on_Copymenu() throws IOException   {

		
		Boolean val=Element(Status_DropDown).isEnabled();
		String text=Element(Text_Value_for_Status).getText();
		//prop.load(fs);
   //	System.out.println(prop.getProperty("url"));
		//System.out.println(Value.getJSONObject("TraditionalMenu").getString("status"));
		if(val==false && text.equalsIgnoreCase(Value.getJSONObject("TraditionalMenu").getString("status")) ){ //Put  Status_Text here from above

			return true;
		}

		return false;

	}

	public  boolean User_validate_Fields_on_Copymenu()     {
       ccp=new CCPMenu(driver);
		ccp.clickonTraditional_Menus();
		InvisibilityofElement(Loader, 8);
		click(Serach);
		click(Copy_Icon);
		InvisibilityofElement(Loader, 20);
		String cycle_Weeks=GetSelectedDropDown(Select_Cycle_Weeks).getText();
		String GenderValue= GetSelectedDropDown(Gender).getText();
		String PopulationValue=GetSelectedDropDown(Population_Type).getText();
		int Menu_Size=ListWebElement(Selected_Meal).size();
		//System.out.println(prop.getProperty("Cycle_Weeks"));

		//  System.out.println(cycle_Weeks +"  "+"  "+GenderValue+"  "+PopulationValue+"  "+Menu_Size);

		int i=1;
		boolean allConditionsTrue = true; 

		while (i <= 1) {

			allConditionsTrue = allConditionsTrue && 
					Element(Select_Cycle_Weeks).isEnabled()&&
					Element(Gender).isEnabled()&&
					Element(Population_Type).isEnabled()&&
					Element(Edit_Meal).isDisplayed()&&
					cycle_Weeks.equalsIgnoreCase(prop.getProperty("Cycle_Weeks")) &&
					GenderValue.equalsIgnoreCase(prop.getProperty("Gender")) &&
					PopulationValue.equalsIgnoreCase(prop.getProperty("Population"))&&
					Menu_Size==3;                    
			i++;
		}
		return allConditionsTrue;


	}

}
