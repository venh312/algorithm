package greedy.gold.Q1715;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> cardQueue = new PriorityQueue<Integer>();
        List<Integer> list = new ArrayList<Integer>();

        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++)
            cardQueue.offer(Integer.parseInt(br.readLine()));

        int sum = Integer.MAX_VALUE;
        if (count == 1)
            sum = 0;
        else {
            while (true) {
                int number1 = cardQueue.poll();
                int number2 = 0;
                if (!cardQueue.isEmpty())
                    number2 = cardQueue.poll();

                list.add(number1+number2);
                if (cardQueue.isEmpty())
                    break;
                cardQueue.offer(number1 + number2);
            }

            sum = list.stream().mapToInt(Integer::intValue).sum();
        }

        bw.write(sum + "\n");
        bw.flush();
        bw.close();
    }
}
