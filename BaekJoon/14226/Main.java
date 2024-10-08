package bj_14226_이모티콘;

import java.io.*;
import java.util.*;

public class Main {
    static int S, res = Integer.MAX_VALUE;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/bj_14226_이모티콘/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = Integer.parseInt(br.readLine());
        visited = new boolean[2001][2001];

        bfs();
        System.out.println(res);
        br.close();
    }

    static void bfs() {
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(0, 1, 0));

        while(!q.isEmpty()) {
            Node cur = q.poll();
            System.out.println(cur);
            if(cur.now == S) {
                res = Math.min(res, cur.time);
                break;
            }

            //클립보드 저장
            if(!visited[cur.now][cur.now]) {
                q.offer(new Node(cur.now, cur.now, cur.time + 1));
            }
            //클립보드 붙여넣기
            if(cur.now + cur.clip <= 2000 && !visited[cur.clip][cur.now + cur.clip] && cur.clip != 0) {
                visited[cur.clip][cur.now + cur.clip] = true;
                q.offer(new Node(cur.clip, cur.now + cur.clip, cur.time + 1));
            }
            //이모티콘 1개 삭제
            if(!visited[cur.clip][cur.now - 1] && cur.now != 1) {
                visited[cur.clip][cur.now - 1] = true;
                q.offer(new Node(cur.clip, cur.now - 1, cur.time + 1));
            }
        }
    }

    static class Node {
        int clip;
        int now;
        int time;
        Node(int clip, int now, int time) {
            this.clip = clip; this.now = now; this.time = time;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("--".repeat(Math.max(0, time))).append("clip: ").append(clip).append("\n")
                    .append("--".repeat(Math.max(0, time))).append("now: ").append(now).append("\n")
                    .append("--".repeat(Math.max(0, time))).append("time: ").append(time).append("\n");
            return sb.toString();
        }
    }
}
