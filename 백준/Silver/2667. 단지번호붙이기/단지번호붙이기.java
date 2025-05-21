import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] map, dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};	// 상 우 하 좌
	static boolean[][] v;
	static List<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		v = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 1 && !v[i][j]) {
					bfs(i, j);
				}
			}
		}
		sb.append(list.size());
		Collections.sort(list);
		for(int i = 0; i < list.size(); i++) {
			sb.append("\n").append(list.get(i));
		}
		System.out.println(sb);
		br.close();
	}
	
	static void bfs(int x, int y) {
		Queue<int[]> q = new ArrayDeque<>();
		v[x][y] = true;
		q.offer(new int[] {x, y});
		int c = 1;
		
		while(!q.isEmpty()) {
			int cx = q.peek()[0];
			int cy = q.poll()[1];
			
			for (int d = 0; d < 4; d++) {
				int nx = cx + dir[d][0];
				int ny = cy + dir[d][1];
				
				if(0 <= nx && nx < N && 0 <= ny && ny < N && map[nx][ny] == 1 && !v[nx][ny] ) {
					v[nx][ny] = true;
					c++;
					q.offer(new int[] {nx, ny});
				}
			}
		}
		list.add(c);
	}
}
