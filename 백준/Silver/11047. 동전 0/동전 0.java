import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Stack<Integer> stack = new Stack<>();

        for(int i = 0 ; i < N; i++) {
            stack.push(Integer.parseInt(br.readLine()));
        }

        int cnt = 0;
        while(K != 0) {
            int num = stack.pop();

            int div = K / num;
            cnt += div;
            K -= div * num;
        }

        System.out.println(cnt);
        br.close();
    }
}