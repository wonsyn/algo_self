import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] B = new int[2];
        int[] D = new int[2];
        int[] J = new int[2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        B[0] = Integer.parseInt(st.nextToken());
        B[1] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        D[0] = Integer.parseInt(st.nextToken());
        D[1] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        J[0] = Integer.parseInt(st.nextToken());
        J[1] = Integer.parseInt(st.nextToken());

        int bc = Math.max(Math.abs(J[0] - B[0]), Math.abs(J[1] - B[1]));
        int dc = Math.abs(J[0] - D[0]) + Math.abs(J[1] - D[1]);

        if(bc < dc) {
            System.out.println("bessie");
        } else if(dc < bc) {
            System.out.println("daisy");
        } else {
            System.out.println("tie");
        }
        br.close();
    }
}