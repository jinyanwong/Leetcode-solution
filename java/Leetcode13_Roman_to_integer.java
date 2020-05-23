
package Leetcode_solution;

import java.util.HashMap;
import java.util.Map;

/**
 * blog : https://blog.csdn.net/u011106767/article/details/105744578
 * 
 * @author jinyanwong
 */
public class Leetcode13_Roman_to_integer {
    
    public static int solution(String s){
        if(s == null || s == "") return 0;
        
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        
        
        int len = s.length();
        int rightNum = map.get(s.charAt(len - 1));
        int res = rightNum;
        
        for(int i = len-2;i>=0;i--){
            int cur = map.get(s.charAt(i));
            if(cur < rightNum)
                res -= cur;
            else if(cur >= rightNum)
                res += cur;
            rightNum = cur;
        }
        return res;
    }
    
        public static void main(String[] args){
        String s1 = "III";
        String s2 = "IV";
        String s3 = "IX";
        String s4 = "LVIII";
        String s5 = "MCMXCIV";
        String[] arrStr = {s1, s2, s3, s4, s5};
        for(String s: arrStr){
            System.out.printf("input:%s\n ", s);
            int res = solution(s);
            System.out.printf("result:%d\n\n ", res);
        }
        
    }
}
