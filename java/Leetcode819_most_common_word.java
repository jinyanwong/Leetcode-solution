package Leetcode_solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * blog : https://jinyanwong.blog.csdn.net/article/details/106439433
 *
 * @author jinyanwong
 */
public class Leetcode819_most_common_word {

    public static String solution(String paragraph, String[] banned) {
        Map<String, Integer> map = new HashMap<>();
        Set<String> bannedSet = new HashSet<>();
        
        bannedSet.addAll(Arrays.asList(banned));
        String[] strArr = paragraph.replaceAll("[,.?!;]", "").toLowerCase().split(" ");
        
        int maxCounter = 0;
        String res = "";
        
        for(String s : strArr){
            if(!bannedSet.contains(s)){
                if(!map.containsKey(s))
                    map.put(s, 1);
                else
                    map.replace(s, map.get(s)+1);
                
                res = maxCounter > map.get(s) ? res : s;
                maxCounter = Math.max(maxCounter, map.get(s));
            }           
        }        
        return res;
    }


    public static void main(String[] args) {
        String[] banned = {"hit", "am", "what"};
        
        String s1 = "I,, am confused, hit that guy, that ? that ;;";
        String s2 = "I AM am ama am ama ama ama!!! ";
        String s3 = "CLOUD? cloud uHH";
        String s4 = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String s5 = "what? what? you passed, ? got it? you! you PaSSED!!!";
        String s6 = "hit hit hit hit,, yeah, yeah!!!";
        String[] arrStr = {s1, s2, s3, s4, s5, s6};
        for (String s : arrStr) {
            System.out.printf("input:%s\n ", s);
            String res = solution(s, banned);
            System.out.printf("result:%s\n\n ", res);
        }

    }
}
