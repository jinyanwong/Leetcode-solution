package Leetcode_solution;

/**
 * blog : https://jinyanwong.blog.csdn.net/article/details/106274183
 *
 * @author jinyanwong
 */
public class Leetcode709_transfer_to_lowcase {

    public static String solution(String s) {
        if(s == null) return null;
        
        StringBuilder res = new StringBuilder();
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c < 'a')
                c = (char) (c + 32);
            res.append(c);
        }
        
        return res.toString();
    }


    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = "here";
        String s3 = "Lovely";
        String s4 = "Me";
        String s5 = "heQr";
        String s6 = "";
        String[] arrStr = {s1, s2, s3, s4, s5, s6};
        for (String s : arrStr) {
            System.out.printf("input:%s\n ", s);
            String res = solution(s);
            System.out.printf("result:%s\n\n ", res);
        }

    }
}
