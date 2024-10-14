import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        String block = br.readLine();

        int cb = 1;
        for(int cur = 0; cur < N; cur++) {
            char curB = block.charAt(cur);
            char nextB;
            if(curB == 'B') nextB = 'O';
            else if (curB == 'O') nextB = 'J';
            else nextB = 'B';

            if(dp[cur] != Integer.MAX_VALUE) {
                for (int next = cur + 1; next < N; next++) {
                    if (block.charAt(next) == nextB) {
                        dp[next] = Math.min(dp[next], dp[cur] + (next - cur) * (next - cur));
                    }
                }
            }
        }
        System.out.println(dp[N - 1] == Integer.MAX_VALUE ? -1 : dp[N - 1]);
    }
}
