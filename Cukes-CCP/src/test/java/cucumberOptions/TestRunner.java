package cucumberOptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

         features="src/test/java/features" ,
          glue="StepDefinitions" , 
          monochrome=true , 
        //  dryRun=true,
         // tags= "@test",
          plugin={"pretty" , "html:target/cucumber.html" , "json:target/cucumber.json"} )

public class TestRunner extends AbstractTestNGCucumberTests {

	
	 @Override
	    @DataProvider(parallel = false)
	    public Object[][] scenarios() {
		 
	        return super.scenarios();
	    }
	
}
	