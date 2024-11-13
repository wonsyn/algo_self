import java.io.*;
import java.util.StringTokenizer;

public class Main{
    static int N, rCnt, dCnt;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        rCnt = 0; dCnt = 0;
        fib(N);
        fibonacci(N);

        System.out.println(rCnt + " " + dCnt);
        br.close();
    }

    static int fib(int n) {
        if(n == 1 || n == 2) {
            rCnt++;
            return 1;
        }
        else return fib(n - 2) + fib(n - 1);
    }

    static int fibonacci(int n) {
        int[] dp = new int[n + 1];
        dp[1] = dp[2] = 1;
        for(int i = 3; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
            dCnt++;
        }
        return dp[n];
    }
}