import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int[] numbers;
    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        dp[0] = numbers[0];
        int max = dp[0];
        for(int i = 1; i < N; i++) {
            dp[i] = Math.max(dp[i - 1] + numbers[i], numbers[i]);
            max = Math.max(dp[i], max);
        }

        System.out.println(max);
        br.close();
    }
}