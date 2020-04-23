
package Leetcode_solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * blog : https://blog.csdn.net/u011106767/article/details/105651957
 * 
 * @author jinyanwong
 */
public class Leetcode3_longest_substring_without_repeating_chars {
    /*
    Time Com. : O(N)
    Space Com. O(min(m, N))
    */
    public static int solution1(String s){
        if(s == null) return 0;
        
        int len = s.length();
        if(len == 1) return 1;
        
        /* Step 1: Init. integer and container.
        */
        int maxSubStrLen = 0, left = 0, right = 0;        
        Set<Character> set = new HashSet<>();
        
        /* Step 2: go-through string
        and
        check whether repeated in container to re-fine sliding window
        */
        while(left < len && right < len){
            
            if(!set.contains(s.charAt(right))){ // enlarge window on the right
                set.add(s.charAt(right++));
                maxSubStrLen = Math.max(maxSubStrLen, right-left);
            }else{ // shrink window from left
                set.remove(s.charAt(left++));
            }
        }
        
        
        return maxSubStrLen;
    }
    
    public static int solution2(String s){
        if(s == null) return 0;
        
        int len = s.length();
        if(len == 1) return 1;
        
        /* Step 1: Init. integer and container.
        */
        int maxSubStrLen = 0;        
        // <char, index>
        Map<Character, Integer> map = new HashMap<>();
        
        /* Step 2: go-through string
        and
        update existed index if checked.
        */
        for(int left=0, right=0; right < len; right++){
            if(map.containsKey(s.charAt(right))){
               left = Math.max(map.get(s.charAt(right)), left);
            }
            maxSubStrLen = Math.max(maxSubStrLen, right - left + 1);
            map.put(s.charAt(right), right + 1);
        }
        
        
        return maxSubStrLen;
    }
    
    
    public static void main(String[] args){
        String s1 = "bbbbbb";
        String s2 = "abcabcab";
        String s3 = "pwwkew";
        String[] arrStr = {s1, s2, s3};
        for(String s: arrStr){
            System.out.printf("input:%s\n ", s);
            int res = solution2(s);
            System.out.printf("result:%d\n\n ", res);
        }
        
        
    }
}
