class Solution {
    public int[] solution(String[] park, String[] routes) {
        int x = -1, y = -1;
        for(int i = 0; i < park.length; i++) {
            for(int j = 0; j < park[0].length(); j++){
                if(park[i].charAt(j) == 'S') {
                    x = j;
                    y = i;
                    break;
                }
            }
            if(x != -1) break;
        }
        for(var r: routes) {
            var rs = r.split(" ");
            var dir = Direction.valueOf(rs[0]);
            var check = true;
            int ox = x, oy = y;
            for(int i = Integer.valueOf(rs[1]); i > 0; i--) {
                if(ox+dir.x >= park[0].length() 
                || ox+dir.x < 0
                || oy+dir.y >= park.length
                || oy+dir.y < 0
                  ||park[oy+dir.y].charAt(ox+dir.x)=='X') {
                    check = false;
                    break;
                }
                ox+=dir.x;
                oy+=dir.y;
            }
            if(check) {
                x = ox;
                y = oy;
            }
            System.out.println(y+" "+x);
        }
        
        int[] answer = {y,x};
        return answer;
    }
    enum Direction{
        E(1, 0),
        W(-1,0),
        N(0,-1),
        S(0,1);
        public final int x;
        public final int y;
        Direction(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}