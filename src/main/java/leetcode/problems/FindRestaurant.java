package leetcode.problems;

/*
Given two arrays of strings list1 and list2, find the common strings with the least index sum.
A common string is a string that appeared in both list1 and list2.
A common string with the least index sum is a common string such that if it appeared at list1[i] and list2[j] then i + j should be the minimum value among all the other common strings.
Return all the common strings with the least index sum. Return the answer in any order.

Example 1:
Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"], list2 = ["Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"]
Output: ["Shogun"]
Explanation: The only common string is "Shogun".

Example 2:
Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"], list2 = ["KFC","Shogun","Burger King"]
Output: ["Shogun"]
Explanation: The common string with the least index sum is "Shogun" with index sum = (0 + 1) = 1.

Example 3:
Input: list1 = ["happy","sad","good"], list2 = ["sad","happy","good"]
Output: ["sad","happy"]
Explanation: There are three common strings:
"happy" with index sum = (0 + 1) = 1.
"sad" with index sum = (1 + 0) = 1.
"good" with index sum = (2 + 2) = 4.
The strings with the least index sum are "sad" and "happy".
*/
class FindRestaurant {
    // Runtime: 34 ms, faster than 45.04%
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<Integer, Integer> wordIndexMap = new HashMap<>();
        Map<String, Integer> firstMap = new HashMap<>();
        Map<String, Integer> twoMap = new HashMap<>();

        for (int i = 0; i < list1.length; i++)
            firstMap.put(list1[i], i);

        for (int i = 0; i < list2.length; i++)
            twoMap.put(list2[i], i);

        Map<Integer, String> resultMap = new HashMap<>();
        int minIndex = Integer.MAX_VALUE;
        for (int i = 0; i < list1.length; i++) {
            String word = list1[i];
            if (firstMap.containsKey(word) && twoMap.containsKey(word)) {
                int firstIndex = firstMap.get(word);
                int twoIndex = twoMap.get(word);
                int sumIndex = firstIndex + twoIndex;
                minIndex = Math.min(minIndex, sumIndex);
                resultMap.put(sumIndex, resultMap.getOrDefault(sumIndex, "") + word + ",");
            }
        }
        
        return resultMap.get(minIndex).split(",");
    }

    // Runtime: 11 ms, faster than 45.04%
    public String[] findRestaurant2(String[] list1, String[] list2) {
        Map<String, Integer> indexMap = new HashMap<>();
        
        // Fill the HashMap with list1 elements and their indices
        for (int i = 0; i < list1.length; i++) {
            indexMap.put(list1[i], i);
        }
        
        List<String> result = new ArrayList<>();
        int minIndexSum = Integer.MAX_VALUE;
        
        // Iterate through list2 and calculate the index sum for common elements
        for (int j = 0; j < list2.length; j++) {
            if (indexMap.containsKey(list2[j])) {
                int i = indexMap.get(list2[j]);
                int indexSum = i + j;
                
                // If we found a smaller index sum, update the result list
                if (indexSum < minIndexSum) {
                    minIndexSum = indexSum;
                    result.clear();
                    result.add(list2[j]);
                } else if (indexSum == minIndexSum) {
                    result.add(list2[j]);
                }
            }
        }
        
        // Convert the result list to an array and return
        return result.toArray(new String[result.size()]);
    }
}
