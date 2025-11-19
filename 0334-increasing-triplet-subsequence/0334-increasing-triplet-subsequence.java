class Solution {
    public boolean increasingTriplet(int[] nums) {
        // n^2
        // 1111111
        // 2,1,5,0,4,6
        // 1 1 2 1 2 3
        // j < i
        // j < i && d[j] + 1 > d[i]
        // d[i] = 2;
        // 배열 3 [1 value ,2 value ,3 value]
        int min = Integer.MAX_VALUE;
        int nextMin = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= min) {
                min = nums[i];
            } else if (nums[i] <= nextMin) {
                nextMin = nums[i];
            } else {
                return true;
            }
        }
        return false;
    }
}