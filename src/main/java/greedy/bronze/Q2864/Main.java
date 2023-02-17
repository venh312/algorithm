package greedy.bronze.Q2864;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String x1 = st.nextToken();
        String x2 = st.nextToken();
        int min = 0;
        int max = 0;

        min = Integer.parseInt(x1.replace("6", "5")) + Integer.parseInt(x2.replace("6", "5"));
        max = Integer.parseInt(x1.replace("5", "6")) + Integer.parseInt(x2.replace("5", "6"));

        System.out.println(min + " " + max);
    }
}
