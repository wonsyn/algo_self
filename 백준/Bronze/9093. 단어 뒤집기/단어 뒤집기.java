import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) {
                String str = st.nextToken();
                sb.append(reverse(str)).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    static String reverse(String str) {
        String res = "";
        for(int i = str.length() - 1; i >= 0; i--) {
            res += str.charAt(i);
        }
        return res;
    }
}
