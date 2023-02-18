package greedy.gold.Q1744;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pos = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> neg = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input > 0) pos.add(input);
            else neg.add(input);
        }

        int tmp = 0;
        int answer = 0;
        while (!pos.isEmpty()) {
            tmp = pos.poll();
            if (!pos.isEmpty()) {
                int next = pos.peek();
                tmp = (tmp * next) > tmp ? tmp * pos.poll() : tmp;
            }
            answer += tmp;
        }
        while (!neg.isEmpty()) {
            tmp = neg.poll();
            if (!neg.isEmpty()) {
                int next = neg.peek();
                tmp = (tmp * next) >= 0 ? tmp * neg.poll() : tmp;
            }
            answer += tmp;
        }
        System.out.print(answer);
    }
}