import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        boolean[] qstack = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            qstack[i] = Integer.parseInt(st.nextToken()) != 1;
        }

        Queue<Integer> q = new ArrayDeque<>();
        Stack<Integer> stack = new Stack<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(qstack[i]) stack.push(num);
        }

        while(!stack.isEmpty()) {
            q.offer(stack.pop());
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int m = 0; m < M; m++) {
            q.offer(Integer.parseInt(st.nextToken()));
            sb.append(q.poll()).append(" ");
        }

        System.out.println(sb);
        br.close();
    }
}