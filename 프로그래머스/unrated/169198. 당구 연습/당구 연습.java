import java.util.*;
class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        for(int i = 0; i < balls.length; i++) {
            var ball = balls[i];
            var x = ball[0] - startX;
            var y = ball[1] - startY;
            var pq = new PriorityQueue<Integer>();
            if(x != 0 || y < 0) {
                //위
                var my = (n*2-ball[1]) - startY;
                pq.add(x*x + my*my);
            }
            if(x != 0 || y > 0) {
                //아래
                var my = -ball[1] - startY;
                pq.add(x*x + my*my);
            }
            if(y != 0 || x < 0) {
                //오른
                var mx = (m*2-ball[0]) - startX;
                pq.add(mx*mx + y*y);
            }
            if(y != 0 || x > 0) {
                //왼쪽
                var mx = -ball[0] - startX;
                pq.add(mx*mx + y*y);
            }
            answer[i] = pq.poll();
        }
        return answer;
    }
    
}