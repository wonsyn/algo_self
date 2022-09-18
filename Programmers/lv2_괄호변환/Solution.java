package programmers_lv2_괄호변환;

import java.util.Stack;

public class Solution {
    public String solution(String p) {
        return change(p);
    }

    public static String change(String str) {
        if(str.length() == 0) return "";
        String result = "";
        int left = 0, right = 0, i;
        for(i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c == '(') left++;
            else right++;
            if(left != 0 && left == right) break;
        }
        String u, v;
        if(i == str.length() - 1) {
            u = str; v = "";
        } else {
            u = str.substring(0, i + 1);
            v = str.substring(i + 1);
        }
        if(check(u)) {
            result = u + change(v);
        } else {
            u = u.substring(1, u.length() - 1);
            String temp = "(" + change(v) + ")";
            for(int j = 0; j < u.length(); j++) {
                if(u.charAt(j) == '(') temp += ')';
                else temp += '(';
            }
            result = temp;
        }
        return result;
    }

    public static boolean check(String u) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < u.length(); i++) {
            if(u.charAt(i) == '(') stack.push('(');
            else {
                if(stack.isEmpty()) return false;
                else {
                    char c = stack.pop();
                    if (c != '(') return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
