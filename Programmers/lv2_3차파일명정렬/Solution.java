package programmers_lv2_3차파일명정렬;

import java.util.*;

public class Solution {
    public static class File implements Comparable<File>{
        String fileName;
        String head;
        int number, idx;

        File(String fileName, String head, int number, int idx) {
            this.fileName = fileName; this.head = head; this.number = number; this.idx = idx;
        }

        @Override
        public int compareTo(File o) {
            if(head.equalsIgnoreCase(o.head)) {
                if(number == o.number) return idx - o.idx;
                return number - o.number;
            }
            return head.toLowerCase().compareTo(o.head.toLowerCase());
        }
    }

    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        PriorityQueue<File> pq = new PriorityQueue<>();

        for (int i = 0; i < files.length; i++) {
            StringBuilder head = new StringBuilder();
            StringBuilder num = new StringBuilder();
            boolean isNum = false;
            for (int j = 0; j < files[i].length(); j++) {
                char c = files[i].charAt(j);
                if ('0' <= c && c <= '9') {
                    num.append(c);
                    isNum = true;
                } else {
                    if (!isNum) head.append(c);
                    else break;
                }
            }
            pq.offer(new File(files[i], head.toString(), Integer.parseInt(num.toString()), i));
        }

        for(int i = 0; i < answer.length; i++) {
            answer[i] = pq.poll().fileName;
        }
        return answer;
    }
}
