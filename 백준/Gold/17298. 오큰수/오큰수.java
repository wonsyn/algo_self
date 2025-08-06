import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        int[] res = new int[N];
        Arrays.fill(res, -1);
        for(int i = 0; i < N; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                res[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            sb.append(res[i]).append(" ");
        }

        System.out.println(sb);
        br.close();
    }
}
