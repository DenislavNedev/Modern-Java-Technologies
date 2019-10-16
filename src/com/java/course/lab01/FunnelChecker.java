package com.java.course.lab01;

public class FunnelChecker {
    public static boolean isFunnel(String str1, String str2) {
        if (str1.length() - str2.length() != 1) {
            return false;
        }

        for (int i = 0; i < str1.length(); i++) {
            String newStr1 = deleteCharFromString(str1, i);
            if (newStr1.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    private static String deleteCharFromString(String currentString, int position) {
        StringBuilder stringWithoutOneChar = new StringBuilder(currentString);
        stringWithoutOneChar.deleteCharAt(position);
        return stringWithoutOneChar.toString();
    }
}
