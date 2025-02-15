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

        int lh = 0, lc = 0;
        int rh = 0, rc = 0;
        for(int i = 0; i < N; i++) {
            if(lh < arr[i]) {
                lc++;
                lh = arr[i];
            }
            if(rh < arr[N - 1 - i]) {
                rc++;
                rh = arr[N - 1 - i];
            }
        }

        System.out.println(lc + "\n" + rc);
        br.close();
    }
}