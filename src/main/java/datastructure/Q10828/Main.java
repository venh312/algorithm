package datastructure.Q10828;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push": stack.push(Integer.valueOf(st.nextToken())); break;
                case "pop": bw.write((stack.empty() ? -1 : stack.pop()) + "\n"); break;
                case "size": bw.write(stack.size() + "\n"); break;
                case "empty": bw.write((stack.empty() ? 1 : 0) + "\n"); break;
                case "top": bw.write((stack.empty() ? -1 : stack.peek()) + "\n"); break;
                default: break;
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
