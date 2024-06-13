package PageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;

import StepDefinitions.TestBase;

public class RecipesSearch extends TestBase {

	public  WebDriver driver;


	public RecipesSearch(WebDriver driver) {

		this.driver=driver;

	}


	private static final String RecipeSearch="//input[@id='recipeModuleSearchInput' and @placeholder='(use * for wildcard)']";
	private static final String LoaderFetchRecipe="//span[@class='pwm-spinner-message']//span[text()='Fetching Recipes']";
	private static final String Loader1="//span[@class='pwm-spinner-message']//span[text()='Loading...']";
	private static final String firstRecipe="//div[@role='gridcell']//a[@title='BEANS, BAKED, VEGETARIAN (CANNED)-COR recipeSeq: 20006610 ']";
	private static final String LoaderRecieveRecipe="//span[@class='pwm-spinner-message']//span[text()='Receiving recipe data...']";
	private static final String Ingredients="//div[@class='custom-table-header-item']//span[text()='Ingredient']";
	private static final String LoaderFetchingNutritiondata="//span[@class='pwm-spinner-message']//span[text()='Fetching Nutrition Data']";
	private static final String SubsituteRecipies="//div[@class='it-cell substitute-description']";




	public Boolean SearchRecipes() {

		try {
			prop.load(fs);
			Sendval(RecipeSearch, prop.getProperty("RECIPEID"));
			ClickActionEnter(RecipeSearch);
			InvisibilityofElement(Loader1, 20);
			VisibilityofELement(LoaderFetchRecipe, 20);
			InvisibilityofElement(LoaderFetchRecipe, 40);
			Thread.sleep(3000);			
			click(firstRecipe);
			InvisibilityofElement(LoaderRecieveRecipe, 100);
			VisibilityofELement(LoaderFetchingNutritiondata, 60);
			InvisibilityofElement(LoaderFetchingNutritiondata, 60);
			ScrollElement(Element(Ingredients));

		} catch (InterruptedException | IOException e) {

			e.printStackTrace();
		}



		return true;


	}

	public  List<String> getSubsituteRecipies() {

		List<String> Substitute_Recipies=ListStringElements(SubsituteRecipies);



		return Substitute_Recipies;

	}





}
