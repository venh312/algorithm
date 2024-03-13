### 퀵 정렬(Quick Sort)
분할 정복(Divide and Conquer) 방법을 사용하여 정렬하는 알고리즘 중 하나입니다. 퀵 정렬은 다음과 같은 단계로 수행됩니다.

1. 분할(Divide): 배열에서 하나의 요소를 피벗(pivot)으로 선택합니다. 나머지 요소들을 피벗을 기준으로 작은 값은 왼쪽으로, 큰 값은 오른쪽으로 분할합니다.
2. 정복(Conquer): 분할된 부분 배열에 대해 재귀적으로 퀵 정렬을 수행합니다.
3. 결합(Combine): 아무 작업도 필요하지 않습니다. 배열은 이미 정렬되어 있습니다.
 
퀵 정렬의 평균 시간 복잡도는 O(nlogn)이지만, 최악의 경우 시간 복잡도는 O(n^2)입니다.
최악의 경우는 대부분 피벗 선택이 제대로 이루어지지 않았을 때 발생합니다. 하지만 무작위로 피벗을 선택하거나 중앙값을 선택하는 방법 등으로 최악의 경우를 피할 수 있습니다.

```java
public class QuickSort {
    public void quickSort(int arr[], int low, int high) {
        if (low < high) {
            // pi는 파티션의 분할 지점
            int pi = partition(arr, low, high);

            // 분할된 두 부분 배열에 대해 재귀적으로 퀵 정렬 수행
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    int partition(int arr[], int low, int high) {
        // 피벗을 배열의 마지막 요소로 선택
        int pivot = arr[high];
        int i = (low - 1); // 피벗보다 작은 요소들의 마지막 인덱스

        for (int j = low; j < high; j++) {
            // 현재 요소가 피벗보다 작으면 작은 요소들을 swap
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // 피벗과 i+1 위치의 요소 교환 (피벗의 최종 위치 설정)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1; // 파티션의 분할 지점을 반환
    }

    // 배열 출력
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // 테스트
    public static void main(String args[]) {
        int arr[] = {10, 7, 8, 9, 1, 5};
        int n = arr.length;

        QuickSort ob = new QuickSort();
        ob.quickSort(arr, 0, n - 1);

        System.out.println("Sorted array");
        printArray(arr);
    }
}
```
