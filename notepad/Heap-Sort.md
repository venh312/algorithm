### 힙 정렬(Heap Sort)
힙(heap) 자료구조를 기반으로 하는 정렬 알고리즘 중 하나입니다. 힙은 부모 노드가 자식 노드보다 우선 순위가 높은 완전 이진 트리입니다. 이진 힙은 보통 배열을 사용하여 구현됩니다. 힙 정렬은 다음과 같은 과정을 통해 수행됩니다:

1. 주어진 배열을 최대 힙(Max Heap)으로 만듭니다.
2. 최대 힙에서 최대값(루트)을 뽑아내고 배열의 마지막 요소와 교환합니다.
3. 배열의 크기를 하나 줄이고 최대 힙을 유지합니다.
4. 이 과정을 배열의 모든 요소가 정렬될 때까지 반복합니다.
5. 
힙 정렬의 시간 복잡도는 O(nlogn)입니다.

```java
public class HeapSort {
    public void heapSort(int arr[]) {
        int n = arr.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    void heapify(int arr[], int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // left = 2*i + 1
        int right = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (left < n && arr[left] > arr[largest])
            largest = left;

        // If right child is larger than largest so far
        if (right < n && arr[right] > arr[largest])
            largest = right;

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

    // Print array
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver code
    public static void main(String args[]) {
        int arr[] = {12, 11, 13, 5, 6, 7};
        int n = arr.length;

        HeapSort ob = new HeapSort();
        ob.heapSort(arr);

        System.out.println("Sorted array is");
        printArray(arr);
    }
}
```
