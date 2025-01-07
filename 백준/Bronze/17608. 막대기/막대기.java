import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int h = arr[N - 1];
        int cnt = 1;
        for(int i = N - 2; i >= 0; i--) {
            if(h < arr[i]) {
                cnt++;
                h = arr[i];
            }
        }

        System.out.println(cnt);
        br.close();
    }
}