package Implementation.silver.Q17413;

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        Stack<Character> stack = new Stack<>();
        boolean flag = false;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '<') {
                flag = true;
                while (!stack.isEmpty())
                    bw.write(stack.pop());
                bw.write(input.charAt(i));
            } else if (input.charAt(i) == '>') {
                flag = false;
                bw.write(input.charAt(i));
            } else if (flag) {
                bw.write(input.charAt(i));
            } else {
                if (input.charAt(i) == ' ') {
                    while (!stack.isEmpty())
                        bw.write(stack.pop());
                    bw.write(" ");
                } else {
                    stack.push(input.charAt(i));
                }
            }
        }
        while (!stack.isEmpty())
            bw.write(stack.pop());
        bw.flush();
        br.close();
        bw.close();
    }
}
