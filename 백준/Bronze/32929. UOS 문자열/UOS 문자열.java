import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()) % 3;
        
        System.out.println(n == 0 ? "S" : (n == 1 ? "U" : "O"));
        br.close();
    }
}