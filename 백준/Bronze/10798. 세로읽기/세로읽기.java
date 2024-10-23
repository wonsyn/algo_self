import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        ArrayList<char[]> list = new ArrayList<>();

        int idx = 0;
        int max = Integer.MIN_VALUE;
        while(true) {
            String s = br.readLine();
            if(s == null) {
                break;
            }
            max = Math.max(s.length(), max);
            list.add(new char[s.length()]);
            for(int i = 0; i < s.length(); i++) {
                list.get(idx)[i] = s.charAt(i);
            }
            idx++;
        }

        for(int j = 0; j < max; j++) {
            for(int i = 0; i < list.size(); i++) {
                if(j < list.get(i).length) {
                    sb.append(list.get(i)[j]);
                }
            }
        }

        System.out.println(sb);
        br.close();
    }
}