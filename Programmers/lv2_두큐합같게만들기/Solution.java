package programmers_lv2_두큐합같게만들기;

import java.util.*;

public class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        long sum1 = 0, sum2 = 0;
        int count = 0;
        for(int i = 0; i < queue1.length; i++) {
            sum1 += queue1[i];
            sum2 += queue2[i];
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
        }

        while(sum1 != sum2) {
            if(sum1 > sum2) {
                int temp = q1.poll();
                q2.offer(temp);
                sum1 -= temp;
                sum2 += temp;
            } else {
                int temp = q2.poll();
                q1.offer(temp);
                sum1 += temp;
                sum2 -= temp;
            }

            count++;
            if(count > queue1.length * 3) return -1;
        }

        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(new int[]{3, 2, 7, 2}, new int[]{4, 6, 5, 1});
    }
}
