import java.util.*;
class Solution {
    public int[] solution(String[] grid) {
        var q = new PriorityQueue<Integer>((x, y) -> x-y);
        boolean[][][] check = new boolean[grid.length][grid[0].length()][4];
        int max = grid.length * grid[0].length() * 4;
        int cnt = 0;
        for(int y = 0; y < grid.length; y++) {
            for(int x = 0; x<grid[0].length();x++) {
                for(int d = 0; d < 4; d++) { //LURD
                    if(check[y][x][d]) continue;
                    var res = checkCycle(check, grid, x, y, d);
                    if(res == null) continue;
                    q.add(res);
                }
            }
        }
        int[] answer = new int[q.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = q.poll();
        }
        return answer;
    }
    
    private Integer checkCycle(boolean[][][] check, String[] grid, int x, int y, int dir) {
        int tx = x, ty = y, cnt = 0;
        int tdir = dir;
        while(check[ty][tx][tdir] == false) {
            check[ty][tx][tdir] = true;
            cnt++;
            var panel =  grid[ty].charAt(tx);
            var moves = move(tdir, panel);
            tx+=moves[1];
            ty+=moves[0];
            switch(panel) {
                case 'L':
                    tdir++;
                    if(tdir > 3) tdir = 0;
                    break;
                case 'R':
                    tdir--;
                    if(tdir < 0) tdir = 3;
                    break;
                case 'S':   
            }
            if(tx > grid[0].length()-1) tx = 0;
            if(tx < 0) tx = grid[0].length()-1;;
            if(ty > grid.length-1) ty = 0;
            if(ty < 0) ty = grid.length-1;
        }
        if(tx == x && ty == y && dir == tdir) {
            
            return cnt;
        }
        return null;
    }
    private int[] move(int dir, char panel) {
        switch(dir){
            case 0: 
                switch(panel) {
                    case 'L':
                        return new int[]{0,1};
                    case 'R':
                        return new int[]{0,-1};
                    case 'S':
                        return new int[]{1,0};
                }
            case 1: 
                switch(panel) {
                    case 'L':
                        return new int[]{-1,0};
                    case 'R':
                        return new int[]{1,0};
                    case 'S':
                        return new int[]{0,1};
                }
            case 2: 
                switch(panel) {
                    case 'L':
                        return new int[]{0,-1};
                    case 'R':
                        return new int[]{0,1};
                    case 'S':
                        return new int[]{-1,0};
                }
            case 3: 
                switch(panel) {
                    case 'L':
                        return new int[]{1,0};
                    case 'R':
                        return new int[]{-1,0};
                    case 'S':
                        return new int[]{0,-1};
                }
        }
        return null;
    }
}