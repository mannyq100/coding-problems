package arrays;

import java.util.HashMap;
import java.util.Map;
/*
Given two strings s and t of lengths m and n respectively,
return the minimum window substring of s such that every character
in t (including duplicates) is included in the window.
If there is no such substring, return the empty string "".
 */
public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String str1[] = {"ahffaksfajeeubsne", "jefaa"};
        //Output = aksfaje
        System.out.println(minWindow(str1));

        String str2[] = {"aaffhkksemckelloe", "fhea"};
        //Output = affhkkse
        System.out.println(minWindow(str2));
    }

    public static String minWindow(String[] strArr) {
        Map<Character, Integer> Kmap = new HashMap<>();
        String Nstring = strArr[0];
        String Kstring = strArr[1];

        for (char c : Kstring.toCharArray()) {
            Kmap.put(c, Kmap.getOrDefault(c, 0) + 1);
        }

        int count = Kstring.length();
        int l = 0, r = Nstring.length();
        int start = 0, tail = 0, width = Integer.MAX_VALUE;

        while (l < r) {
            char c = Nstring.charAt(l);
            if (Kmap.containsKey(c)) {
                int cCount = Kmap.get(c) - 1;
                Kmap.put(c, cCount);
                if (cCount >= 0)
                    count--;

            }
            while (count == 0) {
                if (l - start + 1 < width) {
                    width = l - start + 1;
                    tail = start;
                }
                char leftC = Nstring.charAt(start);
                if (Kmap.containsKey(leftC)) {
                    if (Kmap.get(leftC) == 0) {
                        count++;
                    }
                    Kmap.put(leftC, Kmap.get(leftC) + 1);
                }
                start++;
            }

            l++;
        }
        return Nstring.substring(tail, tail + width);
    }
}
