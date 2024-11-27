import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int q = Integer.parseInt(br.readLine());
        int[][] count = new int[str.length()][26];
        count[0][str.charAt(0) - 'a']++;

        for(int i = 1; i < str.length(); i++) {
            for(int j = 0; j < 26; j++) {
                count[i][j] = count[i - 1][j];
            }
            count[i][str.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char a = st.nextToken().charAt(0);
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int ans = count[end][a - 'a'] - count[start][a - 'a'];
            if(str.charAt(start) == a) ans++;
            sb.append(ans).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}