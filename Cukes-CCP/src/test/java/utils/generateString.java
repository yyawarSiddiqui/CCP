package utils;
import com.github.javafaker.Faker;

public class generateString {

	public static void main(String[] args) {
	System.out.println(RandaomName());
	
	}
	
	
	public static String RandaomName()
	{
		
		Faker faker = new Faker();
        String fullName = faker.regexify("^[A-Za-z][A-Z]{7,29}$");
        return fullName;
		
	}     
		

}
