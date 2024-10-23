import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        String num = Integer.toString(N, B);
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < num.length(); i++) {
            if(num.charAt(i) >= 'a' && num.charAt(i) <= 'z') {
                sb.append(Character.toUpperCase(num.charAt(i)));
            } else {
                sb.append(num.charAt(i));
            }
        }

        System.out.println(sb);

        br.close();
    }
}