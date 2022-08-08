package bj_1260_DFS와BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		boolean[][] graph = new boolean[N + 1][N + 1];
		boolean[] visit = new boolean[N + 1];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[r][c] = graph[c][r] = true; 
		}
		
		dfs(V, visit, graph, sb);
		sb.append("\n");
		visit = new boolean[N + 1];
		bfs(V, visit, graph, sb);
		
		System.out.print(sb.toString());
	}
	
	static void dfs(int start, boolean[] visit, boolean[][] graph, StringBuilder sb) {
		visit[start] = true;
		sb.append(start).append(" ");
		
		for(int i = 1; i < graph.length; i++) {
			if(graph[start][i] && !visit[i]) {
				dfs(i, visit, graph, sb);
			}
		}
	}
	
	static void bfs(int start, boolean[] visit, boolean[][] graph, StringBuilder sb) {
		Queue<Integer> q = new ArrayDeque<>();
		visit[start] = true;
		q.offer(start);
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			sb.append(cur).append(" ");
			
			for(int i = 0; i < graph.length; i++) {
				if(graph[cur][i] && !visit[i]) {
					visit[i] = true;
					q.offer(i);
				}
			}
		}
	}
}
