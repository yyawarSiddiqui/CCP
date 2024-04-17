package utils;

import java.util.Random;

public class RandomStringGenerator {
    
    public static String generateRandomString(int length) {
    	
        // Characters to be used in generating the random string
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();

        
        
        Random random = new Random();

        // Generate random characters and append them to the StringBuilder
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            sb.append(randomChar);
        }

        // Convert StringBuilder to String and return
        return sb.toString();
    }

   
}

