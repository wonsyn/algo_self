import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int[] numbers = new int[T];
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < T; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
            max = Math.max(numbers[i], max);
        }

        boolean[] check = new boolean[max + 1];
        calc(check);

        for(int i = 0; i < T; i++) {
            int cnt = 0;
            for(int j = 2; j <= numbers[i] / 2; j++) {
                if(!check[j] && !check[numbers[i] - j]) {
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    static void calc(boolean[] check) {
        check[0] = check[1] = true;
        for(int i = 2; i <= Math.sqrt(check.length); i++) {
            if(!check[i]) {
                for(int j = i * i; j < check.length; j += i) {
                    check[j] = true;
                }
            }
        }
    }
}