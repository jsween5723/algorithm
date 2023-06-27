import java.util.*;
class Solution {
    static boolean[] visit = new boolean[8];
    static char[] targets = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    static Map<Character, Integer> map = new HashMap<>();
    static String[] data;
    static int c = 5;
    public int solution(int n, String[] data) {
        Solution.data = data;
        return back(0);
    }
    
    private int back(int cnt) {
        if(cnt == 8) {
            var result = false;
            if(result = check()) {
                return 1;
            }
        }
        int sum = 0;
        for(int i = 0; i < 8; i++) {
            if(visit[i]) continue;
            visit[i] = true;
            map.put(targets[i], cnt);
            sum += back(cnt+1);
            visit[i] = false;
        }
        return sum;
    }
    private boolean check() {
        var list = Arrays.asList(map);
        for(var d: data) {
            var target1 = map.get(d.charAt(0));
            var target2 = map.get(d.charAt(2));
            var condition = d.charAt(3);
            var amount = d.charAt(4)-'0'+1;
            switch(condition) {
                case '<':
                    if( !(Math.abs(target1-target2) < amount) ) {
                        return false;
                    }
                    break;
                case '>':
                    if( !(Math.abs(target1-target2) > amount) ) {
                        
                        return false;
                    }
                    break;
                case '=':
                    if( !(Math.abs(target1-target2) == amount)) {
                        return false;
                    }
                    
            }
        }
        return true;
    }
}