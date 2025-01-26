import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            sb.append(Character.toUpperCase(str.charAt(0))).append(str.substring(1))
                    .append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}