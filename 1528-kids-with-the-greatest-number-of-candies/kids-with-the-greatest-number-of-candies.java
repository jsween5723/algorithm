class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        //max 순회 max값 찾기
        Boolean[] answer = new Boolean[candies.length];
        int max = -1;
        for(var candy: candies) {
            if(max < candy) max = candy;
        }
        for(int i = 0; i < candies.length; i++) {
            answer[i] = (candies[i] + extraCandies) >= max;
        }
        return Arrays.asList(answer);
    }
}