import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for(int t = 0; t < T; t++) {
            String s = br.readLine();
            sb.append(s.charAt(0)).append(s.charAt(s.length() - 1)).append("\n");
        }
        
        System.out.println(sb);
        br.close();
    }
}