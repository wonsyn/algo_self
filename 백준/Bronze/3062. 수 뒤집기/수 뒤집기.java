import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            String num = br.readLine();
            int n1 = Integer.parseInt(num);
            int res = Integer.parseInt(new StringBuffer(num).reverse().toString()) + n1;
            String ans = Integer.toString(res);

            boolean check = true;
            for(int i = 0; i < ans.length() / 2; i++) {
                if(ans.charAt(i) != ans.charAt(ans.length() - 1 - i)) {
                    check = false;
                    break;
                }
            }
            sb.append(check? "YES\n" : "NO\n");
        }

        System.out.println(sb);
        br.close();
    }
}