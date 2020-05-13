package Leetcode_solution;

/**
 * blog : https://jinyanwong.blog.csdn.net/article/details/106091737
 *
 * @author jinyanwong
 */
public class Leetcode557_reverse_word_in_stirng_II {

    public static String solution(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        StringBuilder res = new StringBuilder();
        
        for(String str : s.split(" ")){
            int i = str.length() - 1;
            while(i >= 0)
                res.append(str.charAt(i--));
            
            res.append(' ');
        }
        
        return res.toString().trim();
    }


    
    public static void main(String[] args) {
        String s1 = "Let's take Leetcode contest";
        String s2 = "It is funny";
        String s3 = "yummy";

        String[] arrStr = {s1, s2, s3};

        for (String s : arrStr) {
            System.out.printf("input: s = %s\n", s);
            String res = solution(s);
            System.out.printf("result: %s\n\n", res);
        }

    }
}
