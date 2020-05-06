package Leetcode_solution;


/**
 * blog : https://jinyanwong.blog.csdn.net/article/details/105929253
 *
 * @author jinyanwong
 */
public class Leetcode415_add_string {

    public static String solution(String a, String b) {
        if(a == null || a.length() == 0) return b;
        if(b == null || b.length() == 0) return a;
        
        StringBuilder res = new StringBuilder();        
        int carry = 0;
        
        for(int i = a.length() - 1, j = b.length() - 1;
                i >=0 || j >= 0; i--, j--){
            
            int v1 = i >= 0 ? a.charAt(i) - '0': 0;
            int v2 = j >= 0 ? b.charAt(j) - '0' : 0;
            
            carry = (v1 + v2) / 10;
            res.append((v1 + v2) % 10);
        }
        
        res.append(carry == 1 ? '1' : "");
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        String input1 = "19";
        String input2 = "20";
        String input3 = "234";
        String input4 = "";
        String input5 = "7968";
       
        System.out.printf("input: %s + %s\n", input3, input4);
        String res = solution(input3, input4);
        System.out.printf("result: %s\n\n ", res);       

    }
}
