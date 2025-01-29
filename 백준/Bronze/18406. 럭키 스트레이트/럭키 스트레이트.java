import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String num = br.readLine();

        int len = num.length();

        int left = 0, right = 0;
        for(int i = 0; i < len / 2; i++) {
            left += num.charAt(i) - '0';
        }
        for(int i = len / 2; i < len; i++) {
            right += num.charAt(i) - '0';
        }
        System.out.println(left == right ? "LUCKY" : "READY");
        br.close();
    }
}