package PageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import StepDefinitions.TestBase;
import utils.ReadExcelFile;
import utils.RegularExpression;



public class IBAobj extends TestBase {

	public static  WebDriver driver;
	DefineTheTarget defineTheTarget;
	Rules rules;
	TraditionalMenu traditionalMenu;
	RegularExpression regularExpression;
	MenuGrid menuGrid;
	RecipesSearch recipesSearch;


	public  IBAobj(WebDriver driver) {

		IBAobj.driver=driver;

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
	private static final String GI_NoMenu="//li//span[text()='-EGG OMELET PLAIN 5.5\" 3 OZ CKD FZ CAGE FREE']";
	private static final String NoMenuFoundText="//table/following::*/..//span[contains(text(),'No Menu Found')]";
	private static final String SearchMenuIBA="//input[@type='text' and @placeholder='Menu Name/Distribution/Notes']";
	private static final String CrossIconMenuSearch="//input[@type='text']/following-sibling::*//i";
	private static final String DropDownPagination="//label/following::*//Select[@class='form-control pagination-size']";
	private static final String ExportToExcel="//div[text()='Export to Excel']";
	private static final String Totalofoccurrences ="//table//tbody//tr//td[7]";
	private static final String tablevaluetoclick="//table//tr[2]";
	private static final String NewRecipes="//button[@type='button']//span[text()='New Recipes']";
	private static final String Recipes="//a[@class='page-header-option2']//span[text()='Recipes']";
	private static final String LoaderFetchRecipe="//span[@class='pwm-spinner-message']//span[text()='Fetching Recipes']";
	private static final String FirstRecipeSwap="(//div[@title='Swap'])[1]";
	private static final String LoaderRecipes="//span[@class='pwm-spinner-message']//span[text()='Loading Recipes...']";
	private static final String SearchSwap="//input[@placeholder='Search by ID']";
	private static final String FirsrRecipeonSwap="(//table[@class='table']//tr//td[1]//div/following-sibling::*)[1]";
	private static final String Swapbutton="//span[@class='search-icon-input']/following-sibling::*";
	private static final String SwapSucess="//span[text()='Recipe(s) has been swapped successfully.']";
	private static final String SwapRadioButton="(//table[@class='table']//tr//td[1]//div//span)[1]";
	private static final String SwapRecommendation="//span[@class='mr-4']/following-sibling::*";
	private static final String SwappingRecipesLoader="//span[@class='pwm-spinner-message']//span[text()='Swapping Recipe...']";
	private static final String CrossButtonSwapRecipe="//button[@type='button' and text()='✕']";
	private static final String LoaderGlobal="//span[@class='pwm-spinner-message']";



	//table//th/following::*//tr//td[4]

	public WebElement GetCheckboxGI(int i) {

		String CheckboxGI="//input[@type='checkbox' and @id='A"+i+"']";

		return Element(CheckboxGI);
	}


	public boolean ValidateUI_IBA() {


		try {

			InvisibilityofElement(Loader1, 8);

			if( (VisibilityofELement(IBATitle, 10)==true &&
					VisibilityofELement(General_Item, 10)==true && InvisibilityofElement(ExportToExcel, 10)==true))
			{
				TestBase.result("Verifed IBA Page and General_Item Serach is visible and ExportToExcel is Invisible " , true);
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

		List<String> ActualHeaderValues=new ArrayList<String>(Arrays.asList("DISTRIBUTION","MENU NAME","REGION NAME","STATUS","NOTES","# OF RECIPES","TOTAL # OF OCCURRENCES"));



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
					break;

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

		String Deafault_Selected_Option=GetSelectedDropDown(SelectStatusDropDown).getText();

		if (Deafault_Selected_Option.contains(prop.getProperty("InitailDropDownValue"))) {

			TestBase.result("Check on right hand side, Status dropdown is getting displayed by default option as Finalized", true);

		} else {

			return false;
		}



		Boolean VerifedFinalizedDropDown=ListStringElements(StatusValues).containsAll(FinalizedDropDown);// Selected Finalized and Compared

		SelectDropDown(SelectStatusDropDown, "1");// Selected Recently Added

		InvisibilityofElement(Loader, 20);

		Boolean VerifedRecentlyAddedDropDown=ListStringElements(StatusValues).containsAll(RecentlyAddedDropDown);

		InvisibilityofElement(Loader, 20);




		SelectDropDown(SelectStatusDropDown, "0");// Selected all values

		InvisibilityofElement(Loader, 20);

		Boolean VerifedALLDropDown=ListStringElements(StatusValues).containsAll(AllAddedDropDown);

		InvisibilityofElement(Loader, 20);

		Element(GI_NoMenu).click();
		InvisibilityofElement(Loader, 20);
		Boolean IsMenuVisible=Element(NoMenuFoundText).isDisplayed();

		if (IsMenuVisible==true) {

			TestBase.result("Validate if there is no relevant menu found then it is showing message as 'No Menu Found'", true);

		} else {

			return false;
		}


		if (VerifedALLDropDown==true && VerifedRecentlyAddedDropDown==true &&  VerifedFinalizedDropDown==true) {

			TestBase.result("Verified  Filter by Status functionality", true);
			return true;

		} else {

			return false;

		}

	}

	public Boolean  VerifyMenuSearchIBA() {

		String SearchValue=prop.getProperty("GeneralItemValue");

		try {
			Sendval(General_Item, SearchValue);
			InvisibilityofElement(Loader, 10);
			VisibilityofELement(SearchListText, 10);
			List<WebElement> Complete_Element_List=ListWebElement(SearchListText);

			Complete_Element_List.get(0).click();
			InvisibilityofElement(Loader, 10);

			VisibilityofELement(SearchMenuTable, 10);
			String FirstMenuName=GetTableValueByIndex(1, 2);

			Sendval(SearchMenuIBA, FirstMenuName);

			ClickActionEnter(SearchMenuIBA);
			InvisibilityofElement(Loader, 10);
			VisibilityofELement(SearchMenuTable, 10);
			String SearchMenu=GetTableValueByIndex(1, 2);

			if (FirstMenuName.equalsIgnoreCase(SearchMenu)) {

				TestBase.result("Verified User is able to search by Menu Name ", true);

			} else {

				return false;
			}

			Element(SearchMenuIBA).clear();
			String DistributionId=GetTableValueByIndex(1, 1);
			Sendval(SearchMenuIBA, DistributionId);
			ClickActionEnter(SearchMenuIBA);
			InvisibilityofElement(Loader, 10);
			VisibilityofELement(SearchMenuTable, 10);
			String SearchMenuByDistributionID=GetTableValueByIndex(1, 1);


			if (DistributionId.equalsIgnoreCase(SearchMenuByDistributionID)) {

				TestBase.result("Verified User is able to search by DistributionId ", true);

			} else {

				return false;

			}

			Element(SearchMenuIBA).clear();
			String Notes=GetTableValueByIndex(1, 5);
			Sendval(SearchMenuIBA, Notes);
			ClickActionEnter(SearchMenuIBA);
			InvisibilityofElement(Loader, 10);
			VisibilityofELement(SearchMenuTable, 10);
			String NotesSearched=GetTableValueByIndex(1, 1);

			if (Notes.equalsIgnoreCase(NotesSearched)) {

				TestBase.result("Verified User is able to search by Notes ", true);

			} else {

				return false;

			}


			Element(SearchMenuIBA).clear();
			Sendval(SearchMenuIBA, prop.getProperty("MenuName"));
			ClickActionEnter(SearchMenuIBA);
			InvisibilityofElement(Loader, 10);
			Boolean isTableVisible=VisibilityofELement(SearchMenuTable, 10);
			if (isTableVisible==true) {

				TestBase.result("Verified User is able to Partialsearch ", true);

			} else {

				return false;

			}

			Element(CrossIconMenuSearch).click();
			InvisibilityofElement(Loader, 10);
			Boolean isPlaceholderEmpty=Element(SearchMenuIBA).getAttribute("value").isEmpty();
			if (isPlaceholderEmpty==true) {

				TestBase.result("Verified Clicking on cross icon for Search By Menu/Distribution/Notes  should clear the text  ", true);

			} else {

				return false;

			}



			return true;

		} catch (InterruptedException e) {
			e.printStackTrace();
		}


		return false;


	}


	public Boolean Check_PaginationFunctionalityIBA() {



		try {
			prop.load(fs);

			String SearchValue=prop.getProperty("GeneralItemValue2");

			Sendval(General_Item, SearchValue);

			InvisibilityofElement(Loader, 10);

			String GiItemToClickText=prop.getProperty("GIitemToClickForPagination");
			VisibilityofELement(SearchListText, 20);
			List<WebElement> Complete_Element_List=ListElementsbyWait(SearchListText, 20);


			for(int i=0; i<Complete_Element_List.size();i++) {


				Boolean isElementAvailable=Complete_Element_List.get(i).getText().trim().equalsIgnoreCase(GiItemToClickText);

				if (isElementAvailable==true) {
					ClickAction(Complete_Element_List.get(i));
					InvisibilityofElement(Loader, 10);
					break;
				}

			}

			SelectDropDown(SelectStatusDropDown, "0");// Selected all values
			InvisibilityofElement(Loader, 20);

			String initiallySelectedDropDown=GetSelectedDropDown(DropDownPagination).getText();
			int NoofMenus=ListWebElement(StatusValues).size();

			if (initiallySelectedDropDown.equals("20")&& NoofMenus==20) {

				TestBase.result("Verified initial page Drop down Value Should be 20 and Menu Showed are 20", true);

			} else {

				return false;

			}

			SelectDropDown(DropDownPagination, "10");
			InvisibilityofElement(Loader, 10);
			String NewSelectedDropDown=GetSelectedDropDown(DropDownPagination).getText();
			int NoofMenusfor10=ListWebElement(StatusValues).size();	

			if (NewSelectedDropDown.equals("10")&& NoofMenusfor10==10) {

				TestBase.result("Verified  page Drop down Value Should be 10 and Menu Showed are 10", true);

			} else {

				return false;

			}

			SelectDropDown(DropDownPagination, "50");
			InvisibilityofElement(Loader, 10);
			String NewSelectedDropDownfor50=GetSelectedDropDown(DropDownPagination).getText();
			int NoofMenusfor50=ListWebElement(StatusValues).size();	

			if (NewSelectedDropDownfor50.equals("50")&& NoofMenusfor50==50) {

				TestBase.result("Verified  page Drop down Value Should be 50 and Menu Showed are 50", true);

			} else {

				return false;

			}


			return true;

		} catch (Exception e) {

			e.printStackTrace();
		}



		return true;
	}	


	public Boolean CheckExportTableData() throws InterruptedException {

		MenuCheckRightPanel();
		click(ExportToExcel);
		Thread.sleep(10000);
		Boolean Val=ReadExcelFile.ReadTabledata(FileDownloadPath);
		try {
			ReadExcelFile.deleteFile(FileDownloadPath);
		} catch (IOException e) {

			e.printStackTrace();
		}

		if(Val==true) {
			TestBase.result("Verified Table values are coming same as in Exported Table ", true);
		}

		else {

			return false;
		}
		return Val;

	}

	public static  List<String> getIBATabledata(int i) {
		List<String> data=new ArrayList<String>();

		List<WebElement> elem=driver.findElements(By.xpath("//table//tr["+i+"]//td"));
		for(WebElement e:elem) {
			String Textvalue=e.getText();
			data.add(Textvalue);
		}
		return data;

	}

	public Boolean TotalOccurenceOrder()  {

		MenuCheckRightPanel();
		Boolean val=isDescendingOrder(ListIntElements(Totalofoccurrences));

		if(val==true) {
			TestBase.result("Verified Totalofoccurrences are coming  in descending order", true); 
			return true;
		}

		else {

			return false;
		}




	}

	public Boolean Verify_GI_For_IBA_on_Menurgrid()  {

		Boolean val;
		try {
			menuGrid=new MenuGrid(driver);
			MenuCheckRightPanel();
			click(tablevaluetoclick);
			InvisibilityofElement(Loader, 40);
			val = menuGrid.User_MoveTo_GI_Overview();

			if(val==true) {

				TestBase.result("Verified all the UI is available on IBA Page  ", true); 
				return true;
			}

			else {

				return false;
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return false;

	}


	public Boolean VerifySubstituteItem() {

		menuGrid=new MenuGrid(driver);
		recipesSearch=new RecipesSearch(driver);
		MenuCheckRightPanel();
		click(tablevaluetoclick);
		InvisibilityofElement(Loader, 40);
		menuGrid.User_AddRecipe();

		try {
			String url=getCurrentURL();
			OpenNewWindowTab();
			SwitchWindow(1);

			driver.get(url);
			InvisibilityofElement(Loader1, 40);
			jsClick(NewRecipes);
			jsClick(Recipes);

			InvisibilityofElement(Loader1, 30);
			InvisibilityofElement(LoaderFetchRecipe, 20);
			VisibilityofELement(Loader, 20);
			InvisibilityofElement(Loader, 15);		

			recipesSearch.SearchRecipes();
			List<String> Recipies=recipesSearch.getSubsituteRecipies();

			List<String> NewRecipiesList=new ArrayList<String>();

			for(String Recipe:Recipies) {

				String[] RecipeArray=Recipe.split("Substitute - ");
				String ActualSubRecipesRaw=RecipeArray[1];

				if (ActualSubRecipesRaw.contains(", DICED /")) {

					String [] c= ActualSubRecipesRaw.split(" /");

					String OptionalPart=c[1]; //cooked
					String FirstPart=c[0];//
					String SecondPart= FirstPart.substring(0, FirstPart.lastIndexOf(","))+","+OptionalPart;
					NewRecipiesList.add(FirstPart);
					NewRecipiesList.add(SecondPart);

				}

				else if (ActualSubRecipesRaw.contains("(SYSCO) /")) {
					String [] c= ActualSubRecipesRaw.split("/");
					String OptionalPart=c[1]; //cooked
					String FirstPart=c[0];//
					String SecondPart= FirstPart.substring(0, FirstPart.lastIndexOf("("))+OptionalPart;
					NewRecipiesList.add(FirstPart);
					NewRecipiesList.add(SecondPart);

				}

				else if (ActualSubRecipesRaw.contains("DICED /")) {
					String [] c= ActualSubRecipesRaw.split("/");
					String OptionalPart=c[1]; //cooked
					String FirstPart=c[0];//
					String SecondPart= FirstPart.substring(0, FirstPart.lastIndexOf("DICED"))+OptionalPart;
					NewRecipiesList.add(FirstPart);
					NewRecipiesList.add(SecondPart);

				}

				else if (!ActualSubRecipesRaw.contains("/")) {

					NewRecipiesList.add(ActualSubRecipesRaw);
				}


			}

			SwitchWindow(0);
			menuGrid.User_MoveTo_GI_Overview();
			List<String> GIMenuInsights=menuGrid.getGIfromMenuInsight();

			if (!GIMenuInsights.contains(NewRecipiesList)==true) {

				TestBase.result("Verified Substitute item should not get displayed as GI under GI tab ", true); 
				return true;


			} else {

				return false;
			}

		}

		catch (InterruptedException e) {

			e.printStackTrace();
		}

		return false;

	}

	public Boolean SwapRecipe() {

		try {
			MenuCheckRightPanel();
			click(tablevaluetoclick);
			InvisibilityofElement(Loader, 40);
			Element(FirstRecipeSwap).click();
			InvisibilityofElement(LoaderRecipes, 20);
			Sendval(SearchSwap, Element(FirsrRecipeonSwap).getText());
			Element(Swapbutton).click();
			Boolean isRecipeSwapped=VisibilityofELement(SwapSucess, 20);//
			Element(CrossButtonSwapRecipe).click();
			Element(FirstRecipeSwap).click();
			InvisibilityofElement(LoaderRecipes, 20);
			Element(SwapRadioButton).click();
			Element(SwapRecommendation).click();
			Boolean isRecipeSwappedRec=VisibilityofELement(SwapSucess, 20);//

			if (isRecipeSwapped==true && isRecipeSwappedRec==true ) {

				TestBase.result("Check user can swap recipes- By manually and By Recommendation engine", true); 
				return true;

			} else {

				return false;
			}

		} catch (Exception e) {


			e.printStackTrace();
		}

		return false;

	}

	public Boolean SwapRecipeCopyMenu() {

		try {

			Element(FirstRecipeSwap).click();
			InvisibilityofElement(LoaderRecipes, 20);
			Sendval(SearchSwap, Element(FirsrRecipeonSwap).getText());
			Element(Swapbutton).click();
			Boolean isRecipeSwapped=VisibilityofELement(SwapSucess, 20);//
			Element(CrossButtonSwapRecipe).click();
			Element(FirstRecipeSwap).click();
			InvisibilityofElement(LoaderRecipes, 20);
			Element(SwapRadioButton).click();
			Element(SwapRecommendation).click();
			Boolean isRecipeSwappedRec=VisibilityofELement(SwapSucess, 20);//

			if (isRecipeSwapped==true && isRecipeSwappedRec==true ) {

				TestBase.result("Check user can swap recipes- By manually and By Recommendation engine", true); 
				return true;

			} else {

				return false;
			}

		} catch (Exception e) {


			e.printStackTrace();
		}

		return false;

	}


	public boolean validateRegionNameandVerify() {

		try {
			menuGrid=new MenuGrid(driver);
			defineTheTarget=new DefineTheTarget(driver);
			MenuCheckRightPanel();
			click(tablevaluetoclick);
			VisibilityofELement(Loader, 2);
			InvisibilityofElement(Loader, 40);
			menuGrid.ClickKPIArrowDown();
			menuGrid.ClickEditTargetButton();
			VisibilityofELement(LoaderGlobal, 2);
			InvisibilityofElement(LoaderGlobal, 20);
			InvisibilityofElement(LoaderGlobal, 20);
			defineTheTarget.selectRegion();
			defineTheTarget.click_SaveButton();
		

		} catch (Exception e) {

			e.printStackTrace();
		}
		return true;


	}
}





