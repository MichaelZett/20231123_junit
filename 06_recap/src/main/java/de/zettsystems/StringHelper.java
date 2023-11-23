package de.zettsystems;

public class StringHelper {

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public static String reverse(String str) {
        if (str == null) {
            return null;
        }
        return new StringBuilder(str).reverse().toString();
    }

    public static boolean isPalindrome(String str) {
        if (str == null) {
            return false;
        }
        return str.equals(reverse(str));
    }
}