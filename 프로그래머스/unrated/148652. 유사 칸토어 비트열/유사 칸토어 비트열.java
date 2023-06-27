class Solution {
    static int[] targets;
    public int solution(int n, long l, long r) {
        long size = 1;
        for(int i = 1; i < n; i++) {
            size *= 5;
        }
        return (int)dac(r, size) - (int)dac(l-1,size);
    }
    private long dac(long l, long size) {
        if (l > size*5) {
            l = size*5;
        }
        if (size == 1) {
            if(l >= 3) return l-1;
            return l;
        }
        long sum = 0;
        sum += dac(l, size/5);
        if(l > size) {
            sum += dac(l-size, size/5);
        }
        if(l > size*3) {
            sum += dac(l-size*3, size/5);
        }
        if(l > size*4) {
            sum += dac(l-size*4, size/5);
        }
        return sum;
    }
}