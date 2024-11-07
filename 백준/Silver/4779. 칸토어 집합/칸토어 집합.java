import java.io.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s;
        while((s = br.readLine()) != null) {
            int N = Integer.parseInt(s);
            int len = (int)Math.pow(3, N);

            sb.append(kt(len, N)).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    static String kt(int len, int n) {
        if(n == 1) return "- -";
        if(n == 0) return "-";
        int div = len / 3;
        return kt(div, n - 1) + " ".repeat(div) + kt(div, n - 1);
    }
}