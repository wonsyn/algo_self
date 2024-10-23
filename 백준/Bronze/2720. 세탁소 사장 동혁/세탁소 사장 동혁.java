import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            int cost = Integer.parseInt(br.readLine());

            int q = cost / 25;
            cost %= 25;
            int d = cost / 10;
            cost %= 10;
            int n = cost / 5;
            cost %= 5;
            int p = cost;
            sb.append(q).append(" ").append(d).append(" ").append(n).append(" ").append(p).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}