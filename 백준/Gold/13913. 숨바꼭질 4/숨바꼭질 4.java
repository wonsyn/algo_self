import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] parent;
    static boolean[] visited;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[100001];
        parent = new int[100001];

        bfs();
        System.out.println(sb);
        br.close();
    }

    static void bfs() {
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(N, 0));

        while(!q.isEmpty()) {
            Node cur = q.poll();

            if(cur.x == K) {
                sb.append(cur.time).append("\n");
                Stack<Integer> stack = new Stack<>();

                for(int i = K; i != N; i = parent[i]) {
                    stack.push(i);
                }
                stack.push(N);

                while(!stack.isEmpty()) {
                    sb.append(stack.pop()).append(" ");
                }
                break;
            }

            if(cur.x * 2 <= 100000 && !visited[cur.x * 2]) {
                parent[cur.x * 2] = cur.x;
                visited[cur.x * 2] = true;
                q.offer(new Node(cur.x * 2, cur.time + 1));
            }
            if(cur.x + 1 <= 100000 && !visited[cur.x + 1]) {
                parent[cur.x + 1] = cur.x;
                visited[cur.x + 1] = true;
                q.offer(new Node(cur.x + 1, cur.time + 1));
            }
            if(cur.x - 1 >= 0 && !visited[cur.x - 1]) {
                parent[cur.x - 1] = cur.x;
                visited[cur.x - 1] = true;
                q.offer(new Node(cur.x - 1, cur.time + 1));
            }
        }
    }

    static class Node {
        int x;
        int time;

        Node(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }
}
