package Leetcode_solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * blog : https://jinyanwong.blog.csdn.net/article/details/105927959
 *
 * @author jinyanwong
 */
public class Leetcode387_first_unique_character_in_string {

    public static int solution(String input) {
        if (input == null || input.length() == 0) {
            return -1;
        }

        Map<Character, Integer> map = new HashMap<>();

        // first traverse
        for(int i = 0; i < input.length(); i++){
            char tmpC = input.charAt(i);
            if(map.containsKey(tmpC))
                map.replace(tmpC, map.get(tmpC) + 1);
            else
                map.put(tmpC, 1);
        }
        
        // second one
        for (int i = 0; i < input.length(); i++) {
            if (map.get(input.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String input1 = "aa";
        String input2 = "ab";
        String input3 = "leetcode";
        String input4 = "";
        String input5 = "lleetcoe";
        
        String[] arrInput = {input1, input2, input3, input4, input5};
       
        for(String input : arrInput){
            System.out.printf("input = %s\n", input);
            int res = solution(input);
            System.out.printf("result:%d\n\n ", res);
        }
        

    }
}
