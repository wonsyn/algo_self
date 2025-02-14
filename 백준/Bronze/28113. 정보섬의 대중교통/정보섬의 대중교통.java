import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        if(N <= B) {
            if(A < B) {
                System.out.println("Bus");
            } else if(B < A) {
                System.out.println("Subway");
            } else {
                System.out.println("Anything");
            }
        } else {
            System.out.println("Bus");
        }

        br.close();
    }
}