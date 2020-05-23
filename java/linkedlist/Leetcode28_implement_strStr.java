package Leetcode_solution;

/**
 * blog : https://blog.csdn.net/u011106767/article/details/105806477
 *
 * @author jinyanwong
 */
public class Leetcode28_implement_strStr {

    public static int solution(String haystack, String needle) {
        if (needle == null || needle == "") {
            return 0;
        }

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "ba)";
        String s3 = "baba";
        String s4 = "grva";
        String s5 = "aaa";
        String s6 = "b";
        String s7 = "";
        String s8 = "bb";
        String[] arrStr = {s1, s2, s3, s4, s5, s6, s7, s8};

        String needle = "a";
        System.out.println("string needle= " + needle);
        for (String s : arrStr) {
            System.out.printf("input:%s\n ", s);
            int res = solution(s, needle);
            System.out.printf("result:%d\n\n ", res);
        }

    }
}
