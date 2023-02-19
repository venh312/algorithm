package greedy.silver.Q14916;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int money = sc.nextInt();
        int origin = money;
        int answer = 0;
        int[] chg_money = {5,2};

        for (int m : chg_money) {
            if ((origin % 5) % 2 != 0) {
                if (m == 5)
                    money -= 5;
                else
                    money += 5;
            }
            answer += money / m;
            money = money % m;
        }

        if (money > 0)
            System.out.println(-1);
        else
            System.out.println(answer);
    }
}
