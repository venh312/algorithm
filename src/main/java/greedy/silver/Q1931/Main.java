package greedy.silver.Q1931;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] s = sc.nextLine().split(" ");
            arr[i][0] = Integer.parseInt(s[0]);
            arr[i][1] = Integer.parseInt(s[1]);
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]!=o2[0] ? o1[0]-o2[0] : o1[1]-o2[1]; // 첫번째 기준 오름차순 > 두번째 기준 오름차순
            }
        });

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}
