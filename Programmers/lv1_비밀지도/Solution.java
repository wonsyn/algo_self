package programmers_lv1_비밀지도;

import java.util.Arrays;

public class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        char[][] result = new char[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                result[i][j] = ' ';
            }
        }

        for(int i = 0; i < n; i++) {
            String str = Integer.toBinaryString(arr1[i]);
            int rest = n - str.length();
            String zero = "";
            for(int j = 0; j < rest; j++)
                zero += "0";
            str = zero + str;

            for(int j = 0; j < n; j++) {
                if(str.charAt(j) == '1') {
                    result[i][j] = '#';
                }
            }
        }

        for(int i = 0; i < n; i++) {
            String str = Integer.toBinaryString(arr2[i]);
            int rest = n - str.length();
            String zero = "";
            for(int j = 0; j < rest; j++)
                zero += "0";
            str = zero + str;

            for(int j = 0; j < n; j++) {
                if(str.charAt(j) == '1') {
                    result[i][j] = '#';
                }
            }
        }

        for(int i = 0; i < n; i++) {
            answer[i] = new String(result[i]);
            System.out.println(answer[i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(5, new int[] {9, 20, 28, 18, 11}, new int[] {30, 1, 21, 17, 28});
    }
}
