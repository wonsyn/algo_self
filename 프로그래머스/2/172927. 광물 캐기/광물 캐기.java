import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        
        ArrayList<Cost> costs = new ArrayList<>();
        int[][] tired = {{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};
        int pickCnt = 0;
        for(int i = 0; i < 3; i++) {
            pickCnt += picks[i];
        }
        
        for(int i = 0; i < minerals.length; i += 5) {
            if(pickCnt == 0) break;
            
            int di = 0, ir = 0, st = 0;
            for(int j = i; j < i + 5; j++) {
                if(j == minerals.length) break;
                
                String m = minerals[j];
                int cost = -1;
                if(m.equals("diamond")) cost = 0;
                else if(m.equals("iron")) cost = 1;
                else if(m.equals("stone")) cost = 2;
                
                di += tired[0][cost];
                ir += tired[1][cost];
                st += tired[2][cost];
            }
            
            costs.add(new Cost(di, ir, st));
            pickCnt--;
        }
        
        Collections.sort(costs, (c1, c2) -> c2.s - c1.s);
        
        for(Cost c : costs) {
            if(picks[0] > 0) {
                answer += c.d;
                picks[0]--;
            } else if(picks[1] > 0) {
                answer += c.i;
                picks[1]--;
            } else {
                answer += c.s;
                picks[2]--;
            }
        }
        
        
        return answer;
    }
    
    class Cost {
        int d; int i; int s;
        Cost(int d, int i, int s) {
            this.d = d; this.i = i; this.s = s;
        }
    }
}