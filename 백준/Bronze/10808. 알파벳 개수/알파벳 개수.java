import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int[] cnt = new int[26];

        for(int i = 0; i < str.length(); i++) {
            cnt[str.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26; i++) {
            sb.append(cnt[i]).append(" ");
        }

        System.out.println(sb);
        br.close();
    }
}