package Leetcode_solution;

/**
 * blog : https://jinyanwong.blog.csdn.net/article/details/106033736
 *
 * @author jinyanwong
 */
public class Leetcode541_reverse_string_II {

    public static String solution(String s, int k) {
        
        int i = 0;
        StringBuilder res = new StringBuilder();
        
        for (int j = i + k - 1; i < s.length() && (i + k) < s.length(); i += 2 * k) {
            
            while (j >= i) {
                res.append(s.charAt(j--));
            }
            res.append(s.substring(i + k, 
                                  (i + 2 * k) < s.length() ? 
                                  (i + 2 * k) : s.length()));
            j = i + 3 * k - 1;
        }

        // less than k
        int numIter = s.length() - i;
        i = 0;
        while (numIter-- > 0) {
            res.append(s.charAt(s.length() - ++i));
        }

        return res.toString();
    }

    public static void main(String[] args) {
        int k = 3;
        String s1 = "abcdefg";
        String s2 = "qazwsxedc";
        String s3 = "vrbtcexw";
        String s4 = "st";
        String s5 = "qazwsxedcy";

        String[] arrStr = {s1, s2, s3, s4, s5};
        System.out.println("k = " + k);
        for (String s : arrStr) {
            System.out.printf("input: %s\n", s);
            String res = solution(s, k);
            System.out.printf("result:%s\n\n", res);
        }

    }
}
