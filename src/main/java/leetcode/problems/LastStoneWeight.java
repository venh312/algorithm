/**
 You are given an array of integers stones where stones[i] is the weight of the ith stone.

 We are playing a game with the stones.
 On each turn, we choose the heaviest two stones
 and smash them together. Suppose the heaviest two stones
 have weights x and y with x <= y. The result of this smash is:
 우리는 돌을 가지고 게임을 하고 있다.
 각 턴에서 가장 무거운 두 개의 돌을 선택하여 함께 격파합니다.
 가장 무거운 두 돌이 x <= y인 무게 x와 y를 갖는다고 가정하자. 이 스매시의 결과는 다음과 같다:

 If x == y, both stones are destroyed, and
 If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
 At the end of the game, there is at most one stone left.

 Return the weight of the last remaining stone. If there are no stones left, return 0.

 만약 x == y이면, 두 돌은 모두 파괴되고
 만약 x != y이면 무게 x의 돌은 파괴되고, 무게 y의 돌은 새로운 무게 y - x를 갖는다.
 경기 막판에는 많아야 한 개의 돌이 남아 있다.
 마지막 남은 돌의 무게를 돌려주세요. 돌이 남아있지 않으면 0번으로 돌려주세요.

 Example 1:
 Input: stones = [2,7,4,1,8,1]
 Output: 1
 Explanation:
 We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
 we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
 we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
 we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of the last stone.

 Example 2:
 Input: stones = [1]
 Output: 1
*/
class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
      if  (stones.length == 1) return stones[0];
      Arrays.sort(stones);
      int n = stones.length-1;
      int loop = stones.length-1;
      while  (loop > -1) {
          int x = stones[n];
          int y = stones[n-1];
          if (x != 0 && y != 0) {
              if (x == y) {
                  stones[n] = 0;
                  stones[n-1] = 0;
              } else {
                  stones[n] = 0;
                  stones[n-1] = Math.abs(x-y);
              }
          }
          Arrays.sort(stones);
          loop--;
      }
  
      return stones[stones.length-1];
  }
  
  public int lastStoneWeight2(int[] stones) {
     // 내림차순으로 돌을 정렬하기 위해 역순 Comparator를 사용
      PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
      
      // 모든 돌을 큐에 추가
      for (int stone : stones) {
          maxHeap.add(stone);
      }
      
      // 돌이 두 개 이상 남아있을 때까지 반복
      while (maxHeap.size() > 1) {
          // 가장 무거운 두 돌을 추출
          int y = maxHeap.poll(); // 가장 무거운 돌
          int x = maxHeap.poll(); // 두 번째로 무거운 돌
      
          // 두 돌을 충돌시킴
          if (x != y) {
              maxHeap.add(y - x); // 충돌 결과를 큐에 추가
          }
          // x == y일 때는 둘 다 파괴되므로 아무것도 추가하지 않음
      }
      
      // 큐에 남아 있는 마지막 돌의 무게를 반환, 큐가 비어있다면 0 반환
      return maxHeap.isEmpty() ? 0 : maxHeap.poll();
  }
}
