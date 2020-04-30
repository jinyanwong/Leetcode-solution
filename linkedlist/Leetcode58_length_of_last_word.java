package Leetcode_solution;

/**
 * blog : https://jinyanwong.blog.csdn.net/article/details/105857643
 *
 * @author jinyanwong
 */
public class Leetcode58_length_of_last_word {

    public static int solution(String s) {
        if (s == null || s == "") {
            return 0;
        }     
        s = s.trim();
        
        int len = s.length();
        int i  = len - 1;
        
        while(i >= 0 && s.charAt(i) != ' '){
            i--;
        }
        
        return i < 0 ? len : len - i - 1;
    }

    public static void main(String[] args) {
        String s1 = "bbb bbb";
        String s2 = "abcabcab ";
        String s3 = "p wwk ew";
        String s4 = "a man a plan a canal Panama";
        String s5 = "race a car";
        String[] arrStr = {s1, s2, s3, s4, s5};
        for (String s : arrStr) {
            System.out.printf("input:%s\n ", s);
            int res = solution(s);
            System.out.printf("result:%d\n\n ", res);
        }

    }
}
