package greedy.gold.Q13164;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int answer = 0;
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < n; i++)
            list.add(arr[i] - arr[i - 1]);
        Collections.sort(list);
        for (int i = 0; i < n - k; i++)
            answer += list.get(i);
        System.out.println(answer);
    }
}
