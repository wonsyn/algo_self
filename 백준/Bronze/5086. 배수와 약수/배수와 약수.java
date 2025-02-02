import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(a == 0 && b == 0) break;

            if (a > b) {
                if(a % b == 0) {
                    sb.append("multiple");
                } else {
                    sb.append("neither");
                }
            } else {
                if(b % a == 0) {
                    sb.append("factor");
                } else {
                    sb.append("neither");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
