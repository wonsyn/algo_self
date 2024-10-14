import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] piece = new int[N * M + 1];

        for(int i = 2; i < piece.length; i++) {
            piece[i] = piece[i - 1] + 1;
        }

        System.out.println(piece[N * M]);
    }
}
