import java.io.*;
import java.util.*;

public class Main {
    static int A, B;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        visited = new boolean[B + 1];

        Queue<Node> q = new ArrayDeque<>();
        visited[A] = true;
        q.offer(new Node(A, 1));
        int ans = -1;
        while(!q.isEmpty()) {
            Node cur = q.poll();
            if(cur.num == B) {
                ans = cur.cnt;
                break;
            }

            if(cur.num * 10 + 1 <= B && !visited[(int)cur.num * 10 + 1]) {
                visited[(int)cur.num * 10 + 1] = true;
                q.offer(new Node(cur.num * 10 + 1, cur.cnt + 1));
            }
            if(cur.num * 2 <= B && !visited[(int)cur.num * 2]) {
                visited[(int)cur.num * 2] = true;
                q.offer(new Node(cur.num * 2, cur.cnt + 1));
            }
        }

        System.out.println(ans);
        br.close();
    }

    static class Node {
        long num;
        int cnt;
        Node(long num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }
}
