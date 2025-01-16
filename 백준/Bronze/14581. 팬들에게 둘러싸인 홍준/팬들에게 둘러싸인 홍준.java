import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String cp = ":fan:";
        String id = br.readLine();

        StringBuilder sb = new StringBuilder();

        sb.append(cp.repeat(3)).append("\n")
                .append(cp).append(":").append(id).append(":").append(cp).append("\n")
                .append(cp.repeat(3));

        System.out.println(sb);
        br.close();
    }
}