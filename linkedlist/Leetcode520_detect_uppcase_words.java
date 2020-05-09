package Leetcode_solution;


/**
 * blog : https://jinyanwong.blog.csdn.net/article/details/106015417
 *
 * @author jinyanwong
 */
public class Leetcode520_detect_uppcase_words {

    public static boolean solution(String s) {
        if(s == null || s.length() == 0) return false;

        int numUpper = 0;
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) - 'A'<= 25)
                numUpper++;
        }
        
        if(numUpper == s.length() 
           || numUpper == 0 
           || (numUpper == 1 && (s.charAt(0) - 'A'<= 25)))
            return true;        
        
        return false;
    }


    public static void main(String[] args) {
        String input1 = "USA";
        String input2 = "USAA";
        String input3 = "Google";
        String input4 = "GooglE";
        String input5 = "aaB";
        String input6 = "";
        String input7 = "aaaa";

        String[] arrStr = {input1, input2, input3, input4, input5, input6, input7};
        for (String s : arrStr) {
            System.out.printf("input: %s\n ", s);
            boolean res = solution(s);
            System.out.printf("result: %b\n\n ", res);
        }

    }
}
