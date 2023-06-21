import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        var answer = new int[id_list.length];
        var cnt = new int[id_list.length];
        var idMap = new HashMap<String, Integer>();
        for(int i = 0; i < id_list.length; i++) {
            idMap.put(id_list[i], i);
        }
        var reportMap = new HashMap<String, Set<String>>();
        for(var r: report) {
            String[] targets = r.split(" ");
            if(!reportMap.containsKey(targets[0])) 
                reportMap.put(targets[0], new HashSet<>());
            var set = reportMap.get(targets[0]);
            int size = set.size();
            set.add(targets[1]);
            if(set.size() != size) {
                ++cnt[idMap.get(targets[1])];
            }
        }
        for(int i = 0; i < id_list.length; i++) {
            var set = reportMap.get(id_list[i]);
            if(set == null) continue;
            for(var s: set) {
                if(cnt[idMap.get(s)] >= k) {
                    answer[i]++;
                }
            }
        }
        return answer;
        
    }
}