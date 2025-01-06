import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        System.out.println(rev(rev(X) + rev(Y)));

        br.close();
    }

    public static int rev(int n) {
        String s = Integer.toString(n);

        StringBuilder sb = new StringBuilder();

        for(int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return Integer.parseInt(sb.toString());
    }
}