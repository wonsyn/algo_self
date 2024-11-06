import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Deque<int[]> dq = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            dq.add(new int[] {i, Integer.parseInt(st.nextToken())});
        }

        int[] cur = dq.pollFirst();
        sb.append(cur[0]).append(" ");
        while(!dq.isEmpty()) {
            if(cur[1] < 0) {
                for(int i = 0; i > cur[1]; i--) {
                    dq.addFirst(dq.pollLast());
                }
                cur = dq.pollFirst();
                sb.append(cur[0]).append(" ");
            } else {
                for(int i = 0; i < cur[1]; i++) {
                    dq.addLast(dq.pollFirst());
                }
                cur = dq.pollLast();
                sb.append(cur[0]).append(" ");
            }
        }

        System.out.println(sb);
        br.close();
    }
}