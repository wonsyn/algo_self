import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String num = br.readLine();

        int cnt = 0;
        while(true) {
            long sum = 0;
            if(num.length() <= 1) break;

            for(int i = 0; i < num.length(); i++) {
                sum += num.charAt(i) - '0';
            }

            cnt++;
            num = Long.toString(sum);
        }

        System.out.println(cnt);
        System.out.println(Integer.parseInt(num) % 3 == 0 ? "YES" : "NO");
        br.close();
    }
}