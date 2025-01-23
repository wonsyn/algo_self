import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception{
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
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[] temp = new int[k - i];
            for(int x = 0; x < temp.length; x++) {
                temp[x] = arr[i + x];
            }

            for(int x = 0; k + x <= j; x++) {
                arr[i + x] = arr[k + x];
            }

            for(int x = 0; x < temp.length; x++) {
                arr[j - k + i + 1 + x] = temp[x];
            }
        }

        for(int i = 1; i <= N; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb);
        br.close();
    }
}