import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.println(fibo(N));
        br.close();
    }

    static int fibo(int n) {
        if(n == 1) return 1;
        if(n == 0) return 0;
        return fibo(n - 1) + fibo(n - 2);
    }
}