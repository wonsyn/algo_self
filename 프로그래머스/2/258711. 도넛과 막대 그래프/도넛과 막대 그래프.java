import java.util.*;

class Solution {
    static int donut, stick, eight, max, add;
    
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];

        int total = 0;
        int[] in = new int[1000001];
        int[] out = new int[1000001];
        donut = stick = eight = 0;
        
        max = -1;
        for(int i = 0; i < edges.length; i++) {
            max = Math.max(edges[i][0], max);
            max = Math.max(edges[i][1], max);
            out[edges[i][0]]++;
            in[edges[i][1]]++;
        }
        
        for(int i = 1; i <= max; i++) {
            if(in[i] >= 2 && out[i] == 2) {
                eight++;
            }
            if(in[i] == 0 && out[i] > 1) {
                add = i;
                total = out[i];
            }
            if(in[i] > 0 && out[i] == 0) {
                stick++;
            }
        }
        
        donut = total - eight - stick;
        answer[0] = add;
        answer[1] = donut;
        answer[2] = stick;
        answer[3] = eight;
        
        return answer;
    }
}