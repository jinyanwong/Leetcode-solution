package Leetcode_solution;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * blog : https://blog.csdn.net/u011106767/article/details/105725100
 *
 * @author jinyanwong
 */
public class Leetcode345_reverse_vowels_of_string {

    public static String solution(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        char[] res = s.toCharArray();

        for (int i = 0, j = s.length() - 1; i < j;) {
            if (set.contains(res[i])) {
                if (set.contains(res[j])) {
                    if (res[i] != res[j]) {
                        char tmpC = res[i];
                        res[i] = res[j];
                        res[j] = tmpC;
                    }
                    i++;
                    j--;
                } else
                    j--;
                
            } else
                i++;
            
        }
        return new String(res);
    }

    public static void main(String[] args) {
        String s6 = "hello";
        String s7 = "leetcode";
        String[] arrStr = {s6, s7};
        for (String s : arrStr) {
            System.out.printf("input:%s\n ", s);
            String res = solution(s);
            System.out.printf("result:%s\n\n ", res);
        }

    }
}
