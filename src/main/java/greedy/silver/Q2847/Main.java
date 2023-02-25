package greedy.silver.Q2847;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int max = arr[n-1];
        int cnt = 0;

        for (int i = n-2; i >= 0; i--) {
            int val = arr[i];
            if (val >= max) {
                int tmp = val - (max-1);
                cnt += tmp;
                max = max-1;
            } else {
                max = val;
            }
        }

        System.out.println(cnt);
    }
}
