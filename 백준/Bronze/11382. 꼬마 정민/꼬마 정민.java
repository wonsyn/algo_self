import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long sum = 0;

        for(int i = 0; i < 3; i++) {
            sum += Long.parseLong(st.nextToken());
        }
        System.out.println(sum);
    }
}
