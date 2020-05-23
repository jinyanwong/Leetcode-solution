package Leetcode_solution;

/**
 * blog : https://jinyanwong.blog.csdn.net/article/details/106068900
 *
 * @author jinyanwong
 */
public class Leetcode551_student_presence_record_I {

    public static boolean solutionBasic(String s) {
        if (s == null) {
            return false;
        }

        int absentCounter = 0;
        for (int i = 0; i < s.length() && absentCounter < 2; i++) {

            // check A
            if (s.charAt(i) == 'A') {
                absentCounter++;               
            }

            //check LLL            
            if ((i + 2 < s.length())
                 &&(s.charAt(i) == 'L'
                    && s.charAt(i + 1) == 'L'
                    && s.charAt(i + 2) == 'L')) 
                return false;
            
        }
        return absentCounter < 2;
    }

    public static boolean solutionWithContain(String s){
        if (s == null) {
            return false;
        }

        int absentCounter = 0;
        for (int i = 0; i < s.length() && absentCounter < 2; i++) {

            // check A
            if (s.charAt(i) == 'A') {
                absentCounter++;               
            }

            //check LLL            
            if ( i + 2 < s.length() &&  s.contains("LLL")) 
                return false;
            
        }
        return absentCounter < 2;
    }
    
    public static boolean solutionWithRegex(String s){
        return !s.matches(".*(A.*A|LLL).*");
    }
    
    public static void main(String[] args) {
        String s1 = "PPALLP";
        String s2 = "PPALLL";

        String[] arrStr = {s1, s2};

        for (String s : arrStr) {
            System.out.printf("input: s = %s\n", s);
            boolean res = solutionWithRegex(s);
            System.out.printf("result: %b\n\n", res);
        }

    }
}
