package string;

import java.util.HashSet;
import java.util.Set;

public class StringProblems {
    /*
     * Given a string, find all substrings that are palindrome
     * */

    public static void main(String[] args) {
        Set<String> palindromeSubstrings = getAllPalindromeSubstring("ababcdcd");
        System.out.println("All Palindrome Substrings Optimized " + palindromeSubstrings);

    }

    private static Set<String> getAllPalindromeSubstring(String str) {
        Set<String> result = new HashSet<>();
        if (str.length() == 0) return result;

        for (int i = 0; i < str.length(); i++) {
            getPalindromeFromString(str, i, i, result);
        }
        return result;
    }

    private static void getPalindromeFromString(String str, int start, int end, Set<String> result) {
        while (start >= 0 && end < str.length() && (str.charAt(start) == str.charAt(end))) {
            result.add(str.substring(start, end + 1));
            start--;
            end++;
        }
    }
}
