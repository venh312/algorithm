class SortColors {
  public void heapSort(int[] arr) {
      int n = arr.length;
      for (int i = n / 2 - 1; i >= 0; i--) heapify(arr, i, n);
      for (int i = n - 1; i > 0; i--) {
          swap(arr, 0, i);
          heapify(arr, 0, i);
      }
  }

  private void swap(int[] arr, int a, int b) {
      int tmp = arr[a];
      arr[a] = arr[b];
      arr[b] = tmp;
  }

  private void heapify(int[] arr, int root, int n) {
      int largest = root;
      int left = root * 2 + 1;
      int right = root * 2 + 2;

      if (left < n && arr[largest] < arr[left]) largest = left;
      if (right < n && arr[largest] < arr[right]) largest = right;

      if (largest != root) {
          swap(arr, root, largest);
          heapify(arr, largest, n);
      }
  }

  public void sortColors(int[] nums) {
      heapSort(nums);
  }

  /*
  정렬함수 정의 없이, 값이 3개 이기 때문에
  정렬 함수(예: 퀵소트, 병합정렬 등)를 사용하는 경우 평균적으로 O(n log n)의 시간 복잡도를 가지므로, 주어진 문제의 특정 조건을 고려했을 때 더 효율적이지 않습니다. 이 문제는 세 가지 색상만을 다루기 때문에 "두 포인터" 또는 "세 파티션" 접근법을 사용하여 O(n)의 시간 복잡도로 해결할 수 있습니다.
  
  주어진 문제에서 각 색상(0, 1, 2) 간의 상대적인 순서를 유지하며 정렬해야 하므로, 다음과 같은 두 포인터 방법이 가장 효율적입니다:
  
  시간 복잡도: O(n) — 배열을 한 번만 순회합니다.
  공간 복잡도: O(1) — 추가적인 공간을 사용하지 않습니다.
  정렬 함수를 사용하여 정렬할 경우, 불필요하게 더 많은 비교와 교환을 하게 되어 비효율적입니다. 따라서 두 포인터 접근법이 가장 적합한 해결책입니다.
  */
  public void sortColors2(int[] nums) {
        int zeroIndex = 0; // 빨간색의 위치
        int twoIndex = nums.length - 1; // 파란색의 위치
        int i = 0; // 현재 인덱스

        while (i <= twoIndex) {
            if (nums[i] == 0) {
                // 0인 경우, 현재 인덱스의 값과 zeroIndex의 값을 교환
                swap(nums, i, zeroIndex);
                zeroIndex++;
                i++;
            } else if (nums[i] == 2) {
                // 2인 경우, 현재 인덱스의 값과 twoIndex의 값을 교환
                swap(nums, i, twoIndex);
                twoIndex--;
            } else {
                // 1인 경우, 인덱스만 증가
                i++;
            }
        }
    }
}
