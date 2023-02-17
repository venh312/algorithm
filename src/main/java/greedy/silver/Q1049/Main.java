package greedy.silver.Q1049;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M =sc.nextInt();
        int answer = Integer.MAX_VALUE;

        int[] unit = new int[M];
        int[] pack = new int[M];

        for (int i = 0; i < M; i++) {
            pack[i] = sc.nextInt();
            unit[i] = sc.nextInt();
        }

        Arrays.sort(unit);
        Arrays.sort(pack);

        // 가장 싼 6개짜리 팩 구매 vs 가장 싼 낱개 구매 vs (가장싼 6개짜리 팩 + 낱개)
        answer = Math.min(((N/6)+1)*pack[0], N*unit[0]);
        answer = Math.min(answer, ((N/6))*pack[0] + (N%6)*unit[0]);

        System.out.println(answer);
    }
}
