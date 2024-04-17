package utils;
import com.github.javafaker.Faker;

public class Faker_generate {

	public static String main(String[] args) {
        Faker faker = new Faker();
        String fullName = faker.cat().name();
        return fullName;
}
}
