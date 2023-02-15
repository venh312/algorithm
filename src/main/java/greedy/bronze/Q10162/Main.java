package greedy.bronze.Q10162;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = 300;
        int B = 60;
        int C = 10;
        int T = sc.nextInt();
        int aCnt = 0;
        int bCnt = 0;
        int cCnt = 0;
        if (T >= 300) {
            aCnt += (T / A);
            T = T % A;
        }
        if (T >= 60) {
            bCnt += (T / B);
            T = T % B;
        }
        if (T >= 10) {
            cCnt += (T / C);
            T = T % C;
        }
        if (T == 0) {
            System.out.println(aCnt + " " + bCnt + " " + cCnt);
        } else {
            System.out.println(-1);
        }
    }
}
