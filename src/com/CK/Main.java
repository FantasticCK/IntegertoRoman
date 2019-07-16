package com.CK;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        int num = 9;
        Solution solution = new Solution();
        System.out.println(solution.intToRoman(num));
    }
}

class Solution {
    public String intToRoman(int num) {
        StringBuilder ws = new StringBuilder(); //Whole String
        StringBuilder ss = new StringBuilder(); //Single String
        Map<Integer, Character> map = new HashMap<>();
        map.put(1, 'I');
        map.put(5, 'V');
        map.put(10, 'X');
        map.put(50, 'L');
        map.put(100, 'C');
        map.put(500, 'D');
        map.put(1000, 'M');
        int digit;
        for (int i = String.valueOf(num).length() - 1; i >= 0; i--) {
            digit = num / (int) Math.pow(10, i);
            if (digit == 4 || digit == 9) {
                ss.append(map.get((int) Math.pow(10, i)));
                ss.append(map.get((int) Math.pow(10, i) * (digit + 1)));
            } else {
                if (digit > 5) {
                    ss.append(map.get((int) Math.pow(10, i) * 5));
                    for (int d = 0; d < (digit) % 5; d++) {
                        ss.append(map.get((int) Math.pow(10, i)));
                    }
                } else if (digit < 5) {
                    for (int d = 0; d < (digit) % 5; d++) {
                        ss.append(map.get((int) Math.pow(10, i)));
                    }
                } else {
                    ss.append(map.get((int) Math.pow(10, i) * 5));
                }
            }
            ws.append(ss);
            ss.delete(0,ss.length());
            num = num- digit * (int) Math.pow(10, i);
        }
        return ws.toString();
    }
}