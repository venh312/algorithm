import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int[][] friendGiftCountArr = new int[friends.length][friends.length];
        
        Map<String, Integer> friendIndexMap = new HashMap<>();
        
        for (int i = 0; i < friends.length; i++) {
            friendIndexMap.put(friends[i], i);
            friendGiftCountArr[i][i] = -1; // 자기 자신에게는 선물을 못하니 -1로 초기화
        }
        
        for (String gift : gifts) {
            String[] history = gift.split(" ");
            String from = history[0];
            String to = history[1];
            int x = friendIndexMap.get(from);
            int y = friendIndexMap.get(to);
            friendGiftCountArr[x][y]++;
        }
        
        Map<String, Integer> giftExpMap = new HashMap<>();
        
        for (int i = 0; i < friendGiftCountArr.length; i++) {
            int totalSendCount = 0;
            int totalReceiveCount = 0;
            for (int j = 0; j < friendGiftCountArr.length; j++) {
                if (i == j) continue; // 자기 자신은 PASS
              
                int sendCount = friendGiftCountArr[i][j];
                if (sendCount > -1) {
                    totalSendCount += sendCount;
                }
                
                int receiveCount = friendGiftCountArr[j][i];
                if (receiveCount > -1) {
                    totalReceiveCount += receiveCount;
                }
            }
            giftExpMap.put(friends[i], totalSendCount - totalReceiveCount);
        }
        
        int[] nextGiftCount = new int[friends.length];
        for (int i = 0; i < friendGiftCountArr.length; i++) {
            int result = 0;
            for (int j = 0; j < friendGiftCountArr.length; j++) {
                if (i == j) continue; // 자기 자신은 PASS
              
                // 내가 준 선물이 더 많으면 ++
                if (friendGiftCountArr[i][j] > friendGiftCountArr[j][i]) {
                    result++;
                } else if (friendGiftCountArr[i][j] == friendGiftCountArr[j][i]) {
                    if (giftExpMap.get(friends[i]) > giftExpMap.get(friends[j])) {
                        result++;
                    }
                }
            }
            
            answer = Math.max(answer, result);
        }
        
        return answer;
    }
}
