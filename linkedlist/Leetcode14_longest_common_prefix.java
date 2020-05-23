package Leetcode_solution;

/**
 * blog : https://blog.csdn.net/u011106767/article/details/105762767
 *
 * @author jinyanwong
 */
public class Leetcode14_longest_common_prefix {

    public static String solution(String[] arrStr) {
        if (arrStr == null || arrStr.length == 1) {
            return null;
        }

        int len = arrStr.length;
        int sIndex;
        int cIndex;
        
        for (cIndex = 0; cIndex < arrStr[0].length(); cIndex++) {
            for (sIndex = 1; sIndex < len; sIndex++) {
                if (arrStr[sIndex].charAt(cIndex) != arrStr[0].charAt(cIndex)) {
                    return arrStr[0].substring(0,cIndex);
                }
            }
        }
        return arrStr[0].substring(0,cIndex);
    }

    public static void main(String[] args) {
        String s1 = "abbbbb";
        String s2 = "abcabcab";
        String s3 = "qwwkew";
        String s4 = "a man, a plan, a canal: Panama";
        String s5 = "race a car";
        String[] arrStr = {s1, s2, s3}; //, s3, s4, s5};
        String res = solution(arrStr);
        System.out.printf("result:%s\n\n ", res);

    }
}
