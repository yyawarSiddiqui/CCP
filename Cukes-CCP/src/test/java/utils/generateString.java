package utils;
import java.util.Random;

public class generateString {

    public static void main(String[] args) {
        System.out.println(generateMenuString());
    }

    public static String generateMenuString() {
        String menuName = "MenuCreation";
        Random random = new Random();
        int randomNumber = random.nextInt(9000) + 1000; // Generates a random 2-digit number
        return menuName + randomNumber;
    }

}
