package utils;
import com.github.javafaker.Faker;

public class generateString {

	public static String RandaomName()
	{
		
		Faker faker = new Faker();
        String fullName = faker.cat().name();
        return fullName;
		
	}     
		

}
