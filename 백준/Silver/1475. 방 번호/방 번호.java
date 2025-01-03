import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine();

        int[] numbers = new int[9];
        int ans = 0;

        for(int i = 0; i < N.length(); i++) {
            int n = Integer.parseInt(String.valueOf(N.charAt(i)));

            if(n == 9) n = 6;

            if(numbers[n] != 0) {
                numbers[n]--;
            } else {
                ans++;
                for(int j = 0; j < 9; j++) {
                    numbers[j]++;
                }
                numbers[6]++;
                i--;
            }
        }

        System.out.println(ans);
        br.close();
    }
}