package Leetcode_solution;

/**
 * blog : https://jinyanwong.blog.csdn.net/article/details/106137492
 *
 * @author jinyanwong
 */
public class Leetcode680_check_palindromic_string_II {

    public static boolean solution(String s) {
        
        for(int i = 0, j = s.length() - 1; i < j; i++, j--){
            if(s.charAt(i) != s.charAt(j))
                return isPali(s, i+1, j) || isPali(s, i, j-1);
        }
        return true;
    }

    private static boolean isPali(String s, int start, int end){
        while(start < end)
            if(s.charAt(start++) != s.charAt(end++))
                return false;        
        
        return true;
    }
    
    public static void main(String[] args) {
        String s1 = "aba";
        String s2 = "abca";
        String s3 = "abba";
        String s4 = "abcdeba";
        String s5 = "";
        String[] arrStr = {s1, s2, s3, s4, s5};
        for (String s : arrStr) {
            System.out.printf("input:%s\n ", s);
            boolean res = solution(s);
            System.out.printf("result:%b\n\n ", res);
        }

    }
}
