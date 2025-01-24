import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            sb.append(i % 2 == 0 ? "* ".repeat(N) : " *".repeat(N))
                    .append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}