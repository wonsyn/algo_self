package programmers_lv2_1차프렌즈4블록;

import java.util.*;

public class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] lists = new char[m][n];
        boolean[][] check;

        for(int i = 0; i < m; i++) {
            lists[i] = board[i].toCharArray();
        }

        while(true) {
            check = new boolean[m][n];
            int count = 0;
            for(int i = 0; i < m - 1; i++) {
                for(int j = 0; j < n - 1; j++) {
                    if(lists[i][j] != ' ') {
                        count += bomb(i, j, lists, check);
                    }
                }
            }
            if(count == 0) break;
            answer += count;

            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(check[i][j]) lists[i][j] = ' ';
                }
            }

            for(int j = 0; j < n; j++) {
                for(int i = m - 1; i > 0; i--) {
                    if(check[i][j]) {
                        int temp = i;
                        while(--temp >= 0 && check[temp][j]);
                        if(temp != -1) {
                            check[temp][j] = true;
                            lists[i][j] = lists[temp][j];
                            check[i][j] = false;
                        }
                    }
                }
            }
        }

        System.out.println(answer);
        return answer;
    }

    int bomb(int i, int j, char[][] lists, boolean[][] check) {
        int count = 0;
        if(lists[i][j] == lists[i + 1][j] && lists[i + 1][j] == lists[i + 1][j + 1]
                && lists[i + 1][j + 1] == lists[i][j + 1]) {
            if(!check[i][j]) {
                check[i][j] = true; count++;
            }
            if(!check[i + 1][j]) {
                check[i + 1][j] = true; count++;
            }
            if(!check[i][j + 1]) {
                check[i][j + 1] = true; count++;
            }
            if(!check[i + 1][j + 1]) {
                check[i + 1][j + 1] = true; count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(4, 5, new String[] {"CCBDE", "AAADE", "AAABF", "CCBBF"});
    }
}
