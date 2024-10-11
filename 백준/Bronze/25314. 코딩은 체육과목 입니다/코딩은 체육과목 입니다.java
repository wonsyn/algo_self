import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int cnt = 0;
        while(cnt * 4 < N) {
            cnt++;
        }
        System.out.println("long ".repeat(cnt) + "int");
    }
}
