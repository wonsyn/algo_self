import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Queue<Integer> q = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());
        for(int i = 1; i <= N; i++) {
            q.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        while(q.size() > 0) {
            int n = q.poll();
            sb.append(n).append(" ");
            if(q.size() > 1) {
                q.offer(q.poll());
            }
        }

        System.out.println(sb);
        br.close();
    }
}