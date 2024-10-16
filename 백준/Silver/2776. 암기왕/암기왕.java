import java.util.*;
import java.io.*;

public class Main {
    static int T, N, M;
    static int[] note;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            note = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                note[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(note);
            M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < M; i++) {
                int m = Integer.parseInt(st.nextToken());
                boolean isContain = binary(note, m);
                if(!isContain) {
                    sb.append("0").append("\n");
                } else {
                    sb.append("1").append("\n");
                }
            }
        }

        System.out.println(sb);
        br.close();
    }

    static boolean binary(int[] note, int num) {
        int max = note.length;
        int min = 0;

        while(min < max) {
            int mid = (min + max) / 2;
            if(note[mid] > num) {
                max = mid;
            } else if(note[mid] < num) {
                min = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
