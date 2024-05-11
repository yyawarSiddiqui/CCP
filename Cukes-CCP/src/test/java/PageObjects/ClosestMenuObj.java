package PageObjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import StepDefinitions.TestBase;

public class ClosestMenuObj extends TestBase {

	public  WebDriver driver;
	DefineTheTarget defineTheTarget;
	Rules rules;
	TraditionalMenu traditionalMenu;

	public  ClosestMenuObj(WebDriver driver) {

		this.driver=driver;

	}


	private static final String Search_Closeset="//button[@type='button' and text()='Search']";
	private static final String Menu_Place="//input[@id=\"MenuName\" and @maxlength='40']"; 
	private static final String Total_Filters="//select[@class='dropdown ' ]/..";
	private static final String Total_Filters_Disabled="//div[@class='row select_box_wapper w-100']";
	private static final String Reset="//button[@type='button' and text()='Reset']";
	private static final String Baseline_Cost_Max="//select[@id='dropwown - 13']/following-sibling::*[@name='baselineMax']";
	private static final String Warning_Banner="//div[@class='toastr animated rrt-warning']//span[text()='Warning']";
	private static final String Remove_Filter="//select[@id='DD 1 - Gender']/following-sibling::*//i[@class='far fa-times-circle']";
	private static final String Add_Filter="//div[@class='addIcon']//i[@class='fas fa-plus-circle ']";
	private static final String RemoveAll_Filter="//div[@class='removeIcon']";
	private static final String CycleValueinTable="(//table//th//button[text()='Cycle']/following::*//td[text()='5'])[1]";
	private static final String LoaderChangeFilter="//span[@class='pwm-spinner-message']//span[text()='Loading Menus Data...']";
	private static final String Table_Values="//tbody[@class='table-body']";
	private static final String Table_Menu_CopyIcon="//table[@class='search-result']//tr[1]//td[10]//i[@title='Copy']";
	private static final String Closest_Confirm_PopUp="//div[@class='modal-content']//h5[@id='exampleModalLabel']/following::*//div[@class='content-style mb-2']";
	private static final String Closest_Confirm_PopUp_Yes="//button[@type='button' and text()='Yes']";
	private static final String Closest_Confirm_PopUp_No="//button[@type='button' ]//a[text()='No']";
	private static final String LoaderCreateMenu="//span[@class='pwm-spinner-message']//span[text()='Creating closest menu...']";
	private static final String MenuGrid_FirstValue="(//div[@class='selected-div']/following-sibling::*)[1]";
	

	

	public WebElement GetClosestMenuFilter(int i) {

		String DropDownTitle="//select[@id='dropwown - "+i+"']";

		return Element(DropDownTitle);

	}

	public String GetValuesFilter(int i) {

		String DropDownTitle="//select[@id='dropwown - "+i+"']/following-sibling::*[1]";

		return  DropDownTitle;

	}

	public boolean VerifyTotalClosestMenuFilter() {

		int Total_DropDown=ListWebElement(Total_Filters).size();

		Boolean AllElementPresent=false;

		if (Total_DropDown <= 25) {

			for (int i = 0; i < Total_DropDown; i++) {

				if (!GetClosestMenuFilter(i).isDisplayed()) 

				{
					AllElementPresent = false;
					break; 
				} 
				else {
					AllElementPresent = true;
				}
			}
			return AllElementPresent;
		}

		return false;
	}





	public boolean GetCLosestMenuPageTitle() {

		defineTheTarget=new DefineTheTarget(driver);
		rules=new Rules(driver);
		try {
			defineTheTarget.Create_Menu();
			rules.Click_On_CreateMenu();
			rules.Click_to_BuildCLosestMenu();
			return VisibilityofELement(Search_Closeset, 10);


		} catch (InterruptedException e) {

			e.printStackTrace();
		}



		return false;
	}



	public boolean VerifyClosestMenuPageFilter() {

		List<String> NumberofCycleWeeksDropDownActual=new ArrayList<String>(Arrays.asList("1","2","3","4","5","6","7","8"));
		List<String> Total_Genders_Actual=new ArrayList<String>(Arrays.asList("Male","Female","Male & Female"));
		List<String> TargetType_Actual=new ArrayList<String>(Arrays.asList("Daily Min.","Weekly Avg.","Cycle Avg."));
		List<String> PopulationType_Actual=new ArrayList<String>(Arrays.asList("Adult","Juvenile"));
		List<String> ProgramType_Actual=new ArrayList<String>(Arrays.asList("Offender","Civilian","Retail"));
		List<String> BreakFast_Actual=new ArrayList<String>(Arrays.asList("Hot","Cold"));
		List<String> Lunch_Actual=new ArrayList<String>(Arrays.asList("Hot","Cold"));
		List<String> Dinner_Actual=new ArrayList<String>(Arrays.asList("Hot","Cold"));
		List<String> Brunch_Actual=new ArrayList<String>(Arrays.asList("Hot","Cold"));
		List<String> MenuAnamolies_Actual=new ArrayList<String>(Arrays.asList("Product & Nutrition Requirements","Product Specs","Nutrition Requirements","NA"));
		List<String> BreakFast_Week_Actual=new ArrayList<String>(Arrays.asList("0","1","2","3","4","5","6","7"));
		List<String> Brunch_Week_Actual=new ArrayList<String>(Arrays.asList("0","1","2","3","4","5","6","7"));
		List<String> Lunch_Week_Actual=new ArrayList<String>(Arrays.asList("0","1","2","3","4","5","6","7"));
		List<String> Dinner_Week_Actual=new ArrayList<String>(Arrays.asList("0","1","2","3","4","5","6","7"));
		List<String> MorningSnackWeek_Actual=new ArrayList<String>(Arrays.asList("0","1","2","3","4","5","6","7"));
		List<String> AfterNoonSnackWeek_Actual=new ArrayList<String>(Arrays.asList("0","1","2","3","4","5","6","7"));
		List<String> EveningSnackWeek_Actual=new ArrayList<String>(Arrays.asList("0","1","2","3","4","5","6","7"));
		
		
		
		defineTheTarget=new DefineTheTarget(driver); 
		rules=new Rules(driver);
		traditionalMenu=new TraditionalMenu(driver);

		try {

			prop.load(fs);
			defineTheTarget.Create_Menu_For_Closest(); 
			rules.Click_On_CreateMenu();
			rules.Click_to_BuildCLosestMenu();
			VisibilityofELement(Search_Closeset, 10);


			if(VerifyTotalClosestMenuFilter()==true) {

				TestBase.result("All Closest Menu Search Filter is available", true); 


			}

			else {
				return false;
			}

			Boolean Val1=Element(Menu_Place).isDisplayed(); 
			String Max_Menu_Length=Element(Menu_Place).getAttribute("maxlength");

			if(Val1==true && Max_Menu_Length.equalsIgnoreCase("40")) {


				TestBase.result("MenuName Field is Verified", true); 


			}

			else {

				return false;
			}

			Sendval(Menu_Place, prop.getProperty("MenuName"));
			click(Search_Closeset);
			Boolean Val2=Element(Total_Filters_Disabled).isDisplayed();
			Boolean Val3=traditionalMenu.GetFirst_Menu_Name(1).isDisplayed();

			if(Val2==true && Val3==true) {

				TestBase.result("Menu name filter functionality is verified", true); 

			}

			else {
				return false;
			}


			click(Reset);  

			String NumberofCycleWeeks= GetValuesFilter(0); //Number of Cycle Weeks
			String Total_Genders = GetValuesFilter(1); //Gender
			String Target_Type=GetValuesFilter(3);    //Target Type                      
			String Population_Type=GetValuesFilter(4);//Population_Type
			String Program_Type=GetValuesFilter(8);   //Program Type                     
			String Breakfast=GetValuesFilter(9);//BreakFast
			String Lunch=GetValuesFilter(10);//lunch
			String Dinner=GetValuesFilter(11);//Dinner 
			String Brunch=GetValuesFilter(12);//Brunch
			String Menu_Anamolies=GetValuesFilter(14);//Brunch
			String BreakFast_Week=GetValuesFilter(15);//BreakfastWeek
			String Brunch_Week=GetValuesFilter(16);//Brunch_Week
			String Lunch_Week=GetValuesFilter(17);//Lunch_Week
			String Dinner_Week=GetValuesFilter(18);//Dinner_Week
			String MorningSnack_Week=GetValuesFilter(19);//MorningSnack_Week
			String AfterNoonSnack_Week=GetValuesFilter(20);//Afternoon-Snack
			String EveningSnack_Week=GetValuesFilter(21);//Eve-Snack
			
			List<String> NumberofCycleWeeksDropDown = GetDropDownOptions(NumberofCycleWeeks);  

			Boolean Vale= compareLists(NumberofCycleWeeksDropDown, NumberofCycleWeeksDropDownActual);

			if(Vale==true) {

				TestBase.result("NumberofCycleWeeksDropDown is verified", true); 
			}

			else {
				return false;
			}

			List<String> Number_of_Total_Genders=GetDropDownOptions(Total_Genders);
			Boolean Vale1=compareLists(Total_Genders_Actual, Number_of_Total_Genders);

			if(Vale1==true) {

				TestBase.result("Number_of_Total_Genders is verified", true); 
			}
			else {
				return false;
			}



			List<String> Target_Type_Values=GetDropDownOptions(Target_Type);
			Boolean Vale3=compareLists(Target_Type_Values,TargetType_Actual );

			if(Vale3==true) {

				TestBase.result("Target_Type_Values is verified", true); 
			}
			else {
				return false;
			} 

			List<String> Population_Type_Values=GetDropDownOptions(Population_Type);
			Boolean Vale4=compareLists(Population_Type_Values, PopulationType_Actual);

			if(Vale4==true) {

				TestBase.result("Population_Type_Values is verified", true); 
			}
			else {
				return false;
			} 

			List<String> Program_Type_Values=GetDropDownOptions(Program_Type);
			Boolean Vale5=compareLists(Program_Type_Values, ProgramType_Actual);

			if(Vale5==true) {

				TestBase.result("Program_Type_Values is verified", true); 
			}
			else {
				return false;
			} 


			List<String> BreakFast_Values=GetDropDownOptions(Breakfast);
			Boolean Vale6=compareLists(BreakFast_Values, BreakFast_Actual);

			if(Vale6==true) {

				TestBase.result("BreakFast_Values is verified", true); 
			}
			else {
				return false;
			} 

			List<String> Lunch_Values=GetDropDownOptions(Lunch);
			Boolean Vale7=compareLists(Lunch_Values, Lunch_Actual);

			if(Vale7==true) {

				TestBase.result("Lunch_Values is verified", true); 
			}
			else {
				return false;
			} 
			
			List<String> Dinner_Values=GetDropDownOptions(Dinner);
			Boolean Vale8=compareLists(Dinner_Values, Dinner_Actual);

			if(Vale8==true) {

				TestBase.result("Dinner_Valuesis verified", true); 
			}
			else {
				return false;
			} 
			
			List<String> Brunch_Values=GetDropDownOptions(Brunch);
			Boolean Vale9=compareLists(Brunch_Values, Brunch_Actual);

			if(Vale9==true) {

				TestBase.result("Brunch_Values is verified", true); 
			}
			else {
				return false;
			} 
			
			List<String> Menu_Anamolies_Values=GetDropDownOptions(Menu_Anamolies);
			Boolean Vale10=compareLists(Menu_Anamolies_Values, MenuAnamolies_Actual);

			if(Vale10==true) {

				TestBase.result(" Menu_Anamolies_Values is verified", true); 
			}
			
			else {
				return false;
			} 
			
			List<String> BreakFastWeek_Values=GetDropDownOptions(BreakFast_Week);
			
			
			Boolean Vale11=compareLists(BreakFastWeek_Values, BreakFast_Week_Actual);

			if(Vale11==true) {

				TestBase.result("BreakFastWeek_Values is verified", true); 
			}
			
			else {
				return false;
			} 
			
			List<String> BrunchWeek_Values=GetDropDownOptions(Brunch_Week);
			Boolean Vale12=compareLists(BrunchWeek_Values, Brunch_Week_Actual);

			if(Vale12==true) {

				TestBase.result("BrunchWeek_Values is verified", true); 
			}
			else {
				return false;
			} 
			
			List<String> LunchWeek_Values=GetDropDownOptions(Lunch_Week);
			Boolean Vale13=compareLists(LunchWeek_Values, Lunch_Week_Actual);

			if(Vale13==true) {

				TestBase.result("LunchWeek_Values is verified", true); 
			}
			else {
				return false;
			} 
			
			List<String> DinnerWeek_Values=GetDropDownOptions(Dinner_Week);
			Boolean Vale14=compareLists(DinnerWeek_Values, Dinner_Week_Actual);

			if(Vale14==true) {

				TestBase.result("DinnerWeek_Values is verified", true); 
			}
			else {
				return false;
			} 
			
			List<String> MorningSnackWeek_Values=GetDropDownOptions(MorningSnack_Week);
			Boolean Vale15=compareLists(MorningSnackWeek_Values, MorningSnackWeek_Actual);

			if(Vale15==true) {

				TestBase.result("MorningSnackWeek_Values is verified", true); 
			}
			else {
				return false;
			} 
			
			List<String> AfternoonSnackWeek_Values=GetDropDownOptions(AfterNoonSnack_Week);
			Boolean Vale16=compareLists(AfternoonSnackWeek_Values, AfterNoonSnackWeek_Actual);

			if(Vale16==true) {

				TestBase.result("AfternoonSnackWeek_Values is verified", true); 
			}
			else {
				return false;
			} 
			
			List<String> EveningSnackWeek_Values=GetDropDownOptions(EveningSnack_Week);
			Boolean Vale17=compareLists(EveningSnackWeek_Values, EveningSnackWeek_Actual);

			if(Vale17==true) {

				TestBase.result("EveningSnackWeek_Values is verified", true); 
			}
			else {
				return false;
			} 
			
			WebElement BaselineCost=GetClosestMenuFilter(13);
			Boolean isBaselineCostdisplayed=BaselineCost.isDisplayed();
			Sendval(Baseline_Cost_Max, prop.getProperty("BaselineMaxValue"));
			jsClick(Search_Closeset);
			Boolean isWarningVisible=Element(Warning_Banner).isDisplayed();
			
			if(isBaselineCostdisplayed==true && isWarningVisible==true) {
				
				TestBase.result("BaselineCost Filter and Range is verified", true); 
				
			}
			
			
			else {
				return false;
			} 
			
			Boolean IsRemoveClickable=click(Remove_Filter);
			
			Boolean	IsAddClickable=click(Add_Filter);
		    
			if(IsRemoveClickable==true && IsAddClickable==true) {
			
				TestBase.result("Add & Remove Filter is verified", true);
			}
			
			else {
				return false;
			} 
			
		} 
		

		catch (Exception e) {

			e.printStackTrace(); 

			return false;

		}
		return true;

	}
	

	public boolean Verify_Filters_are_reset_to_there_default_filters() {

		defineTheTarget=new DefineTheTarget(driver);
		rules=new Rules(driver);
		try {
			defineTheTarget.Create_Menu();
			rules.Click_On_CreateMenu();
			rules.Click_to_BuildCLosestMenu();
		    VisibilityofELement(Search_Closeset, 10);
            
		    String NumberofCycleWeeks= GetValuesFilter(0);
		    String Original_Text_CycleWeeks=GetSelectedDropDown(NumberofCycleWeeks).getText();
		    
             SelectDropDown(NumberofCycleWeeks, "7" );	
             
             String Target_Type=GetValuesFilter(3); 
             String Original_Text_Target_Type=GetSelectedDropDown(Target_Type).getText();
             
             SelectDropDown(Target_Type, "109" );
             click(Reset);
             
             String Reset_Text_CycleWeeks=GetSelectedDropDown(NumberofCycleWeeks).getText();
             
             String Reset_Text_Target_Type=GetSelectedDropDown(Target_Type).getText();
             
             if(Original_Text_CycleWeeks.equalsIgnoreCase(Reset_Text_CycleWeeks)&& Original_Text_Target_Type.equalsIgnoreCase(Reset_Text_Target_Type)) {
            	 
            	 
            	 TestBase.result("Verify Filter Reset Functionality is working", true);
            	 
             }
             
			
		} catch (InterruptedException e) {

			e.printStackTrace();
		}



		return false;
	}
	
	public boolean Verify_Search_Filter_Result() {

		defineTheTarget=new DefineTheTarget(driver);
		rules=new Rules(driver);
		try {
			defineTheTarget.Create_Menu();
			rules.Click_On_CreateMenu();
			rules.Click_to_BuildCLosestMenu();
		
		    jsClick(Search_Closeset);
		   
		    
		    String NumberofCycleWeeks= GetValuesFilter(0);
		    
             SelectDropDown(NumberofCycleWeeks, "5" );	
             
             InvisibilityofElement(LoaderChangeFilter, 10);
             
             click(Search_Closeset);
             
             Boolean Val1=VisibilityofELement(CycleValueinTable, 20);
             
		    List<WebElement> elems= Elements(RemoveAll_Filter); 
		    
           
		     for(int i=elems.size()-1; i>=0;i--) {
            	
		    	 elems.get(i).click();
		    	 
            }
		     jsClick(Search_Closeset);
             
		     InvisibilityofElement(LoaderChangeFilter, 10);
		     
		    Boolean Val2= VisibilityofELement(Table_Values, 10);
		     
		    
		    if(Val1==true && Val2==true) {
		    	
		    	 TestBase.result("Check 'Search' button functionality", true);
		    	
		    }
		    
		    else {
		    	
				return false;
			} 
		    
             }
             
			
		 catch (InterruptedException e) {

			e.printStackTrace();
		}



		return false;
	}

	
	public boolean Verify_CLosestMenu_CopyFunctionality() {

		defineTheTarget=new DefineTheTarget(driver);
		rules=new Rules(driver);
		try {
			defineTheTarget.Create_Menu();
			rules.Click_On_CreateMenu();
			rules.Click_to_BuildCLosestMenu();
		
		    jsClick(Search_Closeset);
		    
		    click(Table_Menu_CopyIcon);    
		    
		    Boolean Val1=VisibilityofELement(Closest_Confirm_PopUp, 20);
		    
		    click(Closest_Confirm_PopUp_No);
		    
		   Boolean Val2= InvisibilityofElement(Closest_Confirm_PopUp, 20);
		    
	       
		   if(Val1==true && Val2==true) {
			   
			   TestBase.result("Verfied Copy Closest Menu Functionality With 'No' Option", true);
		   }
		   
		   else {
		    	
				return false;
			} 
		   
		   Thread.sleep(2000);
		   jsClick(Table_Menu_CopyIcon); 
		   
		    Boolean Val3=VisibilityofELement(Closest_Confirm_PopUp, 10);
		    
		    click(Closest_Confirm_PopUp_Yes);
		    
		    InvisibilityofElement(LoaderCreateMenu, 600);
		    
		    Boolean Val4=VisibilityofELement(MenuGrid_FirstValue, 80);
		    
		    if(Val3==true && Val4==true) {
				   
				   TestBase.result("Veried Copy Closest Menu Functionality With 'Yes' Option", true);
			   }
		    
			   
			   else {
			    	
					return false;
				} 
		   
		}
		
		    catch (InterruptedException e) {

				e.printStackTrace();
				return false;
			}


      return false;
			
		}

}
