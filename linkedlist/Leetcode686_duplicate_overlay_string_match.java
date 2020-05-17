package Leetcode_solution;

/**
 * blog : https://jinyanwong.blog.csdn.net/article/details/106162410
 *
 * @author jinyanwong
 */
public class Leetcode686_duplicate_overlay_string_match {

    public static int solution(String a, String b) {
        
        int res = 1;
        StringBuilder strs = new StringBuilder(a);
        
        while (strs.length() < 3 * Math.max(a.length(), b.length())) {
            if (strs.indexOf(b) >= 0) {
                return res;
            } else {
                strs.append(a);
                res++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String a1 = "abcd";
        String b1 = "cdabcdab";

        String a2 = "be";
        String b2 = "cdabcdab";

        String a3 = "cdabcdab";
        String b3 = "cdabcdab";

        String a4 = "bgr";
        String b4 = "rbgrbg";

        String a5 = "ab";
        String b5 = "babababa";

        String a6 = "abcd";
        String b6 = "da";

        String[][] arrInput = {
            {a1, b1},
            {a2, b2},
            {a3, b3},
            {a4, b4},
            {a5, b5},
            {a6, b6}
        };
        for (String[] input : arrInput) {
            System.out.printf("input: a = %s, b = %s\n", input[0], input[1]);
            int res = solution(input[0], input[1]);
            System.out.printf("result: %d\n\n ", res);
        }

    }
}
