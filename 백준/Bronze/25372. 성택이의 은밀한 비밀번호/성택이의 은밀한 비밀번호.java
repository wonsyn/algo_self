import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            String str = br.readLine();
            int len = str.length();

            System.out.println(len >= 6 && len <= 9 ? "yes" : "no");
        }

        br.close();
    }
}