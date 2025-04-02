import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            A.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            B.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(A);
        B.sort(Collections.reverseOrder());

        int sum = 0;
        for(int i = 0; i < N; i++) {
            sum += A.get(i) * B.get(i);
        }

        System.out.println(sum);
        br.close();
    }
}