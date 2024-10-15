import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<Integer, String> map2 = new HashMap<>();
        
        for(int i = 0; i < players.length; i++) {
            map1.put(players[i], i);
            map2.put(i, players[i]);
        }
        
        for(int i = 0; i < callings.length; i++) {
            swap(map1, map2, callings[i]);
        }
        
        for(int i = 0; i < players.length; i++) {
            players[i] = map2.get(i);
        }
        
        return players;
    }
    
    void swap(Map<String, Integer> map1, Map<Integer, String> map2, String call) {
        int num = map1.get(call);
        String temp = map2.get(num - 1);
        
        map1.put(call, num - 1);
        map1.put(temp, num);
        map2.put(num - 1, call);
        map2.put(num, temp);
    }
}