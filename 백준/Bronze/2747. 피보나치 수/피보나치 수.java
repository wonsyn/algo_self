import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] fib = new int[N + 1];
        fib[0] = 0;
        if(N > 0) fib[1] = 1;

        for(int i = 2; i <= N; i++) {
            fib[i] = fib[i - 2] + fib[i - 1];
        }

        System.out.println(fib[N]);
        br.close();
    }
}