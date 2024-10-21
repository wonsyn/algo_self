import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            arr[i] = i;
        }
        
        for(int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }
        
        for(int i = 1; i <= N; i++) {
            sb.append(arr[i]).append(" ");
        }
        
        System.out.println(sb);
        br.close();
    }
}