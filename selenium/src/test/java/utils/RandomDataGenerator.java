
package utils;

import java.util.Random;

public class RandomDataGenerator {

    public static String generateEmail() {
        return "auto" + System.currentTimeMillis() + "@gmail.com";
    }

    public static String generatePhone() {
        Random r = new Random();
        int num = 900000000 + r.nextInt(99999999);
        return String.valueOf(num);
    }
}
