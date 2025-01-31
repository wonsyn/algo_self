import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++) {
            boolean[] check = new boolean[26];
            String str = br.readLine();
            for(int i = 0; i < str.length(); i++) {
                check[str.charAt(i) - 'A'] = true;
            }

            int sum = 0;
            for(int i = 0; i < 26; i++) {
                if(!check[i]) {
                    sum += i + 65;
                }
            }
            sb.append(sum).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}