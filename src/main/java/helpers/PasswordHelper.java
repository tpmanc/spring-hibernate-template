package helpers;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class PasswordHelper {
    private static String salt = "$1a$84$0b5oFk5Kncd2gJS7QdFbze";

    public static String generatePasswordHash(String password) {
        return BCrypt.hashpw(password, salt);
    }

    public static boolean validatePassword(String password, String passwordHash) {
        if (passwordHash.equals(generatePasswordHash(password))) {
            return true;
        }
        return false;
    }
}