import java.util.*;

class Solution {
    public int solution(int[] order) {
        int maxBoxCnt = order.length;
        int nowOrderIndex = 0;
        int answer = 0;
        Stack<Integer> support = new Stack<>();
        for (int i = 0; i < maxBoxCnt && nowOrderIndex < order.length; i++) {
            int nowBoxNumber = i+1;
            int nowOrder = order[nowOrderIndex];
            if (nowBoxNumber == nowOrder) {
                answer++;
                nowOrderIndex++;
            } else {
                support.push(i+1);
            }
            while (!support.isEmpty() && nowOrderIndex < order.length && support.peek() == order[nowOrderIndex]) {
                    answer++;
                    nowOrderIndex++;
                    support.pop();
                }
        }
        while (!support.isEmpty() && nowOrderIndex < order.length && support.peek() == order[nowOrderIndex])         {
            answer++;
            nowOrderIndex++;
            support.pop();
        }
        return answer;
    }
}