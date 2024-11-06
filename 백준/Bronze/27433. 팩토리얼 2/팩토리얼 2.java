import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Integer.parseInt(br.readLine());

        System.out.println(factorial(N));
        br.close();
    }

    static long factorial(long n) {
        if(n == 1 || n == 0) return 1;
        return n * factorial(n - 1);
    }
}