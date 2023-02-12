package greedy.Q5585;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 1000 - sc.nextInt();
        int[] change_money = {500, 100, 50, 10, 5, 1};
        int cnt = 0;
        int rest = 0;

        for (int m : change_money) {
            if (m > n) continue;
            cnt += n / m;
            n = n % m;
        }

        System.out.println(cnt);
    }
}
