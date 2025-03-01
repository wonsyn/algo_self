import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        PriorityQueue<Book> pq = new PriorityQueue<>(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                if(o1.cnt == o2.cnt) {
                    return o1.name.compareTo(o2.name);
                } else {
                    return o2.cnt - o1.cnt;
                }
            }
        });
        Set<String> keys = map.keySet();
        for(String s : keys) {
            pq.offer(new Book(s, map.get(s)));
        }

        System.out.println(pq.peek().name);
        br.close();
    }

    static class Book {
        String name;
        int cnt;

        Book(String name, int cnt) {
            this.name = name; this.cnt = cnt;
        }
    }
}