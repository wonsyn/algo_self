import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Character>[] address;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        address = new ArrayList[8];
        for(int i = 0; i < 8; i++) {
            address[i] = new ArrayList<>();
        }

        int colons = 0;
        for(int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ':') {
                colons++;
            }
        }

        int blank = 8 - colons + 1;
        int i = 0;
        for(int j = 0; j < str.length(); j++) {
            if(str.charAt(j) == ':') {
                if(j + 1 < str.length() && str.charAt(j + 1) == ':')
                    i += blank - 1;
                else i++;
            } else {
                address[i].add(str.charAt(j));
            }
        }

        for(i = 0; i < 8; i++) {
            if(address[i].size() == 0) {
                for(int j = 0; j < 4; j++) {
                    address[i].add('0');
                }
            } else {
                int cnt = 4 - address[i].size();
                for(int j = 0; j < cnt; j++) {
                    address[i].add(0, '0');
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(i = 0; i < 8; i++) {
            for(int j = 0; j < 4; j++) {
                sb.append(address[i].get(j));
            }
            if(i != 7) {
                sb.append(":");
            }
        }

        System.out.println(sb);
        br.close();
    }
}
