import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] numbers = new int[5];
        for(int i = 0; i < 5; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int N = 1;
        int cnt = 0;
        while(true) {
            for(int i = 0; i < 5; i++) {
                if(N % numbers[i] == 0) cnt++;
            }

            if(cnt > 2) {
                break;
            }
            cnt = 0;
            N++;
        }

        System.out.println(N);
        br.close();
    }
}