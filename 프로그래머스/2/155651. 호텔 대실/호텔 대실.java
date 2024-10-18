import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        PriorityQueue<Book> pq = new PriorityQueue<>((b1, b2) -> b1.start - b2.start);
        
        for(int i = 0; i < book_time.length; i++) {
            String[] book = book_time[i];
            String[] start = book[0].split(":");
            String[] end = book[1].split(":");
            int startMin = Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);
            int endMin = Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1]) + 10;
            pq.offer(new Book(startMin, endMin));
            min = Math.min(min, startMin);
            max = Math.max(max, endMin);
        }
            

        PriorityQueue<Book> use = new PriorityQueue<>((b1, b2) -> b1.end - b2.end);
        for(int i = min; i <= max; i++) {
            while(!pq.isEmpty() && pq.peek().start == i) {
                use.offer(pq.poll());
            }
            while(!use.isEmpty() && use.peek().end == i) {
                use.poll();
            }
            answer = Math.max(answer, use.size());
        }                     
        
        return answer;
    }
    
    static class Book { 
        int start;
        int end;
        Book(int start, int end) {
            this.start = start; this.end = end;
        }
    }
}