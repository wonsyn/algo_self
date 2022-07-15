package bj_1654_랜선자르기;

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
		long max = line[K - 1];	// max: 절대 답이 될 수 없는 값(가장 큰 값)
		long min = 1;	// min: 무조건 답이 될 수 있는 값(가장 작은 값)
		long mid;	// mid 를 구하는 과정에서 int 의 범위를 벗어나는 값이 나오기 떄문에 long 선언
		
		while(max >= min) { // 최소와 최대가 역전될 때까지 반복
			mid = (max + min) / 2;	// 중간값 계산
			int count = 0;
			for(int i = 0; i < line.length; i++) {	// 숫자 카운팅
				count += line[i] / mid;
			}
			
			if(count >= N) {
				min = mid + 1;	// 카운트 한 수가 목표보다 많은 경우 최소값을 중간값 + 1 (자연수이기 때문)
			} else {
				max = mid - 1;	// 카운트 한 수가 목표보다 적은 경우 최대값을 중간값 - 1 (자연수이기 때문)
			}
		}
		
		System.out.println(max);
	}
}
