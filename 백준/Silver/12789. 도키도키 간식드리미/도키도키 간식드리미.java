import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> q = new ArrayDeque<>();
        Stack<Integer> stack = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            q.offer(Integer.parseInt(st.nextToken()));
        }

        int cur = 1;
        boolean possible = false;
        while(!q.isEmpty() || !stack.isEmpty()) {
            if(!q.isEmpty() && q.peek() == cur) {
                q.poll();
                cur++;
                continue;
            } else if(!stack.isEmpty() && stack.peek() == cur) {
                stack.pop();
                cur++;
                continue;
            }

            if(stack.isEmpty() && !q.isEmpty()) {
                stack.push(q.poll());
            } else if(!q.isEmpty() && stack.peek() > q.peek()) {
                stack.push(q.poll());
            } else {
                break;
            }
        }
        if(q.isEmpty() && stack.isEmpty()) possible = true;

        System.out.println(possible ? "Nice" : "Sad");
        br.close();
    }
}