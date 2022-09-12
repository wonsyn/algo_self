package programmers_lv2_튜플;

import java.util.*;

public class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        boolean[] arr = new boolean[100001];

        s = s.substring(1, s.length() - 1);
        StringTokenizer st = new StringTokenizer(s, "{}");
        StringTokenizer st2;
        PriorityQueue<Set<Integer>> pq = new PriorityQueue<>((o1, o2) -> o1.size() - o2.size());

        while(st.hasMoreTokens()) {
            st2 = new StringTokenizer(st.nextToken(), ",");
            Set<Integer> set = new HashSet<>();
            while(st2.hasMoreTokens()) {
                set.add(Integer.parseInt(st2.nextToken()));
            }
            pq.offer(set);
        }

        ArrayList<Integer> list = new ArrayList<>();
        while(!pq.isEmpty()) {
            Set<Integer> set = pq.poll();
            for(int i : set) {
                if(arr[i]) continue;
                list.add(i);
                arr[i] = true;
            }
        }

        answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
