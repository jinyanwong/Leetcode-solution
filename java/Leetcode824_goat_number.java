package Leetcode_solution;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * blog : https://jinyanwong.blog.csdn.net/article/details/106451958
 *
 * @author jinyanwong
 */
public class Leetcode824_goat_number {

    public static String solution(String s) {
        if(s == null) return null;
        StringBuilder res = new StringBuilder();
        Set<Character> set = new HashSet<>();
        
        Character[] chars = {'a','e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        set.addAll(Arrays.asList(chars));       
        
        int index = 1;
        for(String word : s.split(" ")){
            char firstC = word.charAt(0);
            if(!set.contains(firstC)){
                res.append(word.substring(1));
                res.append(firstC);
                res.append("ma");
            }
            for(int i = 0; i < index; i++)
                res.append("a");
            res.append(" ");
            
            index++;
        }
        return res.substring(0, res.length()-1);
    }

    public static void main(String[] args) {
        
        String s1 = "I speak Goat Latin";
        String s2 = "The quick brown fox jumped over the lazy dog";
        String[] strs = {s1, s2};
        
        for(String s : strs){
            System.out.println("input:" + s);
            System.out.println("output:" + solution(s) + "\n");
        }
    }
}
