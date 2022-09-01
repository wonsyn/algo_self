package programmers_lv1_신고결과받기;

import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
    	HashMap<String, Set<String>> map = new HashMap<>(); // 신고 기록을 갖는 맵(신고대상, 신고자 목록)
		HashMap<String, Integer> idMap = new HashMap<>(); // id 값을 갖는 맵
		StringTokenizer st;
		
		for(int i = 0; i < id_list.length; i++) {
			idMap.put(id_list[i], i);
		}

		for(int i = 0; i < report.length; i++) {
			st = new StringTokenizer(report[i]);
			String reporter = st.nextToken();
			String target = st.nextToken();
			
			if(!map.containsKey(target)) {
				map.put(target, new HashSet<>());
			}
			if(map.get(target).contains(reporter)) {
				continue;
			}
			map.get(target).add(reporter);
		}
		
		int[] answer = new int[id_list.length];
		for(int i = 0; i < id_list.length; i++) {
			String key = id_list[i];
			if(map.containsKey(key)) {
				Set<String> s = map.get(key);
				if(s.size() >= k) {
					for(String str : s) {
						answer[idMap.get(str)]++;
					}
				}
			}
		}
		return answer;
    }
}
