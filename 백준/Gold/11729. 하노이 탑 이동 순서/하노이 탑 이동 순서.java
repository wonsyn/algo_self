import java.io.*;

public class Main{
    static int cnt = 0;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        hanoi(N,1, 2, 3);

        sb.insert(0, cnt + "\n");
        System.out.println(sb);
        br.close();
    }

    static void hanoi(int n, int from, int rest, int to) {
        if(n == 1) {
            sb.append(from).append(" ").append(to).append("\n");
            cnt++;
            return;
        }

        hanoi(n - 1, from, to, rest);

        sb.append(from).append(" ").append(to).append("\n");
        cnt++;

        hanoi(n - 1, rest, from, to);
    }
}