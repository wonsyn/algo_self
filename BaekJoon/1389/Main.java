package bj_1389_케빈베이컨의6단계법칙;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] graph;
	static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new int[N + 1][N + 1];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			graph[from][to] = 1;
			graph[to][from] = 1;
		}
		
		int min = Integer.MAX_VALUE, minPerson = -1;
		for(int i = 1; i <= N; i++) {
			int kb = 0;
			int[] visited = new int[N + 1];
			
			Queue<Integer> q = new ArrayDeque<>();
			visited[i] = 1;
			q.offer(i);
			
			while(!q.isEmpty()) {
				int cur = q.poll();
				
				for(int j = 1; j <= N; j++) {
					if(graph[cur][j] == 1 && visited[j] == 0) {
						visited[j] = visited[cur] + 1;
						q.offer(j);
					}
				}
			}
			
			visited[i] = 0;
			for(int j = 1; j <= N; j++) {
				kb += visited[j];
			}
			
			if(kb < min) {
				min = kb; minPerson = i;
			}
		}
		System.out.print(minPerson);
	}
}
