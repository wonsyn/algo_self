import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int max = Arrays.stream(diffs).max().getAsInt();
        int min = 1;
        int level = -1;
        
        while(min < max) {
            level = (max + min) / 2;
            
            long time_cur = 0;
            long time_prev = 0;
            long t = 0;
            for(int p = 0; p < diffs.length; p++) {
                int x = diffs[p] - level;
                time_cur = times[p];
                
                if(x > 0) {
                    time_prev = p == 0? 0 : times[p - 1];
                    t += (time_cur + time_prev) * x; 
                }
                t += time_cur;
            }
            
            if(limit >= t) {
                max = level;
            } else {
                min = level + 1;
            }
        }
        
        return max;
    }
}