import java.io.*;
import java.util.*;

public class Main {
	static int N, M, D, max = Integer.MIN_VALUE;
	static int[][] map;
	static int[][] del = {{0, -1}, {-1, 0}, {0, 1}}; // 좌 상 우
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		map = new int[N + 1][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		subset(0, 0, new boolean[M]);
		
		System.out.println(max);
		br.close();
	}
	
	static void subset(int start, int cnt, boolean[] archer) {
		if(cnt == 3) {
			int[][] copy = new int[N + 1][M];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					copy[i][j] = map[i][j];
				}
			}
			max = Math.max(max, game(archer, copy));
			return;
		}
		
		for(int i = start; i < M; i++) {
			archer[i] = true;
			subset(i + 1, cnt + 1, archer);
			archer[i] = false;
		}
	}
	
	static int game(boolean[] temp, int[][] copy) {
		int[] archer = new int[3];
		int idx = 0;
		int cnt = 0;
		
		for(int a = 0; a < M; a++) {
			if (temp[a]) archer[idx++] = a;
		}
		
		for(int t = 0; t < N; t++) {
			// 잡기
			List<int[]> removeList = new ArrayList<int[]>();
			for(int i = 0; i < 3; i++) {
				boolean[][] v = new boolean[N + 1][M];
				Queue<int[]> q = new ArrayDeque<int[]>();
				v[N][archer[i]] = true;
				q.offer(new int[] {N, archer[i]});
				shoot: for(int range = 0; range < D; range++) {
					int size = q.size();
					while(size-- > 0) {
						int r = q.peek()[0];
						int c = q.poll()[1];
						for(int d = 0; d < 3; d++) {
							int nr = r + del[d][0];
							int nc = c + del[d][1];
							if(0 <= nr && nr <= N && 0 <= nc && nc < M && !v[nr][nc]) {
								if(copy[nr][nc] == 1) {
									removeList.add(new int[] {nr, nc});
									break shoot;
								}
								v[nr][nc] = true;
								q.offer(new int[] {nr, nc});
							}
						}
					}
				}
			}
			
			// 잡은 적 제거
			for(int[] target : removeList) {
				if(copy[target[0]][target[1]] == 1) {
					copy[target[0]][target[1]] = 0;
					cnt++;
				}
			}
			
			// 내리기
			for(int i = N - 1; i > t; i--) {
				copy[i] = copy[i - 1];
			}
		}
		
		return cnt;
	}
}
