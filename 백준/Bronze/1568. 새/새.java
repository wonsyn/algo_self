import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int cur = 1;
        int time = 0;
        while(true) {
            if(cur > N) {
                cur = 1;
            }

            N -= cur++;
            time++;
            if(N == 0) break;
        }

        System.out.println(time);
        br.close();
    }
}