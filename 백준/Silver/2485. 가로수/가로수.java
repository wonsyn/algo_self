import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int gcd = arr[1] - arr[0];
        for(int i = 1; i < N - 1; i++) {
            int temp = arr[i + 1] - arr[i];
            gcd = gcd(Math.max(gcd, temp), Math.min(gcd, temp));
        }

        int cur = arr[0];
        int cnt = 0;
        for(int i = 1; i < N; i++) {
            cur += gcd;
            if(cur != arr[i]) {
                cnt++; i--;
            }
        }

        System.out.println(cnt);
        br.close();
    }

    public static int gcd(int a, int b) {
        while(b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}