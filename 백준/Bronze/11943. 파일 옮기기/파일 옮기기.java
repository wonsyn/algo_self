import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken()); // a
        int B = Integer.parseInt(st.nextToken()); // o
        st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken()); // a
        int D = Integer.parseInt(st.nextToken()); // o

        int min = Math.min(A + D, B + C);

        System.out.println(min);
        br.close();
    }
}