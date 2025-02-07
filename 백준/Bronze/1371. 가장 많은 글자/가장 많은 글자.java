import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] alpha = new int[26];
        while(true) {
            String str = br.readLine();
            if(str == null) break;

            for(int i = 0; i < str.length(); i++) {
                if(str.charAt(i) != ' ') {
                    alpha[str.charAt(i) - 'a']++;
                }
            }
        }

        int max = -1;
        for(int i = 0; i < 26; i++) {
            max = Math.max(max, alpha[i]);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26; i++) {
            if(alpha[i] == max) {
                sb.append((char)(i + 'a'));
            }
        }
        System.out.println(sb);
        br.close();
    }
}