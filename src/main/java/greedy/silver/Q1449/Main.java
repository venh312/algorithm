package greedy.silver.Q1449;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(bf.readLine());
        for(int i=0; i<arr.length; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);
        double left = arr[0] - 0.5;
        int answer = 1;
        for (int i = 0; i < N; i++) {
            if (left+L < arr[i]) {
                answer++;
                left = arr[i] - 0.5;
            }
        }
        System.out.println(answer);
    }
}
