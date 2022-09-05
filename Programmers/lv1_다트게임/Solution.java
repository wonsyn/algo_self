package programmers_lv1_다트게임;

public class Solution {
    public int solution(String dartResult) {
        int[] score = new int[3];
        int idx = 0;
        for(int i = 0; i < dartResult.length();) {
            char number = dartResult.charAt(i);
            System.out.println(number);
            if(number == '1') {
                if(dartResult.charAt(i + 1) == '0') {
                    score[idx] = 10;
                    i++;
                } else {
                    score[idx] = 1;
                }
            } else {
                score[idx] = number - '0';
            }
            char bonus = dartResult.charAt(i + 1);
            switch(bonus) {
                case 'D':
                    score[idx] = (int)Math.pow(score[idx], 2);
                    break;
                case 'T':
                    score[idx] = (int)Math.pow(score[idx], 3);
                    break;
                case 'S':
            }

            char option;
            if(i + 2 < dartResult.length() && !('0' <= dartResult.charAt(i + 2) && dartResult.charAt(i + 2) <= '9')) {
                option = dartResult.charAt(i + 2);
                if(option == '*') {
                    score[idx] *= 2;
                    if(idx != 0) score[idx - 1] *= 2;
                } else {
                    score[idx] *= -1;
                }
                if(i + 3 < dartResult.length() && !('0' <= dartResult.charAt(i + 3) && dartResult.charAt(i + 3) <= '9')) {
                    option = dartResult.charAt(i + 3);
                    if(option == '*') {
                        score[idx] *= 2;
                        if(idx != 0) score[idx - 1] *= 2;
                    } else {
                        score[idx] *= -1;
                    }
                    i += 4;
                } else {
                    i += 3;
                }
            } else {
                i += 2;
            }
            idx++;
        }

        int answer = 0;
        for(int number : score) {
            answer += number;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution("1S2D*3T");
    }
}
