package greedy.gold.Q11000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (o1, o2) -> {
            if (o1[0] > o2[0])
                return 1;
            else if (o1[0] == o2[0])
                return o1[1] - o2[1];
            return -1;
        });

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(arr[0][1]);
        for (int i = 1; i < n; i++) {
            if (queue.peek() <= arr[i][0])
                queue.poll();
            queue.add(arr[i][1]);
        }
        System.out.println(queue.size());
    }
}
