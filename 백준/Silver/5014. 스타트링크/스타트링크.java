import java.io.*;
import java.util.*;

public class Main {
    static int F, S, G, U, D;
    static boolean[] visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 1 ≤ S, G ≤ F ≤ 1000000, 0 ≤ U, D ≤ 1000000
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        visited = new boolean[F + 1];;

        int min = Integer.MAX_VALUE;
        Queue<Node> q = new ArrayDeque<>();
        visited[S] = true;
        q.offer(new Node(S, 0));

        while(!q.isEmpty()) {
            Node cur = q.poll();
            if(cur.cur == G) {
                min = cur.cnt;
                break;
            }

            if(cur.cur + U <= F && !visited[cur.cur + U]) {
                visited[cur.cur + U] = true;
                q.offer(new Node(cur.cur + U, cur.cnt + 1));
            }
            if(cur.cur - D > 0 && !visited[cur.cur - D]) {
                visited[cur.cur - D] = true;
                q.offer(new Node(cur.cur - D, cur.cnt + 1));
            }
        }
        if(min == Integer.MAX_VALUE) {
            System.out.println("use the stairs");
        } else {
            System.out.println(min);
        }

        br.close();
    }

    static class Node {
        int cur;
        int cnt;
        Node(int cur, int cnt) {
            this.cur = cur;
            this.cnt = cnt;
        }
    }
}
