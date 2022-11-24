package programmers_lv2_주차요금계산;

import java.util.*;

public class Solution {
    public int[] solution(int[] fees, String[] records) { // fees[0]=기본시간(분), fees[1]=기본요금(원)
                                                            // fees[2]= 단위시간(분), fees[3]=단위요금(원)
                                                            // records = "시각(HH:MM) 차량번호(4자리) 내역(IN, OUT)"
        Map<Integer, Integer> timeMap = new HashMap<>();
        Map<Integer, String> map = new HashMap<>();

        int[] answer;
        for(int i = 0; i < records.length; i++) {
            String[] record = records[i].split(" ");
            if(record[2].equals("IN")) {
                map.put(Integer.parseInt(record[1]), record[0]);
            } else {
                String inTime = map.remove(Integer.parseInt(record[1]));
                int diff = calcTime(inTime, record[0]);

                if(timeMap.containsKey(Integer.parseInt(record[1]))) {
                    int temp = timeMap.get(Integer.parseInt(record[1]));
                    timeMap.put(Integer.parseInt(record[1]), temp + diff);
                } else {
                    timeMap.put(Integer.parseInt(record[1]), diff);
                }
            }
        }

        Integer[] keyList = map.keySet().toArray(new Integer[0]);
        int idx = 0;
        while(map.size() != 0) {
            String inTime = map.remove(keyList[idx]);
            int diff = calcTime(inTime, "23:59");

            if(timeMap.containsKey(keyList[idx])) {
                int temp = timeMap.get(keyList[idx]);
                timeMap.put(keyList[idx], temp + diff);
            } else {
                timeMap.put(keyList[idx], diff);
            }
            idx++;
        }

        keyList = timeMap.keySet().toArray(new Integer[0]);
        Arrays.sort(keyList);
        answer = new int[keyList.length];
        for(idx = 0; idx < keyList.length; idx++) {
            int time = timeMap.get(keyList[idx]);
            if(time <= fees[0]) {
                answer[idx] = fees[1];
                continue;
            }
            int fee = fees[1];
            time -= fees[0];
            if (time % fees[2] != 0) {
                fee += (time / fees[2] + 1) * fees[3];
            } else {
                fee += time / fees[2] * fees[3];
            }
            answer[idx] = fee;
        }

        return answer;
    }

    public int calcTime(String in, String out) {
        String[] inTime = in.split(":");
        String[] outTime = out.split(":");

        int hour = Integer.parseInt(outTime[0]) - Integer.parseInt(inTime[0]);
        int min = Integer.parseInt(outTime[1]) - Integer.parseInt(inTime[1]);
        if(min < 0)  {
            min += 60;
            hour--;
        }

        return (60 * hour) + min;
    }
}
