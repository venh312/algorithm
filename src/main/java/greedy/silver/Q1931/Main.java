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

        Arrays.sort(arr, (o1, o2) -> {
            if(o1[1] == o2[1]) // 종료시간이 같을 경우 시작 시간이 빠른 순
                return o1[0] - o2[0];
            return o1[1] - o2[1];
        });

        int cnt = 0;
        int end = 0;
        for (int i = 0; i < n; i++) {
            if(end <= arr[i][0]) {
                end = arr[i][1];
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
