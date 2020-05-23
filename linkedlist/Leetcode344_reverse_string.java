package Leetcode_solution;

/**
 * blog : https://jinyanwong.blog.csdn.net/article/details/105894569
 *
 * @author jinyanwong
 */
public class Leetcode344_reverse_string {

    public static char[] solution(char[] input) {
        if(input == null || input.length == 1) return input;
        
        int len = input.length;
        
        for(int i = 0; i < len>>1; i++){
            char tmpC = input[i];
            input[i] = input[len - i - 1];
            input[len - i - 1] = tmpC;
        }
        return input;
        
    }

    public static void main(String[] args) {
        char[] arrC = {'h', 'e', 'l', 'l', 'o'};
        char[] arrC1 = {'q', 'e', 'r', 't'};
        System.out.println("input:" + Arrays.toString(arrC1));
        
        char[] res = solution(arrC1);
        System.out.println("output:" + Arrays.toString(res));

    }
}
