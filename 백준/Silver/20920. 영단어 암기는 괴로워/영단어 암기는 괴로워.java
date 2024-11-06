import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        PriorityQueue<Word> pq = new PriorityQueue<>();
        Map<String, Integer> map = new HashMap<>();
        for(int n = 0; n < N; n++) {
            String s = br.readLine();
            if(s.length() >= M) {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }
        Set<String> set = map.keySet();
        for(String s : set) {
            pq.add(new Word(s, map.get(s)));
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            sb.append(pq.poll().word).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    static class Word implements Comparable<Word>{
        String word;
        int cnt;
        Word(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }

        public int compareTo(Word w) {
            if(this.cnt == w.cnt) {
                if(this.word.length() == w.word.length()) {
                    return this.word.compareTo(w.word);
                }
                return w.word.length() - this.word.length();
            }
            return w.cnt - this.cnt;
        }
    }
}