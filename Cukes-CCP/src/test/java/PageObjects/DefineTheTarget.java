package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import StepDefinitions.TestBase;

public class DefineTheTarget extends TestBase {

	public  WebDriver driver;
	TraditionalMenu tt;


	public DefineTheTarget(WebDriver driver) {

		this.driver=driver;

	}


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
	private static final String Select_Cycle_Weeks="(//select[@class=\"form-control\"])[2]";
	private static final String Gender="(//select[@class='form-control' ])[3]";
	private static final String Population_Type="//select[@id='mySelect1']";



	public boolean VerifyDTTScreenVisibility() {


		Boolean value=VisibilityofELement(DTT_Title, 8);
		return value;

	}
	
	
	public boolean validate_Name_Field() throws InterruptedException  {


		VisibilityofELement(Meal_Period, 20);
		jsClick(Meal_Period);
		jsClick(Close_Meal_Period);
		SelectDropDown(SelectRDAType, "M74");
		jsClick(Create_Button);
		Boolean val=VisibilityofELement(Warning_Banner,3);
		return val;

	}

	public boolean Validate_Meal_Period() throws InterruptedException {

		SendText(Name);
		Thread.sleep(10000);
		VisibilityofELement(SelectRDAType,20);
		SelectDropDown(SelectRDAType, "M74");
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
		SelectDropDown(SelectRDAType, "M74");
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
		SelectDropDown(SelectRDAType, "M74");
		String Menu_Name=Element(Name).getAttribute("value");
		jsClick(Create_Button);
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
		SelectDropDown(SelectRDAType, "M74");
		SelectDropDown(Gender, "75");
		SelectDropDown(Population_Type, "72");
		jsClick(Create_Button);
		InvisibilityofElement(Loader, 20);

		return true;

	}


}
