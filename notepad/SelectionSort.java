public class SelectionSort {

    public void asc(int[] arr) {
        int count = 0;
        // 최소값을 찾아서 앞에서부터 교환
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                count++;
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            int tmp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = tmp;
        }
        System.out.println("=> count : " + count);
    }


    public static void main(String[] args) {
        int[] arr = new int[]{10,8,6,20,4,3,22,1,0,15,16};
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.asc(arr);
        System.out.println(Arrays.toString(arr));
    }
}
