package com.java.course.lab01;

import java.util.Arrays;

public class WordAnalyzer {
    public static String getSharedLetters(String word1, String word2) {
        String sharedLetters = "";
        word1 = word1.toLowerCase();
        word2 = word2.toLowerCase();

        for (int i = 0; i < word1.length(); i++) {
            if (word2.indexOf(word1.charAt(i)) >= 0) {
                sharedLetters = sharedLetters.concat(String.valueOf(word1.charAt(i)));
            }
        }

        if (sharedLetters.equals("")) {
            return sharedLetters;
        }

        return sortString(sharedLetters);
    }

    private static String sortString(String original) {
        char[] array = original.toCharArray();
        Arrays.sort(array);
        return new String(array);
    }
}
