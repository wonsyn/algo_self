package programmers_lv1_실패율;

import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[][] table = new int[N + 2][2];  // [stage][0: tryCount, 1: fail]

        for(int stage : stages) {
            table[stage][1]++;
//            for(int i = stage; i <= N + 1; i++) {
//                if(stage <= i) table[i][0]++;
//            }
        }

        table[N][0] = table[N][1] + table[N + 1][1];
        for(int i = N - 1; i >= 1; i--) {
            table[i][0] = table[i][1] + table[i + 1][0];
        }

        Map<Integer, Double> map = new HashMap<>();
        for(int i = 1; i <= N; i++) {
            if(table[i][0] == 0) {
                map.put(i, 0.0);
            } else {
                map.put(i, (double) table[i][1] / table[i][0]);
            }
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (key1, key2) -> Double.compare(map.get(key2), map.get(key1)));

        for(int i = 0; i < N; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}