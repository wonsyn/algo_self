package programmers_lv2_메뉴리뉴얼;

import java.util.*;
import java.util.Map.Entry;

public class Solution {
    public static HashMap<String, Integer> map;
    public ArrayList<String> solution(String[] orders, int[] course) {
        ArrayList<String> answer = new ArrayList<>();

        for(int i =0;i<orders.length;i++){
            char[] charArr = orders[i].toCharArray();
            Arrays.sort(charArr);
            orders[i] = String.valueOf(charArr);
        }

        for(int i = 0; i < course.length; i++) {
            map = new HashMap<>();
            int max = Integer.MIN_VALUE;
            for(int j = 0; j < orders.length; j++) {
                StringBuilder sb = new StringBuilder();
                if(course[i] <= orders[j].length()) {
                    comb(orders[j], sb, 0, 0, course[i]);
                }
            }

            for(Entry<String, Integer> entry : map.entrySet()) {
                max = Math.max(entry.getValue(), max);
            }

            if(max >= 2) {
                for (Entry<String, Integer> entry : map.entrySet()) {
                    if (entry.getValue() == max) answer.add(entry.getKey());
                }
            }
        }
        Collections.sort(answer);
        return answer;
    }

    public static void comb(String order, StringBuilder sb, int idx, int cnt, int n) {
        if(cnt == n) {
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
            return;
        }

        for(int i = idx; i < order.length(); i++) {
            sb.append(order.charAt(i));
            comb(order, sb, i + 1, cnt + 1, n);
            sb.delete(cnt, cnt + 1);
        }
    }
}
