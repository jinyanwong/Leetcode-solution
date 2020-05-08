package Leetcode_solution;

import java.util.ArrayList;
import java.util.List;

/**
 * blog : https://jinyanwong.blog.csdn.net/article/details/105988270
 *
 * @author jinyanwong
 */
public class Leetcode459_duplicate_substring {

    public static boolean solution(String s) {
        if (s.length() < 2) {
            return false;
        }

        List<Character> list = new ArrayList<>();
        StringBuilder strBul = new StringBuilder();

        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (list.contains(c)) {
                break;
            }
            list.add(c);
            strBul.append(c);
            i++;
        }

        String subStr = strBul.toString();

        if (s.length() == subStr.length() || s.length() % subStr.length() != 0) {
            return false;
        } else {
            while (i < s.length() && (i + subStr.length()) <= s.length()) {
                if (!subStr.equals(s.substring(i, i + subStr.length()))) {
                    return false;
                }
                i += subStr.length();
            }
        }

        return i == s.length();
    }

    public static boolean solution1(String s) {
        String doubleS = s + s;
        if (doubleS.substring(1, doubleS.length() - 1).contains(s)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String input1 = "ab";
        String input2 = "abab";
        String input3 = "aba";
        String input4 = "abaaba";
        String input5 = "a";
        String input6 = "abcabcabcabc";

        String[] arrStr = {input1, input2, input3, input4, input5, input6};
        for (String s : arrStr) {
            System.out.printf("input: %s\n ", s);
            boolean res = solution1(s);
            System.out.printf("result: %b\n\n ", res);
        }

    }
}
