import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int mod = 10000;
        int sum = 0;
        for(int i = 0; i < 5; i++) {
            int num = n / mod;
            sum += Math.pow(num, 5);
            n %= mod;
            mod /= 10;
        }

        System.out.println(sum);
        br.close();
    }
}