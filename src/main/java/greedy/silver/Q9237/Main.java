package greedy.silver.Q9237;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr, Collections.reverseOrder());
        int maxDay = 0;
        for (int i = 0; i < n; i++)
            maxDay = Math.max(maxDay, arr[i] + i + 1);

        maxDay += 1;
        System.out.println(maxDay);
    }
}
