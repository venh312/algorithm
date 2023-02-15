package greedy.silver.Q16953;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);
        long A = scann.nextLong();
        long B = scann.nextLong();

        Queue<Long> que = new LinkedList<>();
        que.add(A*2);
        que.add(A*10+1);

        int answer = 0;
        while (!que.isEmpty()) {
            answer++;
            int size = que.size();
            for (int i = 0; i < size; i++) {
                long now = que.poll();
                if (now > B) continue;
                if (now == B) {
                    System.out.println(answer+1);
                    return;
                }
                que.add(now*2);
                que.add(now*10+1);
            }
        }
        System.out.println(-1);
    }
}
