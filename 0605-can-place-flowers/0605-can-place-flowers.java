

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for(int i = 0; i < flowerbed.length; i++) {
            //flowerbed = 1 cnt countList add, cnt = 0;
            //0 cnt++
            //-1 +1 0 n-=1
            // if (flowerbed[i] == 0) {
            //     if (i == 0) cnt++;
            //     if (i == (flowerbed.length - 1)) cnt++;
            //     cnt++;
            //     continue;
            // }
            // if (flowerbed[i] == 1 || i == flowerbed.length - 1) {
            //     countList.add((cnt-1));
            //     System.out.println(i + " " + countList.toString());
            //     cnt = 0;
            // }
            if(flowerbed[i] == 0 && (i == 0 || flowerbed[i-1] == 0) && (i == flowerbed.length-1 || flowerbed[i+1] == 0)) {
                n--;
                flowerbed[i] = 1;
            }
        }
        return n <= 0;
    }
}