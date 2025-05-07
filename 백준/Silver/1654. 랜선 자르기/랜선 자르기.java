import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int max;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] line = new int[K];
		
		for (int i = 0; i < K; i++) {
			line[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(line);
		long max = line[K - 1], min = 1;
		long mid;
		
		while(max >= min) {
			mid = (max + min) / 2;
			int count = 0;
			for(int i = 0; i < line.length; i++) {
				count += line[i] / mid;
			}
			
			if(count >= N) {
				min = mid + 1;
			} else {
				max = mid - 1;
			}
		}
		
		System.out.println(max);
	}
}
