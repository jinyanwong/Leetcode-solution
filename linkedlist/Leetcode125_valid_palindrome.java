
package Leetcode_solution;

/**
 * blog : https://blog.csdn.net/u011106767/article/details/105725100
 * 
 * @author jinyanwong
 */
public class Leetcode125_valid_palindrome {
    
    public static boolean solution(String s){
        if(s == "") return true;
        
        int len = s.length();
        if(len == 1) return false;
       
        s = s.toLowerCase().replaceAll("[^0-9a-z]", "");
        
        len = s.length();
        for(int i = 0, j = len-1; i < j; i++, j--){
            if(s.charAt(i) != s.charAt(j))
                return false;
        }
        return true;
    }
    
        public static void main(String[] args){
        String s1 = "bbbbbb";
        String s2 = "abcabcab";
        String s3 = "pwwkew";
        String s4 = "a man, a plan, a canal: Panama";
        String s5 = "race a car";
        String[] arrStr = {s1, s2, s3, s4, s5};
        for(String s: arrStr){
            System.out.printf("input:%s\n ", s);
            boolean res = solution(s);
            System.out.printf("result:%b\n\n ", res);
        }
        
    }
}
