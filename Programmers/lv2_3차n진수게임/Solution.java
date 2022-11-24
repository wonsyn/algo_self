package programmers_lv2_3차n진수게임;

public class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        String fullString = "";
        int num = 0;
        while(fullString.length() <= t * m) {
            fullString += toNnary(num++, n);
        }

        for(int i = 0; i < t; i++) {
            answer += fullString.charAt(p + (m * i) - 1);
        }

        return answer;
    }

    public String toNnary(int num, int n) {
        if(num == 0) return "0";
        String str = "";
        while(num != 0) {
            int mod = num % n;
            num /= n;
            if(mod > 9) {
                str = "" + (char)('A' + (mod - 10)) + str;
            } else {
                str = "" + mod + str;
            }
        }
        return str;
    }
}
