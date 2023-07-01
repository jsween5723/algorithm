class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        var del = 0;
        var p = 0;
        for(int i = deliveries.length-1; i >= 0; i--) {
            if(deliveries[i] <= 0 && pickups[i] <= 0) {
                continue;
            }
            del += deliveries[i];
            p += pickups[i];
            while(del > 0 || p > 0) {
                del -= cap;
                p -= cap;
                answer += (i+1) * 2;
            }
        }
        return answer;
    }
}