import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str;

        while(true) {
            str = br.readLine();
            if(str == null) {
                break;
            }

            int[] cnt = new int[4];
            for(int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                if('a' <= c && c <= 'z') {
                    cnt[0]++;
                } else if('A' <= c && c <= 'Z') {
                    cnt[1]++;
                } else if('0' <= c && c <= '9') {
                    cnt[2]++;
                } else if(c == ' ') {
                    cnt[3]++;
                }
            }

            for(int i = 0; i < 4; i++) {
                sb.append(cnt[i]).append(" ");
            }
        }

        System.out.println(sb);
        br.close();
    }
}