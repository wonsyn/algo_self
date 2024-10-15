import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = -1;
        int[] ans = new int[friends.length];
        
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < friends.length; i++) {
            map.put(friends[i], i);
        }
        
        int[][] present = new int[friends.length][friends.length];
        int[][] count = new int[friends.length][2]; // 준, 받은
        
        for(int i = 0; i < gifts.length; i++) {
            String[] gift = gifts[i].split(" ");
            int from = map.get(gift[0]);
            int to = map.get(gift[1]);
            
            present[from][to]++;
            count[from][0]++;
            count[to][1]++;
        }
        
        for(int i = 0; i < friends.length - 1; i++) {
            for(int j = i + 1; j < friends.length; j++) {
                if(present[i][j] != 0 || present[j][i] != 0) {
                    if(present[i][j] != present[j][i] ) {
                        if(present[i][j] > present[j][i]) {
                            ans[i]++;
                        } else {
                            ans[j]++;
                        }
                    }
                }
                if((present[i][j] == 0 && present[j][i] == 0) || present[i][j] == present[j][i]) {
                    int ratioI = count[i][0] - count[i][1];
                    int ratioJ = count[j][0] - count[j][1];
                    if(ratioI > ratioJ) {
                        ans[i]++;
                    } else if(ratioI < ratioJ) {
                        ans[j]++;
                    }
                }
            }
        }
        
        for(int i = 0; i < ans.length; i++) {
            answer = Math.max(answer, ans[i]);
        }
        return answer;
    }
}