package utils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {


	public static boolean checkStringAgainstRegex(String re, String str) {


		Pattern pattern=Pattern.compile(re);// * after letter means unlimited count of them (Greedy quantifiers)
		Matcher matcher=pattern.matcher(str);
		Boolean val=matcher.matches();
		return val; 

	}

	public static void main(String[] args) {





		checkStringAgainstRegex("[a-z]", "c");  // Returns true  if we give only one 

		checkStringAgainstRegex("[A-Z]", "X"); //  Returns true  if we give only one  in CAPS

		checkStringAgainstRegex("[A-Z a-z]", "y");// Returns true  if we give only one  in CAPS or Small case


		checkStringAgainstRegex("[A-Z a-z]+", "yASDFe");//+ makes you enter Multiple character in Caps or Small


		// 1. Create a Regex that accepts alphanum characters only//

		checkStringAgainstRegex("[A-Z a-z 0-9]+", "9");

		// 2. Create a Regex that accepts alphanum characters and a Special char as '#'//
		checkStringAgainstRegex("[0-9#]+", "#");


		// 1. Create a Regex that accepts 10 digit Number only//

		checkStringAgainstRegex("[0-9]{10}", "1234567892");


		// 1. Create a Regex that matches Email address//

		checkStringAgainstRegex("^[a-zA-Z0-9._%+-=]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", "ydfg@fdjf.sds");


		// 1. Create a Regex that Contains Letter, Number and @, $ only//
		
		checkStringAgainstRegex("^[a-zA-Z0-9@$]+$", "Enabled [64]");
		
	    	
    
	//	checkStringAgainstRegex("Enabled \\\\[[1-9]\\\\d*\\\\]", "Enabled [64]");

	}

}


