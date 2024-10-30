import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int max = Math.max(Math.max(a, b), c);
            if(a == 0 && b == 0 && c == 0) break;

            if (a == b && b == c) {
                sb.append("Equilateral\n");
            } else if (a + b <= max || a + c <= max || c + b <= max) {
                sb.append("Invalid\n");
            } else if (a == b || b == c || a == c) {
                sb.append("Isosceles\n");
            } else {
                sb.append("Scalene\n");
            }
        }
        System.out.println(sb);
        br.close();
    }
}