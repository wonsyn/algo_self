import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        System.out.println(mul(A, B, C));
        br.close();
    }

    static long mul(long a, long b, long c) {
        if(b == 1) {
            return a % c;
        }

        long temp = mul(a, b / 2, c);

        if(b % 2 == 0) {
            return temp * temp % c;
        } else {
            return (temp * temp % c) * a % c;
        }
    }
}