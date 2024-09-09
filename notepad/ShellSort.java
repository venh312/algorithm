public class ShellSort {
    private int count = 0;
    private void asc(int[] arr) {

        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            if (gap % 2 == 0) gap++;
            System.out.println("gap : " + gap);

            for (int i = 0; i < gap; i++) {
                insertionSort(arr, i, arr.length-1, gap);
            }
        }

        System.out.println("=> count : " + count);
    }

    public void insertionSort(int[] arr, int first, int last, int gap) {
        int i, j, key;
        for (i = first+gap; i <= last; i+=gap) {
            key = arr[i];
            for (j = i-gap; j >= first && arr[j] > key; j-=gap) {
                count++;
                arr[j+gap] = arr[j];
            }
            arr[j+gap] = key;
        }
    }


    // [3, 8, 1, 0, 4, 10, 22, 6, 20, 15, 16]
    public static void main(String[] args) {
        int[] arr = new int[]{10,8,6,20,4,3,22,1,0,15,16};
        ShellSort shellSort = new ShellSort();
        shellSort.asc(arr);
        System.out.println(Arrays.toString(arr));
    }

}
