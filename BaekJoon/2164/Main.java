package bj_2164_카드2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Queue<Integer> q = new ArrayDeque<Integer>();
		
		for(int i = 1; i <= N; i++) {
			q.offer(i);
		}
		
		while(q.size() != 1) {
			q.poll();
			q.offer(q.poll());
		}
		
		System.out.println(q.poll());
	}
}
