package Implementation.silver.Q10773;

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(br.readLine());
            if (val == 0)
                stack.pop();
            else
                stack.add(val);
        }

        bw.write(stack.stream().mapToInt(Integer::intValue).sum() + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
