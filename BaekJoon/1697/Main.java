package bj_1697_숨바꼭질;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, ans; 
	static int[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visited = new int[100001];
		
		bfs(N);
		
		System.out.println(visited[ans] - 1);
	}
	
	static void bfs(int cur) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(cur);
		visited[cur] = 1;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			if(now == M) {
				ans = now; break;
			}
			
			if(now - 1 >= 0 && visited[now - 1] == 0) {
				visited[now - 1] = visited[now] + 1;
				q.offer(now - 1);
			}
			if(now + 1 < 100001 && visited[now + 1] == 0) {
				visited[now + 1] = visited[now] + 1;
				q.offer(now + 1);
			}
			if(now * 2 < 100001 && visited[now * 2] == 0) {
				visited[now * 2] = visited[now] + 1;
				q.offer(now * 2);
			}
		}
	}
}
