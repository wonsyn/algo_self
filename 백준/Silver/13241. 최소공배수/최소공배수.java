import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());

        System.out.println((A * B) / gcd(Math.max(A, B), Math.min(A, B)));

        br.close();
    }

    public static long gcd(long a, long b) {
        while(b != 0) {
            long r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}