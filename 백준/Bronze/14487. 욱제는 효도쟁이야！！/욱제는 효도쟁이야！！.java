import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] V = new int[N];
        int sum = 0;
        for(int i = 0; i < N; i++) {
            V[i] = Integer.parseInt(st.nextToken());
            sum += V[i];
        }

        sum -= V[0];

        int min = sum;
        for(int p = 0, m = 1; m < N; p++, m++) {
            sum += V[p] - V[m];
            min = Math.min(sum, min);
        }

        System.out.println(min);
        br.close();
    }
}