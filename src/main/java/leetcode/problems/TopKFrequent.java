/*
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

Example 1:
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:
Input: nums = [1], k = 1
Output: [1]
*/
class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        // 1. 각 숫자의 빈도 계산
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        
        // 2. 빈도 순으로 정렬할 수 있는 리스트로 변환
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(freqMap.entrySet());
        
        // 3. 빈도 내림차순으로 정렬
        entryList.sort((a, b) -> b.getValue() - a.getValue());
        
        // 4. 상위 k개 요소 추출
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = entryList.get(i).getKey();
        }
        
        return result;
    }
}
