import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        
        Map<String, int[]> map = new HashMap<>();
        map.put("E", new int[]{0, 1});
        map.put("W", new int[]{0, -1});
        map.put("S", new int[]{1, 0});
        map.put("N", new int[]{-1, 0});
        
        boolean[][] possible = new boolean[park.length][park[0].length()];
        
        for(int i = 0; i < park.length; i++) {
            for(int j = 0; j < park[0].length(); j++) {
                if(park[i].charAt(j) == 'S') {
                    possible[i][j] = true;
                    answer[0] = i;
                    answer[1] = j;
                } else if(park[i].charAt(j) == 'O') {
                    possible[i][j] = true;
                }
            }
        } 
        
        next: for(String route : routes) {
            String[] rt = route.split(" ");
            int[] dir = map.get(rt[0]);
            int times = Integer.parseInt(rt[1]);
            
             for(int t = 1; t <= times; t++) {
                int nr = answer[0] + dir[0] * t;
                int nc = answer[1] + dir[1] * t;
                
                if(0 > nr || nr >= park.length || 0 > nc || nc >= park[0].length() || !possible[nr][nc]) {
                    continue next;
                }
                
            }
            answer[0] += dir[0] * times;
            answer[1] += dir[1] * times;
        }
        
        
        return answer;
    }
}