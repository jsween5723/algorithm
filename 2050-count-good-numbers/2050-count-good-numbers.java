class Solution {
    static int MODULO = 1000000007;
    public int countGoodNumbers(long n) {
        long cnt = pow(5, (n+1)/2)
        * pow(4, n/2) % MODULO;
        return (int)cnt;
    }

    private long pow(int n, long t) {
        if(t == 0) {
            return 1;
        }
        long temp = pow(n, t/2);
        if ((t % 2) == 1) return (temp*temp*n)%MODULO;
        return (temp * temp) % MODULO;  
    }
}