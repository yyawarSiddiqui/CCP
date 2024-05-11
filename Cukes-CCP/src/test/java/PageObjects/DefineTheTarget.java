package PageObjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import StepDefinitions.TestBase;

public class DefineTheTarget extends TestBase {

	public  WebDriver driver;
	TraditionalMenu tt;


	public DefineTheTarget(WebDriver driver) {

		this.driver=driver;

	}

	//	(//span[@class='text-danger' and text()='*'])[3]
	String Input_Name="!@#$%^&*()_abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789ujhfgfgjfjgfjgjfgrirtrhjgfjj";


	private static final String DTT_Title="//h2[@class='header-info-label' and text()='Define The Target']";
	private static final String Meal_Period="//h3[@class='text-primary btn']";
	private static final String Close_Meal_Period="	//p[@class='closes cursor-pointer' and text()='Close Meal Period']";
	private static final String Name="//input[@placeholder='Write menu name']";
	private static final String Comments="//div//textarea[@placeholder='Write your comments here']";
	private static final String Description="//div//textarea[@placeholder='Write your description']";
	private static final String SelectRDAType="(//select[@class=\"selectedOpt form-control\"])[3]";
	private static final String Create_Button="//button[@type='button' and text()='Create']";
	private static final String Warning_Banner="//div[@class=\"toastr animated rrt-warning\"]";
	private static final String Success_Msg="//div[@class='toastr animated rrt-info']//span[text()='Menu created successfully!']";
	private static final String Loader="//span[@class='pwm-spinner-message']//span[contains(text(),'Loading fields...')]";
	private static final String Service_Channel="//p[@class='mb-0' ]";
	private static final String Calorie_Level="//input[@name='calorie']";
	private static final String Taget_Type="(//select[@class='form-control' ])[4]";
	private static final String Select_Cycle_Weeks="(//select[@class='form-control'])[2]";
	private static final String Gender="(//select[@class='form-control' ])[3]";
	private static final String Population_Type="//select[@id='mySelect1']";
	private static final String Status_DropDown="(//select[@class='form-control'])[1]";
	private static final String Text_Value_for_Status="//option[@value='1'and text()='Recently Added']";
	private static final String Copy_Warning_Msg="//div[contains(text(),'Master Menu with the same name already exists.')]";
	private static final String Loader_CreateMenu="//span[@class='pwm-spinner-message']//span[contains(text(),'Validating and Creating New Menu...')]";
	private static final String Cost_Bucket="(//select[@class='form-control'])[5]";
	private static final String Production_Type="//div[@id='react-select-7--value']//span[@class='Select-value-label']";
	private static final String Meal_Heading="//div[@class='row mb-2']//h4";
	private static final String Unselected_Meals="//input[@class='styled-checkbox selectedId' and @value='false']/following-sibling::*";
	private static final String Cost_PerMeal_Target="//input[@name='costPerMeal']";

	
	public boolean VerifyDTTScreenVisibility() {


		Boolean value=VisibilityofELement(DTT_Title, 8);
		return value;

	}


	public boolean validate_Name_Field() throws InterruptedException  {


		VisibilityofELement(Meal_Period, 20);
		jsClick(Meal_Period);
		jsClick(Close_Meal_Period);
		SelectDropDown(SelectRDAType, prop.getProperty("value"));
		jsClick(Create_Button);
		Boolean val=VisibilityofELement(Warning_Banner,3);
		return val;

	}

	public boolean Validate_Meal_Period() throws InterruptedException {

		SendText(Name);
		Thread.sleep(10000);
		VisibilityofELement(SelectRDAType,20);
		SelectDropDown(SelectRDAType,prop.getProperty("value") );
		jsClick(Create_Button);
		Boolean val=VisibilityofELement(Warning_Banner,3);
		return val;

	}

	public boolean Validate_RDAType() throws InterruptedException {

		VisibilityofELement(Meal_Period, 20);
		jsClick(Meal_Period);
		jsClick(Close_Meal_Period);
		SendText(Name);
		jsClick(Create_Button);
		Boolean val=VisibilityofELement(Warning_Banner,3);
		return val;

	}

	public boolean Validate_Description() throws InterruptedException {


		VisibilityofELement(Meal_Period, 20);
		jsClick(Meal_Period);
		jsClick(Close_Meal_Period);
		SendText(Name);
		Element(Name);
		VisibilityofELement(SelectRDAType,20);
		SelectDropDown(SelectRDAType, prop.getProperty("value"));
		jsClick(Create_Button);
		Boolean val=VisibilityofELement(Success_Msg,20);
		return val;

	}

	public boolean Validate_NameFIeld_Limit()  {

		InvisibilityofElement(Loader, 8);
		Element(Name).sendKeys(Input_Name);
		int Final_Length=Element(Name).getAttribute("value").length();
		Element(Service_Channel).getText();
		if(Final_Length==100) {

			return true;
		}
		return false;
	}

	public boolean Service_Channel_Validation()  {

		String Channel_Text=Element(Service_Channel).getText();
		if(Channel_Text.equalsIgnoreCase("Corrections")) {

			return true;
		}
		return false;

	}


	public boolean Verify_Calorie_Level()  {


		boolean val =Element(Calorie_Level).getAttribute("value").equalsIgnoreCase("");

		if(val==true) {
			TestBase.result("Verify Calorie Level is initailly Empty", val);
		}

		if(Element(Taget_Type).isEnabled()==false) {

			TestBase.result("Verify Target_Type is Initially disabled", val);
			return true;

		}

		return false;

	}

	public String Create_Menu() throws InterruptedException {


		VisibilityofELement(Meal_Period, 20);
		jsClick(Meal_Period);
		jsClick(Close_Meal_Period);
		SendText(Name);
		VisibilityofELement(SelectRDAType,20);
		SelectDropDown(SelectRDAType, prop.getProperty("value"));
		String Menu_Name=Element(Name).getAttribute("value");
		jsClick(Create_Button);
		InvisibilityofElement(Loader_CreateMenu, 10);
		TestBase.result("Menu is created Succesfully" , true);
		return Menu_Name;


	}
	
	public String Create_Menu_For_Closest() throws InterruptedException {


		VisibilityofELement(Meal_Period, 20);
		jsClick(Meal_Period);
		
		
		for(WebElement Element_meal:ListWebElement(Unselected_Meals)) {
			
			Element_meal.click();
		}
		
		
		jsClick(Close_Meal_Period);
		SendText(Name);
		VisibilityofELement(SelectRDAType,20);
		SelectDropDown(SelectRDAType, prop.getProperty("value"));
		String Menu_Name=Element(Name).getAttribute("value");
		jsClick(Create_Button);
		InvisibilityofElement(Loader_CreateMenu, 10);
		return Menu_Name;


	}
	
	

	public String getDescriptionText() {

		return  Element(Description).getText();	

	}

	public Boolean Create_Menu_allFields() throws InterruptedException {


		tt=new TraditionalMenu(driver);

		//Meal, Name, RDAType,Weeks,Gender,Population Type
		InvisibilityofElement(Loader, 20);
		tt.clickonAdd();
		VisibilityofELement(Meal_Period, 5);
		jsClick(Meal_Period);
		jsClick(Close_Meal_Period);
		SendText(Name);
		SelectDropDown(Select_Cycle_Weeks, "5");
		SelectDropDown(SelectRDAType, prop.getProperty("value"));
		SelectDropDown(Gender, prop.getProperty("GenderValue"));
		SelectDropDown(Population_Type, prop.getProperty("PopulationValue"));
		jsClick(Create_Button);
		InvisibilityofElement(Loader, 20);

		return true;

	}

	public  boolean User_validate_Status_on_DTT()   {

		InvisibilityofElement(Loader, 20);
		Boolean val=Element(Status_DropDown).isEnabled();
		String text=Element(Text_Value_for_Status).getText();
		System.out.println(text);
		Boolean val2 =GetAsterickElement(3).isDisplayed();
		if(val==false && text.equalsIgnoreCase(Value.getJSONObject("TraditionalMenu").getString("status"))&& val2==true ){ ///Put  Status_Text here from above

			return true;
		}

		return false;

	}

	public  boolean User_Validate_the_functionality_of_the_Number_of_Cycle_Weeks_dropdown ()   {

		InvisibilityofElement(Loader, 20);
		Boolean val=Element(Select_Cycle_Weeks).isEnabled();
		Boolean val2 =GetAsterickElement(4).isDisplayed();
		String dropDownValue=GetSelectedDropDown(Select_Cycle_Weeks).getText();
		List<String> Options=GetDropDownOptions(Select_Cycle_Weeks);
		List<String> Validation_Option=new ArrayList<String>(Arrays.asList("1","2","3","4","5","6","7","8"));

		boolean Allvaluesvalid=true;
		Collections.sort(Options);


		for(String opt:Options) {

			if(!Validation_Option.contains(opt)) {

				Allvaluesvalid=false;
				break;
			}
		}

		if(val==true && val2==true && dropDownValue.equalsIgnoreCase("4") && Allvaluesvalid==true ) { 

			return true;
		}

		return false;

	}

	public WebElement GetAsterickElement( int i)  {
		String Asterik="(//span[@class='text-danger' and text()='*'])["+i+"]";
		WebElement Ele=driver.findElement(By.xpath(Asterik));
		return Ele;

	}

	public  boolean User_Click_Create_On_Copy()   {

		InvisibilityofElement(Loader, 20);
		click(Create_Button);
		Boolean Val=Element(Copy_Warning_Msg).isDisplayed();

		return Val;


	}


	public  String User_Update_CopyMenuName()   {

		String Name_Value=null;
		InvisibilityofElement(Loader, 20);
		try {

			Element(Name).clear();
			Name_Value=SendText(Name);
			click(Create_Button);
			InvisibilityofElement(Loader_CreateMenu, 40);


		} catch (InterruptedException e) {

			e.printStackTrace();
		}




		return Name_Value;


	}

	public  List<String> User_getCopyMenu_TargetValues()   {

		List<String> newlist=new ArrayList<String>();
		InvisibilityofElement(Loader, 20);
		Element(Name).clear();
		try {
			SendText(Name);

		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		String DTT_CycleWeeks=GetSelectedDropDown(Select_Cycle_Weeks).getText();
		String DTT_CalorieValue=Element(Calorie_Level).getAttribute("value");
		String DTT_Targettype=GetSelectedDropDown(Taget_Type).getText();
		String DTT_CostBucketValue=GetSelectedDropDown(Cost_Bucket).getText();
		String DTT_Cost_PerMeal_Target =Element(Cost_PerMeal_Target).getAttribute("value");
	 
		if(DTT_Targettype.equalsIgnoreCase("Select")) {
			
			DTT_Targettype="NA";
			
		}
		
		String[] Cost_PerMeal =DTT_Cost_PerMeal_Target.split(" .");
		String Trimmed_CostPer_Meal=Cost_PerMeal[0];
		/*
		 * System.out.println(Trimmed_CostPer_Meal);
		 * System.out.println("=============");
		 */
		String dd=Trimmed_CostPer_Meal.substring(0);
		
		if(dd.equalsIgnoreCase("0.0000")) {
			
			dd="0.00";
		}
		
		
		if(DTT_CalorieValue.isEmpty()) {
			
			DTT_CalorieValue="0";
		}
		
		List<String> Server_Type=ListStringElements(Production_Type);
		
		/*
		 * String text_with_nbsp =Element(Production_Type).getText();
		 * 
		 * String Server_Type_without_nbsp=text_with_nbsp.trim();
		 */
		
		//System.out.println(text_without_nbsp);
		
		for(String l1:Server_Type) {
			
			newlist.add(l1.trim());
            
		}

		List<String>Meal_Type=ListStringElements(Meal_Heading);

		for(String l2:Meal_Type) {
			newlist.add(l2);

		}

		newlist.add(DTT_CostBucketValue);
		  newlist.add(DTT_CalorieValue);
		 newlist.add(DTT_Targettype);        
		newlist.add(DTT_CycleWeeks);
      //  newlist.add(dd);
		Collections.sort(newlist);

		for(String val:newlist) {

			System.out.println(val);
		}



		//     System.out.println(DTT_CycleWeeks +" "+DTT_CalorieValue+" "+DTT_Targettype+" "+DTT_CostBucketValue+" "+ServiceType+" "+MealsType);

		click(Create_Button);
		InvisibilityofElement(Loader_CreateMenu, 40);




		return newlist;

	}





}

