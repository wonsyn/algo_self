import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Set<String>> map = new HashMap<>();
        for(int i = 0; i < N; i++) {
            String g = br.readLine();
            Set<String> set = new HashSet<>();
            int n = Integer.parseInt(br.readLine());
            for(int j = 0; j < n; j++) {
                set.add(br.readLine());
            }
            map.put(g, set);
        }

        StringBuilder sb = new StringBuilder();
        Set<String> keys = map.keySet();
        for(int i = 0; i < M; i++) {
            String s = br.readLine();
            int n = Integer.parseInt(br.readLine());
            if(n == 0) {
                Set<String> set = map.get(s);
                PriorityQueue<String> pq = new PriorityQueue<>(set);

                while(!pq.isEmpty()) {
                    sb.append(pq.poll()).append("\n");
                }
            } else {
                for(String k : keys) {
                    Set<String> set = map.get(k);
                    if(set.contains(s)) {
                        sb.append(k).append("\n");
                        break;
                    }
                }
            }
        }
        System.out.print(sb);
        br.close();
    }
}