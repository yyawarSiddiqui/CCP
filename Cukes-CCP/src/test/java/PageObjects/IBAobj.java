package PageObjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import StepDefinitions.TestBase;
import utils.RegularExpression;



public class IBAobj extends TestBase {

	public  WebDriver driver;
	DefineTheTarget defineTheTarget;
	Rules rules;
	TraditionalMenu traditionalMenu;
	RegularExpression regularExpression;

	public  IBAobj(WebDriver driver) {

		this.driver=driver;

	}


	private static final String IBATitle="//span[contains(text(),'Ingredient Based Analysis')]";
	private static final String General_Item="//input[@type='search'  or @placeholder='General Item (GI)']";
	private static final String AllCheckboxGI="//div[@class='cstm-checkbox']/..";
	private static final String Loader="//span[@class='pwm-spinner-message']//span[text()='Loading Menu Items...']";
	private static final String SearchListText="//ul//li//span";
	private static final String Loader1="//span[@class='pwm-spinner-message']//span[text()='Loading...']";
	private static final String EnableTextAndValue="//label[@for='A1']";
	private static final String SearchMenuTable="//table//thead//tr//button";
	private static final String SelectedGI="//h3";
	private static final String SelectStatusDropDown="(//span/following-sibling::*//option/..)[2]";
	private static final String StatusValues="//table//tbody//tr//td[3]";
	
	
	
	

	public WebElement GetCheckboxGI(int i) {

		String CheckboxGI="//input[@type='checkbox' and @id='A"+i+"']";

		return Element(CheckboxGI);
	}


	public boolean ValidateUI_IBA() {


		try {

			InvisibilityofElement(Loader1, 8);
			if( (VisibilityofELement(IBATitle, 10)==true &&
					VisibilityofELement(General_Item, 10)==true ))
			{
				TestBase.result("Verifed IBA Page and General_Item Serach is visible", true);
			}

			else {

				return false ;
			}

			if (GetCheckboxGI(1).isSelected()==true && Element(AllCheckboxGI).isDisplayed()==true ) {

				TestBase.result("Verifed Enable Checkbox is selected By Default", true);

			} else {

				return false ;
			}

			return true;


		} catch (Exception e) {

			e.printStackTrace();

		}
		return false;
	}


	public Boolean GISerchFilter() {


		try {
			prop.load(fs);

			String SearchValue=prop.getProperty("GeneralItemValue");
			Boolean Val2=Sendval(General_Item, SearchValue);


			InvisibilityofElement(Loader, 10);

			if (Val2==true) {

				TestBase.result("Verifed The general item list should get populated after entering 3 chars", true);

			} else {

				return false;

			}

			VisibilityofELement(SearchListText, 10);
			List<String> Complete_Text_List=ListStringElements(SearchListText);


			Boolean Val=false;
			for(int i=0; i<Complete_Text_List.size();i++) {

				Val=Complete_Text_List.get(i).contains(SearchValue);

				if(Val==false)
				{
					break;
				}

			}


			if (Val==true) {

				TestBase.result("Verifed General item list related to 'Given Text' should get displayed", true);

			} else {

				return false;

			}

			String str =Element(EnableTextAndValue).getText();
			Boolean isGettingItem=RegularExpression.checkStringAgainstRegex("Enabled \\[[1-9]\\d*\\]", str);

			if (isGettingItem==true) {

				TestBase.result("Verifed After searching any GI,it should show Enabled count in brackets and Disabled count as 0", true);

			} else {

				return false;
			}


			return true;


		} catch (Exception e) {

			e.printStackTrace();
		}

		return false;
	}


	public Boolean MenuCheckRightPanel() {

		List<String> ActualHeaderValues=new ArrayList<String>(Arrays.asList("DISTRIBUTION","MENU NAME","STATUS","NOTES","# OF RECIPES","TOTAL # OF OCCURRENCES"));



		try {
			prop.load(fs);

			String SearchValue=prop.getProperty("GeneralItemValue2");

			Sendval(General_Item, SearchValue);

			InvisibilityofElement(Loader, 10);

			String GiItemToClickText=prop.getProperty("GIitemToClick");

			VisibilityofELement(SearchListText, 10);
			List<WebElement> Complete_Element_List=ListWebElement(SearchListText);


			for(int i=0; i<Complete_Element_List.size();i++) {

				Boolean isElementAvailable=Complete_Element_List.get(i).getText().contentEquals(GiItemToClickText);


				if (isElementAvailable==true) {

					Complete_Element_List.get(i).click();
					InvisibilityofElement(Loader, 10);

				}

			}

			Boolean isSearchTableVisible=Element(SearchMenuTable).isDisplayed();

			if (isSearchTableVisible==true) {

				TestBase.result("After searching specified GI,it should show menus on right hand side", true);

			} else {

				return false;
			}

			List<String> TableHeaderValues=ListStringElements(SearchMenuTable);


			if (TableHeaderValues.equals(ActualHeaderValues)) {

				TestBase.result("Columns should be Distribution,Menu Name,Status,Notes,# of Recipes and Total # Ocurrences", true);

			} else {

				return false;
			}

			if (Element(SelectedGI).getText().contains(GiItemToClickText)==true) {

				TestBase.result("Check after selecting specified GI,On right side at top,it is showing selected GI item name with id ", true);

			}

			else {	
				return false;
			}
			
			return true;

		} catch (Exception e) {

			e.printStackTrace();
		}

		return true;

	}


	public boolean VerifyStatusDropDownFunctionality() {
		
		
		MenuCheckRightPanel();
		List<String> FinalizedDropDown=new ArrayList<String>(Arrays.asList("Finalized"));
		List<String> RecentlyAddedDropDown=new ArrayList<String>(Arrays.asList("Recently Added"));
		List<String> AllAddedDropDown=new ArrayList<String>(Arrays.asList("Recently Added","Finalized"));
		
		Boolean VerifedFinalizedDropDown=ListStringElements(StatusValues).containsAll(FinalizedDropDown);// Selected Finalized and Compared
		
		
		
		
		SelectDropDown(SelectStatusDropDown, "1");// Selected Recently Added
		
		InvisibilityofElement(Loader, 20);
		
		Boolean VerifedRecentlyAddedDropDown=ListStringElements(StatusValues).containsAll(RecentlyAddedDropDown);
		
		InvisibilityofElement(Loader, 20);
		
		
		
		
		SelectDropDown(SelectStatusDropDown, "0");// Selected all values
		
        InvisibilityofElement(Loader, 20);
		
        Boolean VerifedALLDropDown=ListStringElements(StatusValues).containsAll(AllAddedDropDown);
		
		InvisibilityofElement(Loader, 20);
		
		if (VerifedALLDropDown==true && VerifedRecentlyAddedDropDown==true &&  VerifedFinalizedDropDown==true) {
			
			TestBase.result("Verified  Filter by Status functionality", true);
			return true;
			
		} else {
			
			return false;
			
		}
		
		
		
	}


}
