package Leetcode_solution;

/**
 * blog : https://jinyanwong.blog.csdn.net/article/details/105874123
 *
 * @author jinyanwong
 */
public class Leetcode67_add_binary {

    public static String solution(String a, String b) {
        StringBuilder res = new StringBuilder();
        int lenA = a.length();
        int lenB = b.length();

        /* STEP1: fill '0' on the left if they two has unsame length 
        */
        if (lenA != lenB) {
            int delta = lenA - lenB;
            
            for (int i = 0; i < Math.abs(delta); i++)
                res.append('0');
            
            if (lenA > lenB)
                b = res.append(b).toString();
            else 
                a = res.append(a).toString();
            

            lenA = Math.max(a.length(), b.length());
            res.delete(0, res.length());
        }

        /* STEP2: add bit by bit
        */
        Character carry = '0';
        for (int i = lenA - 1; i >= 0; i--) {
            if (a.charAt(i) == b.charAt(i)) {
                res.append(carry);
                carry = a.charAt(i);
            } else {
                res.append(carry == '0' ? '1' : '0');
            }
        }

        res.append(carry == '0' ? "" : carry);

        return res.reverse().toString();
    }

    public static void main(String[] args) {
        String s1 = "111";
        String s2 = "000";
        String s3 = "1";
        String s4 = "1010";
        String s5 = "10001";

        System.out.printf("input:%s,%s\n ", s5, s4);
        String res = solution(s5, s4);
        System.out.printf("result:%s\n\n ", res);

    }
}
