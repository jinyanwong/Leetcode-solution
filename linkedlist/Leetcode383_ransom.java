package Leetcode_solution;

import java.util.HashMap;
import java.util.Map;

/**
 * blog : https://jinyanwong.blog.csdn.net/article/details/105921447
 *
 * @author jinyanwong
 */
public class Leetcode383_ransom {

    public static boolean solution(String ransom, String mgze) {
        if(ransom == null || mgze == null) return false;
        
        Map<Character, Integer> map = new HashMap<>();
        
        for(char c : mgze.toCharArray()){
            if(!map.containsKey(c))
                map.put(c, 1);
            else
                map.replace(c, map.get(c)+ 1);
        }
        
        for(char c : ransom.toCharArray()){
            if(!map.containsKey(c)){
                return false;
            }
            
            map.replace(c,map.get(c) - 1);
            if(map.get(c) == 0) map.remove(c);
        }
        
        return true;
    }

    public static void main(String[] args) {
        String ransom = "aa";
        String mgze = "aab";
       
        System.out.printf("input: ransom = %s, mgze = %s\n", ransom, mgze);
        boolean res = solution(ransom, mgze);
        System.out.printf("result:%b\n\n ", res);
        

    }
}
