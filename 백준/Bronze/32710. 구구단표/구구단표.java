import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int ans;
        if(N > 81) {
            ans = 0;
        } else if (N == 1){
            ans = 1;
        } else {
            ans = 0;
            for (int i = 2; i < 10; i++) {
                if (N % i == 0 && N / i <= 9) {
                    ans = 1;
                    break;
                }
            }
        }

        System.out.println(ans);
        br.close();
    }
}