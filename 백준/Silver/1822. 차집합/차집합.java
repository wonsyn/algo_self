import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> set = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < A; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < B; i++) {
            set.remove(Integer.parseInt(st.nextToken()));
        }

        StringBuilder sb = new StringBuilder();
        sb.append(set.size());
        if(set.size() != 0) {
            sb.append("\n");
            PriorityQueue<Integer> pq = new PriorityQueue<>(set);
            while(!pq.isEmpty()) {
                sb.append(pq.poll()).append(" ");
            }
        }
        System.out.println(sb);
        br.close();
    }
}