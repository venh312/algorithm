package greedy.bronze.Q2720;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] chg_money = {25, 10, 5, 1};
        int[][] answer = new int[T][4];

        for (int i = 0; i < T; i++) {
            int C = sc.nextInt();
            for (int j = 0; j < chg_money.length; j++) {
                answer[i][j] = C / chg_money[j];
                C = C % chg_money[j];
            }
        }

        for (int i = 0; i < answer.length; i++) {
            for (int j = 0 ; j < 4; j++)
                System.out.print(answer[i][j] + " ");
            System.out.println();
        }
    }
}
