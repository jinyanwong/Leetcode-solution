package Leetcode_solution;

/**
 * blog : https://jinyanwong.blog.csdn.net/article/details/106135635
 *
 * @author jinyanwong
 */
public class Leetcode657_robot_back_to_origin {

    public static boolean solution(String track) {
        if (track == null || track == "") {
            return true;
        }
        
        int leftRight = 0, upDown = 0;
        
        if(track.length() % 2 != 0) return false;
        
        for(int i = 0; i < track.length(); i++){
            char c = track.charAt(i);
            
            if(c == 'R' || c == 'L'){
                if(c == 'R') leftRight--;
                else leftRight++;
                
            }else if(c == 'U' || c == 'D'){
                if(c == 'D') upDown--;
                else upDown++;
            }
        }
        
        return leftRight == upDown ? leftRight==0 : false;
    }

    public static void main(String[] args) {
        String s1 = "UD";
        String s2 = "UDUDU";
        String s3 = "DUDUDU";
        String s4 = "UDLRUDDLLURR";
        String s5 = "LLUU";
        String[] arrStr = {s1, s2, s3, s4, s5};
        for (String s : arrStr) {
            System.out.printf("input:%s\n ", s);
            boolean res = solution(s);
            System.out.printf("result:%b\n\n ", res);
        }

    }
}
