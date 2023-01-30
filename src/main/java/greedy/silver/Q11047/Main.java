package greedy.silver.Q11047;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        arr = Arrays.stream(arr).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();

        int coin = 0;
        for (int i : arr) {
            if (k == 0) break;
            while (true) {
                if (k >= i) {
                    k -= i;
                    coin++;
                } else
                    break;
            }
        }

        System.out.println(coin);
    }
}
