import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int cnt = 1;
        for(int i = 2; i * i <= N; i++) {
            cnt++;
        }

        System.out.println(cnt);
        br.close();
    }
}