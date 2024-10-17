import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        
        PriorityQueue<Plan> pq = new PriorityQueue<>((p1, p2) -> p1.start - p2.start);
        Stack<Plan> stack = new Stack<>();
        int start = Integer.MAX_VALUE;
        int idx = 0;
        for(int i = 0; i < plans.length; i++) {
            String[] time = plans[i][1].split(":");
            int min = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
            start = Math.min(start, min);
            pq.offer(new Plan(plans[i][0], min, Integer.parseInt(plans[i][2])));
        }
        
        Plan p = null;
        while(!pq.isEmpty() || !stack.isEmpty() || p != null) {
            if(!pq.isEmpty() && pq.peek().start == start) {
                if(p != null) stack.push(p);
                p = pq.poll();  
            } else if(p == null && !stack.isEmpty()){
                p = stack.pop();
            }
            
            if(p != null) {
                if(--p.playtime == 0) {
                    answer[idx++] = p.name;
                    p = null;
                }
            }
            start++;
        }
        
        return answer;
    }
    
    class Plan {
        String name;
        int start;
        int playtime;
        
        Plan(String name, int start, int playtime) {
            this.name = name; this.start = start; this.playtime = playtime;
        }
    }
}