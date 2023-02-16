package greedy.gold.Q1202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> pQ = new PriorityQueue<int[]>((a,b)->{
            if(a[0]-b[0] == 0)
                return b[1]-a[1];
            return a[0]-b[0];
        });

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            pQ.add(new int[] {M,V});
        }

        List<Integer> bag = new ArrayList<Integer>();
        for (int i = 0; i < K; i++) {
            int C = Integer.parseInt(br.readLine());
            bag.add(C);
        }
        Collections.sort(bag);


        PriorityQueue<Integer> valueQ = new PriorityQueue<Integer>(Collections.reverseOrder());
        long total = 0;
        for (int i = 0; i < bag.size(); i++) {
            int weight = bag.get(i);

            while (!pQ.isEmpty()) {

                if (pQ.peek()[0] <= weight)
                    valueQ.add(pQ.poll()[1]); //가치만 넣는다.
                else
                    break;
            }

            if(valueQ.isEmpty()) continue;
            total += valueQ.poll();
        }
        System.out.println(total);
    }

}
