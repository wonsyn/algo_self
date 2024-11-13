import java.io.*;
import java.util.StringTokenizer;

public class Main{
    static int[][][] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        dp = new int[21][21][21];
        for(int i = 0; i < 21; i++) {
            for(int j = 0; j < 21; j++) {
                dp[0][i][j] = dp[i][0][j] = dp[i][j][0] = 1;
            }
        }

        for(int i = 1; i < 21; i++) {
            for(int j = 1; j < 21; j++) {
                for(int k = 1; k < 21; k++) {
                    if(i < j && j < k) {
                        dp[i][j][k] = dp[i][j][k - 1] + dp[i][j - 1][k - 1] - dp[i][j - 1][k];
                    } else {
                        dp[i][j][k] = dp[i - 1][j][k] + dp[i - 1][j - 1][k] + dp[i - 1][j][k - 1] - dp[i - 1][j - 1][k - 1];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a == b && b == c && a == -1) break;

            sb.append("w(").append(a).append(", ").append(b).append(", ").append(c)
                    .append(") = ");
            if(a <= 0 || b <= 0 || c <= 0) {
                sb.append(dp[0][0][0]);
            } else if(a > 20 || b > 20 || c > 20) {
                sb.append(dp[20][20][20]);
            } else {
                sb.append(dp[a][b][c]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}