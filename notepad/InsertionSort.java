public class InsertionSort {

    public void asc(int[] arr) {
        int count = 0;
        // 두 번째 값(++)부터 시작해서 앞에 있는 값과 비교
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                count++;
                if (arr[j] > arr[i]) {
                    int tmp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = tmp;
                }
            }
        }
        System.out.println("=> 1 count : " + count);
    }

    public void asc2(int[] arr) {
        int count = 0;
        // 두 번째 값(++)부터 시작해서 앞에 있는 값과 비교
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i-1;
            while (j >= 0 && arr[j] > key) {
                count++;
                arr[j+1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        System.out.println("=> 2 count : " + count);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10,8,6,20,4,3,22,1,0,15,16};
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.asc2(arr);
        System.out.println(Arrays.toString(arr));
    }
}
