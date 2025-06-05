import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[] priority = new int[11];
			
			Queue<int[]> q = new ArrayDeque<>();
			
			st = new StringTokenizer(br.readLine());
			
			int count = 0;
			
			for(int i = 0; i < N; i++) {
				int num = Integer.parseInt(st.nextToken());
				q.offer(new int[] {i, num});
				priority[num]++;
			}
			
			while(!q.isEmpty()) {
				int[] cur = q.poll();
				boolean flag = true;
				
				for(int i = cur[1] + 1; i < 11; i++) {
					if(priority[i] != 0) {
						flag = false;
						q.offer(cur);
						break;
					}
				}
				
				if(!flag) continue;
				
				count++;
				priority[cur[1]]--;
				if(cur[0] == M) break;
			}
			
			sb.append(count).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
