package Leetcode_solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * blog : https://blog.csdn.net/u011106767/article/details/105833919
 *
 * @author jinyanwong
 */
public class Leetcode30_count_and_say {
    static List<String> list = new ArrayList<>();
    public static String solution(int input, int n) {
        if (input == 1) {
            return "1";
        }

        List<String> list = new ArrayList<>();
        getList(list, n);
        
        

        return list.get(input - 1);
    }

    private static void getList(List list, int n) {
        list.add("1");
        for (int intIndex = 1; intIndex <= n; intIndex++) {
            StringBuilder currStr = new StringBuilder();
            String prev = (String) list.get(intIndex - 1);

            for (int lowP = 0, fastP = 0; lowP < prev.length() && fastP < prev.length();) {
                while (prev.charAt(lowP) != prev.charAt(fastP)) {
                    currStr.append(String.valueOf(fastP - lowP));
                    currStr.append(prev.charAt(lowP));

                    lowP = fastP;
                }
                if (fastP == prev.length() - 1) {
                    currStr.append(String.valueOf(fastP - lowP + 1));
                    currStr.append(prev.charAt(lowP));
                    list.add(intIndex, currStr.toString());

                }

                fastP++;
            }
            currStr = new StringBuilder();
        }
    }

    private static void getMap(Map map, int n) {
        map.put(1, "1");
        for (int intIndex = 2; intIndex <= n; intIndex++) {
            StringBuilder currStr = new StringBuilder();
            String prev = (String) map.get(intIndex - 1);
            for (int lowP = 0, fastP = 0; lowP < prev.length() && fastP < prev.length();) {
                while (prev.charAt(lowP) != prev.charAt(fastP)) {
                    currStr.append(String.valueOf(fastP - lowP));
                    currStr.append(prev.charAt(lowP));
                    
                    lowP = fastP;
                }
                if (fastP == prev.length() - 1) {
                    currStr.append(String.valueOf(fastP - lowP + 1));
                    currStr.append(prev.charAt(lowP));
                    map.put(intIndex, currStr.toString());
                }

                fastP++;
            }
            currStr = new StringBuilder();
        }
    }

    public static void main(String[] args) {
        int input = 9;
        int n = 30;

        System.out.printf("input:%d\n ", input);

        String res = solution(input, n);
        System.out.printf("result:%s\n\n ", res);

    }
}
