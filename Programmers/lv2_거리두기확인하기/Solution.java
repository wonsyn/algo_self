package programmers_lv2_거리두기확인하기;

public class Solution {
    static boolean isBad;
    static boolean[][] visit;
    static char[][] room;
    static int[][] del = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        next: for(int i = 0; i < places.length; i++) {
            room = new char[5][5];
            isBad = false;

            for(int j = 0; j < 5; j++) {
                for(int k = 0; k < 5; k++) {
                    visit = new boolean[5][5];
                    room[j][k] = places[i][j].charAt(k);
                }
            }

            for(int j = 0; j < 5; j++) {
                for(int k = 0; k < 5; k++) {
                    visit = new boolean[5][5];
                    if(room[j][k] == 'P') dfs(j, k, 0);
                    if(isBad) {
                        answer[i] = 0;
                        continue next;
                    }
                }
            }
            answer[i] = 1;
        }

        return answer;
    }

    public void dfs(int x, int y, int cnt) {
        if(0 < cnt && cnt <= 2 && room[x][y] == 'P') {
            isBad = true;
            return;
        }
        if(cnt > 2) return;
        visit[x][y] = true;

        for(int d = 0; d < 4; d++) {
            int nx = x + del[d][0];
            int ny = y + del[d][1];
            if(0 <= nx && nx < 5 && 0 <= ny && ny < 5 && room[nx][ny] != 'X' && !visit[nx][ny]) {
                dfs(nx, ny, cnt + 1);
            }
        }
    }
}
