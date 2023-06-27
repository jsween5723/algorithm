class Solution {
    static int[] movex = {-1,1,0,0};
    static int[] movey = {0,0,1,-1};
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        boolean[][] check = new boolean[m][n];
        for(int y = 0; y < m; y++) {
            for(int x = 0; x < n; x++) {
                if(check[y][x] || picture[y][x] == 0) {
                    continue;
                }
                int size = dfs(y,x,m,n,picture,check);
                numberOfArea++;
                maxSizeOfOneArea = size-1 > maxSizeOfOneArea ? size-1 : maxSizeOfOneArea;
            }
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    private int dfs(int y, int x, int m, int n, int[][] picture, boolean[][] check) {
        int size = 1;
        int color = picture[y][x];
        for(int i = 0; i < 4; i++) {
            int tx = x+movex[i];
            int ty = y+movey[i];
            if(tx >= 0 && tx < n
              && ty >= 0 && ty < m
               && picture[ty][tx] == color
               && !check[ty][tx]
              ){
                check[ty][tx] = true;
                size += dfs(ty,tx,m,n,picture,check);
            }
        }
        return size;
    }
}