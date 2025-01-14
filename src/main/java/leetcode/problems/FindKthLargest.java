/*
https://leetcode.com/problems/kth-largest-element-in-an-array/

Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

Can you solve it without sorting?

Example 1:
Input: nums = [3,2,1,5,6,4], k = 2
Output: 5

Example 2:
Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4
*/
class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }


    public int findKthLargestGPT(int[] nums, int k) {
        // 최소 힙 생성
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // 배열의 모든 요소를 최소 힙에 삽입
        for (int num : nums) {
            minHeap.offer(num); // 힙에 삽입
            if (minHeap.size() > k) {
                minHeap.poll(); // 힙 크기가 k를 초과하면 가장 작은 값 제거
            }
        }

        // 힙의 루트가 k번째로 큰 요소
        return minHeap.peek();
    }
}
