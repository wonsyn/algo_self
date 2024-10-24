import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N + 1];
        arr[0] = 2;
        for(int i = 1; i <= N; i++) {
            arr[i] = 2 * arr[i - 1] - 1;
        }

        System.out.println(arr[N] * arr[N]);

        br.close();
    }
}
