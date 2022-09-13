package programmers_lv2_오픈채팅방;

import java.util.*;

public class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        ArrayList<String> ans = new ArrayList<>();
        Map<String, String> map = new HashMap<>();

        for(int i = 0; i < record.length; i++) {
            String[] arr = record[i].split(" ");
            switch(arr[0]) {
                case "Enter":
                    map.put(arr[1], arr[2]);
                    ans.add(arr[1] + "님이 들어왔습니다.");
                    break;
                case "Leave":
                    ans.add(arr[1] + "님이 나갔습니다.");
                    break;
                case "Change":
                    map.put(arr[1], arr[2]);
                    break;
            }
        }

        answer = new String[ans.size()];
        for(int i = 0; i < ans.size(); i++) {
            String line = ans.get(i);
            int idx = line.indexOf("님");
            String str = line.substring(0, idx);
            answer[i] = line.replaceAll(str, map.get(str));
        }
        return answer;
    }
}
