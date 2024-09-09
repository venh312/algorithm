public class BubbleSort {
    public void asc(int[] arr) {
        int count = 0;
        // 앞,뒤로 비교 후 더 큰 값을 뒤로 보내서 (반복) 큰 값을 뒤에서부터 채워 넣는다.
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length-i; j++) {
                count++;
                if (arr[j-1] > arr[j]) {
                    int tmp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = tmp;
                }
            }
        }
        System.out.println("=> count : " + count);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10,8,6,20,4,3,22,1,0,15,16};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.asc(arr);
        System.out.println(Arrays.toString(arr));
    }
}
