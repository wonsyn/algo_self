import java.io.*;
import java.util.*;

public class Main{
    static int[][] dp = new int[31][31];

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            sb.append(comb(M, N)).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    static int comb(int n, int r) {
        if(dp[n][r] > 0) return dp[n][r];
        else if(n == r || r == 0) return dp[n][r] = 1;
        else return dp[n][r] = comb(n - 1, r - 1) + comb(n - 1, r);
    }
}