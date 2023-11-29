package etc.Q1920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] nArr, mArr;
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        nArr = new int[N];
//        for (int i = 0; i < N; i++)
//            nArr[i] = Integer.parseInt(st.nextToken());
//
//        int M = Integer.parseInt(br.readLine());
//        st = new StringTokenizer(br.readLine());
//        mArr = new int[N];
//        for (int i = 0; i < N; i++)
//            mArr[i] = Integer.parseInt(st.nextToken());

        nArr = new int[]{1,2,3,4,5,6,7};
        binarySearch(nArr.length/2, 5);
    }

    private static int binarySearch(int pivot, int target) {
        return 0;
    }

}
