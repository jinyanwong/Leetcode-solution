package Leetcode_solution;

/**
 * blog : https://jinyanwong.blog.csdn.net/article/details/106208943
 *
 * @author jinyanwong
 */
public class Leetcode696_count_binary_string {

    public static int solution(String s) {
        
        int res = 0;
        int leftIndex = 0, rightIndex = 0;        
        
        while(rightIndex+1 < s.length()){
            if(s.charAt(rightIndex) == s.charAt(rightIndex + 1))
                rightIndex++;
            else{
                res++;
                leftIndex = rightIndex++;
                
                while((leftIndex - 1)>=0 && (rightIndex+1)<s.length()
                        && (s.charAt(leftIndex)==s.charAt(--leftIndex)
                            && s.charAt(rightIndex)==s.charAt(++rightIndex)) )
                    res++;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        String s1 = "00110011";
        String s2 = "10101";
        String s3 = "000111";
        String s4 = "1";
        String s5 = "00111";
        String s6 = "10";
        String[] arrStr = {s1, s2, s3, s4, s5, s6};
        for (String s : arrStr) {
            System.out.printf("input:%s\n ", s);
            int res = solution(s);
            System.out.printf("result:%d\n\n ", res);
        }

    }
}
