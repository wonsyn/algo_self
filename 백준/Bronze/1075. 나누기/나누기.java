import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int mod = Integer.parseInt(br.readLine());

        int num = N / 100 * 100;
        for(int i = 0; i < 100; i++) {
            int temp = num + i;
            if(temp % mod == 0) {
                System.out.println(i < 10 ? "0" + i : i);
                break;
            }
        }

        br.close();
    }
}