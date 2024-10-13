import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long X;
    static long[][] burger;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        X = Long.parseLong(st.nextToken());
        burger = new long[N + 1][2];
        burger[0][0] = 1;
        burger[0][1] = 1;
        for(int i = 1; i <= N; i++) {
            burger[i][0] = 2 * burger[i - 1][0] + 1;
            burger[i][1] = 2 * burger[i][0] - 1;
        }

        long ans = 0;
        for(int i = N; X > 0 && i >= 0; i--) {
            if(i == 0) {
                ans++; X--;
                break;
            }
            if(burger[i][1] / 2 + 1 <= X) {
                ans += burger[i - 1][0] + 1;
                X -= burger[i - 1][1] + 2;
            } else {
                X--;
            }
        }
        System.out.println(ans);
        br.close();
    }
}
