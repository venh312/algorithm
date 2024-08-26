/**
 * Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.
 * <p>
 * Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.
 * Elements that do not appear in arr2 should be placed at the end of arr1 in ascending order.
 * <p>
 * <p>
 * Example 1:
 * Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * Output: [2,2,2,1,4,3,3,9,6,7,19]
 * <p>
 * Example 2:
 * Input: arr1 = [28,6,22,8,44,17], arr2 = [22,28,8,6]
 * Output: [22,28,8,6,17,44]
 */
class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
       Map<Integer, Integer> elements = new HashMap<>();
        int[] result = new int[arr1.length];

        for (int i : arr1)
            elements.put(i, elements.getOrDefault(i, 0)+1);

        int arrIndex = 0, currIndex = 0;
        while (currIndex < arr2.length) {
            int key = arr2[currIndex];
            if (elements.containsKey(key)) {
                int element = elements.get(key);
                if (element > 0) {
                    result[arrIndex++] = key;
                    elements.put(key, element - 1);
                } else {
                    elements.remove(key);
                }
            } else {
                currIndex++;
            }
        }

        List<Integer> tail = new ArrayList<>();


        for (Integer key : elements.keySet()) {
            int value = elements.get(key);
            if (value > 0) {
                for (int i = 0; i < value; i++) {
                    tail.add(key);
                }
            }
        }

        tail.sort(Integer::compareTo);

        for (Integer i : tail) {
            result[arrIndex++] = i;
        }

        return result;
    }
}
