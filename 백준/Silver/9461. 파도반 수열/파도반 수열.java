import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        Queue<Integer> q = new ArrayDeque<>(T);
        int max = Integer.MIN_VALUE;
        for(int t = 0; t < T; t++) {
            int temp = Integer.parseInt(br.readLine());
            max = Math.max(max, temp);
            q.offer(temp);
        }

        long[] dp = max >= 10 ? new long[max + 1] : new long[11];

        dp[1] = 1; dp[2] = 1; dp[3] = 1;
        dp[4] = 2; dp[5] = 2; dp[6] = 3;
        dp[7] = 4; dp[8] = 5; dp[9] = 7; dp[10] = 9;

        if(max > 10) {
            for(int i = 11; i <= max; i++) {
                dp[i] = dp[i - 1] + dp[i - 5];
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()) {
            sb.append(dp[q.poll()]).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}