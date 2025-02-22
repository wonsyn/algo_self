import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            switch (s) {
                case "Algorithm":
                    sb.append("204\n");
                    break;
                case "DataAnalysis":
                    sb.append("207\n");
                    break;
                case "ArtificialIntelligence":
                    sb.append("302\n");
                    break;
                case "CyberSecurity":
                    sb.append("B101\n");
                    break;
                case "Network":
                    sb.append("303\n");
                    break;
                case "Startup":
                    sb.append("501\n");
                    break;
                case "TestStrategy":
                    sb.append("105\n");
                    break;
            }
        }

        System.out.println(sb);
        br.close();
    }
}