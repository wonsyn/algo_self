import java.io.BufferedReader;
import java.io.InputStreamReader;
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

        Stack<int[]> stack = new Stack<>();
        int[] res = new int[N];
        stack.push(new int[] {0, arr[0]});
        for(int i = 1; i < N; i++) {
            while(!stack.isEmpty() && stack.peek()[1] < arr[i]) {
                res[stack.pop()[0]] = arr[i];
            }
            stack.push(new int[] {i, arr[i]});
        }
        while(!stack.isEmpty()) {
            int[] cur = stack.pop();
            res[cur[0]] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            sb.append(res[i]).append(" ");
        }

        System.out.println(sb);
        br.close();
    }
}
