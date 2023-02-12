package greedy.silver.Q1026;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        int[] B = new int[n];
        int S = 0;

        for (int i = 0; i < n*2; i++) {
            if (i >= n)
                B[i%n] = sc.nextInt();
            else
                A[i] = sc.nextInt();
        }

        Arrays.sort(A);
        Integer[] arrB = Arrays.stream(B).boxed().toArray(Integer[]::new);
        Arrays.sort(arrB, Collections.reverseOrder());

        for (int i = 0; i < n; i++)
            S += A[i] * arrB[i];

        System.out.println(S);
    }
}
