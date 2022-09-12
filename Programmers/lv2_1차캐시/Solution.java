package programmers_lv2_1차캐시;

import java.util.*;

public class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> q = new ArrayDeque<>();
        if(cacheSize == 0) {
            return 5 * cities.length;
        }

        for(String city : cities) {
            if (q.remove(city.toLowerCase())) {
                answer++;
                q.offer(city.toLowerCase());
                continue;
            }

            if(q.size() == cacheSize) q.poll();
            answer += 5;
            q.offer(city.toLowerCase());
        }

        return answer;
    }
}
