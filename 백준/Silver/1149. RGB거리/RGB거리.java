import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Color[][] dp = new Color[N][3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        Color R = new Color(Integer.parseInt(st.nextToken()), 'R');
        Color G = new Color(Integer.parseInt(st.nextToken()), 'G');
        Color B = new Color(Integer.parseInt(st.nextToken()), 'B');
        dp[0][0] = R;
        dp[0][1] = G;
        dp[0][2] = B;

        for(int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            Color[] arr = new Color[3];
            arr[0] = new Color(Integer.parseInt(st.nextToken()), 'R');
            arr[1] = new Color(Integer.parseInt(st.nextToken()), 'G');
            arr[2] = new Color(Integer.parseInt(st.nextToken()), 'B');


            for(int j = 0; j < 3; j++) {
                Color cur = arr[j];

                for(int x = 0; x < 3; x++) {
                    Color pre = dp[i - 1][x];
                    if(pre.color != cur.color) {
                        if(dp[i][j] == null) {
                            dp[i][j] = new Color(pre.cost + cur.cost, cur.color);
                        } else {
                            dp[i][j] = dp[i][j].cost > pre.cost + cur.cost ? new Color(pre.cost + cur.cost, cur.color) : dp[i][j];
                        }
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < 3; i++) {
            min = Math.min(min, dp[N - 1][i].cost);
        }

        System.out.println(min);
        br.close();
    }

    static class Color {
        int cost;
        char color;
        Color(int cost, char color) {
            this.color = color;
            this.cost = cost;
        }
    }
}
