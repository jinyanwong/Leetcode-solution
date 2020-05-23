package Leetcode_solution;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * blog : https://blog.csdn.net/u011106767/article/details/105786712
 *
 * @author jinyanwong
 */
public class Leetcode20_valid_parentheses {

    public static boolean solution(String s) {
        if (s == null || s == "") {
            return true;
        }

        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            // left parenthese
            if (map.containsKey(c)) {
                stack.push(c);
            } else { // right
                if(stack.empty())
                    return false;
                // paired
                else if(!stack.empty() && c == map.get(stack.peek())){
                    stack.pop();
                }
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        String s1 = "))";
        String s2 = "()";
        String s3 = "()[]{}";
        String s4 = "(]";
        String s5 = "([)]";
        String s6 = "{[]}";
        String s7 = "";
        String s8 = "({";
        String[] arrStr = {s1, s2, s3, s4, s5, s6, s7, s8};
        for (String s : arrStr) {
            System.out.printf("input:%s\n ", s);
            boolean res = solution(s);
            System.out.printf("result:%b\n\n ", res);
        }

    }
}
