package greedy.gold.Q14908;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        List<Work> works = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            works.add(new Work(i, t, s));
        }
        Collections.sort(works);
        StringBuilder sb = new StringBuilder();
        for (Work work : works) {
            sb.append(work.n).append(" ");
        }
        System.out.println(sb);
    }
}

class Work implements Comparable<Work> {

    public int n;
    public int t;
    public int s;

    public Work(int n, int t, int s) {
        this.n = n;
        this.t = t;
        this.s = s;
    }

    @Override
    public int compareTo(Work o) {
        double div1 = (double) t / (double) s;
        double div2 = (double) o.t / (double) o.s;
        if (div1 == div2) {
            return n - o.n;
        }
        return Double.compare(div1, div2);
    }
}
