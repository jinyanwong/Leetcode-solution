package Leetcode_solution;


/**
 * blog : https://jinyanwong.blog.csdn.net/article/details/105966649
 *
 * @author jinyanwong
 */
public class Leetcode434_number_of_words_in_string {

    public static int solution(String s) {
        if(s == null || s.length() == 0) return 0;
        
        int res = 0;
        s = s.trim();
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ' ' 
                    && i + 1 < s.length() 
                    && s.charAt(i + 1) != ' ')
                res++;
        }
        return ++res;
    }

    public static void main(String[] args) {
        String s1 = "aa as re a";
        String s2 = "is";
        String s3 = " it a ";
        String s4 = "";
        String s5 = "acds";
        String s6 = "Hello, my name is leetcode";
       
        String[] arrStr = {s1, s2, s3, s4, s5, s6};
        for(String s : arrStr){
            System.out.println("input: " + s);
            int res = solution(s);
            System.out.printf("result: %d\n\n ", res); 
        }

    }
}
