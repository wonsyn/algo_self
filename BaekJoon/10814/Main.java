package bj_10814_나이순정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Person implements Comparable<Person> {
		int age;
		String name;
		
		Person(int age, String name) {
			this.age = age; this.name = name;
		}
		
		@Override
		public int compareTo(Person o) {
			return this.age - o.age;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		Person[] arr = new Person[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = new Person(Integer.parseInt(st.nextToken()), st.nextToken());
		}
		
		Arrays.sort(arr);
		
		for(int i = 0; i < N; i++) {
			sb.append(arr[i].age).append(" ").append(arr[i].name).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
