import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        boolean[][] visited = new boolean[N][N];

        st = new StringTokenizer(br.readLine());
        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());

        Queue<Node> q = new ArrayDeque<>();
        visited[r1][c1] = true;
        q.offer(new Node(r1, c1, 0));
        int ans = -1;

        while(!q.isEmpty()) {
            Node cur = q.poll();
            if(cur.r == r2 && cur.c == c2) {
                ans = cur.cnt;
                break;
            }

            // (r-2, c-1)
            if(0 <= cur.r - 2 && 0 <= cur.c - 1 && !visited[cur.r - 2][cur.c - 1]) {
                visited[cur.r - 2][cur.c - 1] = true;
                q.offer(new Node(cur.r - 2, cur.c - 1, cur.cnt + 1));
            }
            // (r-2, c+1)
            if(0 <= cur.r - 2 && cur.c + 1 < N && !visited[cur.r - 2][cur.c + 1]) {
                visited[cur.r - 2][cur.c + 1] = true;
                q.offer(new Node(cur.r - 2, cur.c + 1, cur.cnt + 1));
            }
            // (r, c-2)
            if(0 <= cur.c - 2 && !visited[cur.r][cur.c - 2]) {
                visited[cur.r][cur.c - 2] = true;
                q.offer(new Node(cur.r, cur.c - 2, cur.cnt + 1));
            }
            // (r, c+2)
            if(cur.c + 2  < N && !visited[cur.r][cur.c + 2]) {
                visited[cur.r][cur.c + 2] = true;
                q.offer(new Node(cur.r, cur.c + 2, cur.cnt + 1));
            }
            // (r+2, c-1)
            if(cur.r + 2 < N && 0 <= cur.c - 1 && !visited[cur.r + 2][cur.c - 1]) {
                visited[cur.r + 2][cur.c - 1] = true;
                q.offer(new Node(cur.r + 2, cur.c - 1, cur.cnt + 1));
            }
            // (r+2, c+1)
            if(cur.r + 2 < N && cur.c + 1 < N && !visited[cur.r + 2][cur.c + 1]) {
                visited[cur.r + 2][cur.c + 1] = true;
                q.offer(new Node(cur.r + 2, cur.c + 1, cur.cnt + 1));
            }
        }
        System.out.println(ans);
        br.close();
    }

    static class Node{
        int r; int c;
        int cnt;
        Node(int r, int c, int cnt) {
            this.r = r; this.c = c;
            this.cnt = cnt;
        }
    }
}
