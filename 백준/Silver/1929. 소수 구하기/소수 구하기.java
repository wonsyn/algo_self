import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		boolean[] arr = new boolean[N + 1];
		arr[0] = arr[1] = true;
		for(int i = 2; i <= Math.sqrt(N); i++) {
			for(int j = 2; i * j <= N; j++) {
				if(!arr[i * j]) {
					arr[i * j] = true;
				}
			}
		}
		
		for(int i = M; i < N + 1; i++) {
			if(!arr[i]) {
				sb.append(i).append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}
