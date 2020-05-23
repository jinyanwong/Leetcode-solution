package Leetcode_solution;


/**
 * blog : https://jinyanwong.blog.csdn.net/article/details/106032979
 * 
 * @author jinyanwong
 */
public class Leetcode521_longest_special_substring_I {

    public static int solution(String a, String b) {
        if(b.equals(a))
            return -1;
        return Math.max(a.length(), b.length());
    }

    public static void main(String[] args) {
        String a1 = "aba";
        String b1 = "adc";
        
        String a2 = "aaa";
        String b2 = "bbb";
        
        String a3 = "aaa";
        String b3 = "aaa";
        
        String a4 = "";
        String b4 = "we";
        
        String[][] arrStrs = {{a1, b1},
                             {a2, b2},
                             {a3, b3},
                             {a4, b4}
        };
        
        for(String[] strs : arrStrs){
            System.out.printf("input: a = %s, b = %s\n", strs[0], strs[1]);
            int res = solution(strs[0], strs[1]);
            System.out.printf("result: %d\n\n ", res);       
        }
        

    }
}
