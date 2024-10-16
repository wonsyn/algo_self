import java.util.*;

class Solution {
    static int[][] map;
    
    public int solution(int[][] points, int[][] routes) {
        int answer;
        
        map = new int[101][101];
        Robot[] robots = new Robot[routes.length];
        for(int i = 0; i < robots.length; i++) {
            robots[i] = new Robot(points[routes[i][0] - 1][0], points[routes[i][0] - 1][1]);
            for(int j = 1; j < routes[i].length; j++) {
                robots[i].list.add(points[routes[i][j] - 1]);
            }
            map[robots[i].r][robots[i].c]++;
        }
        
        boolean done = count(robots);
        answer = check(map);
        while(!done) {
            move(map, robots);
            int chk = check(map);
            if(chk == 0) {
                done = count(robots);
            } else {
                answer += chk;
            }
        }

        return answer;
    }
    
    int check(int[][] map) {
        int cnt = 0;
        for(int i = 1; i < 101; i++) {
            for(int j = 1; j < 101; j++) {
                if(map[i][j] > 1) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
    
    boolean count(Robot[] robots) {
        for(Robot r : robots) {
            if(!r.done) return false;
        }
        return true;
    }
    
    void move(int[][] map, Robot[] robots) {
        for(int i = 0; i < robots.length; i++) {
            if(robots[i].done) continue;
            
            int[] done = robots[i].isDone();
            
            if(done[0] > 0) {
                map[robots[i].r][robots[i].c]--;
                robots[i].r++;
                map[robots[i].r][robots[i].c]++;
            } else if(done[0] < 0) {
                map[robots[i].r][robots[i].c]--;
                robots[i].r--;
                map[robots[i].r][robots[i].c]++;
            } else {
                if(done[1] > 0) {
                    map[robots[i].r][robots[i].c]--;
                    robots[i].c++;
                    map[robots[i].r][robots[i].c]++;
                } else if(done[1] < 0) {
                    map[robots[i].r][robots[i].c]--;
                    robots[i].c--;
                    map[robots[i].r][robots[i].c]++;
                } else {
                    robots[i].idx++;
                    if(robots[i].complete()) {
                        map[robots[i].r][robots[i].c]--;
                    } else {
                        i--;
                    }
                }
            }
        }
    }
    
    class Robot{
        int r, c, idx;
        ArrayList<int[]> list;
        boolean done;
        
        Robot(int r, int c) {
            this.r = r; this.c = c; this.idx = 0;
            list = new ArrayList<>();
            this.done = false;
        }
        
        int[] isDone() {
            int[] done = {list.get(idx)[0] - r, list.get(idx)[1] - c};
            return done;
        }
        
        boolean complete() {
            if(idx == list.size()) this.done = true;
            return this.done;
        }
    }
}