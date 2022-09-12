package  programmers_lv2_3차압축;

import java.util.*;

class Solution {
    public int[] solution(String msg) {
        int[] answer = {};
        Map<String, Integer> map = new HashMap<>();
        char character = 'A';
        int idx;
        for(idx = 0; idx < 26; idx++) {
            map.put((char)(character + idx) + "", idx + 1);
        }
        int strIdx = 0;
        ArrayList<Integer> list = new ArrayList<>();
        String prev = "";
        System.out.println(msg.substring(0, 1) + " !!");
        while(strIdx < msg.length()) {
            for(int i = 1; strIdx + i <= msg.length(); i++) {
                String sub = msg.substring(strIdx, strIdx + i);
                if(map.containsKey(sub)) {
                    if(strIdx + i == msg.length()) {
                        list.add(map.get(sub));
                        strIdx += i;
                        break;
                    }
                    prev = sub;
                } else {
                    list.add(map.get(prev));
                    System.out.println(prev);
                    map.put(sub, ++idx);
                    strIdx = strIdx + i - 1;
                    break;
                }
            }
        }

        System.out.println(list.get(0));
        for(int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println("\n" + map.toString());

        answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("KAKAO"));
    }
}