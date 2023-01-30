package greedy.silver.Q11399;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        /*
        5
        3 1 4 3 2
        */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int result = 0;
        Arrays.sort(arr);

        Stack<Integer> stack = new Stack<>();
        for (int a : arr) {
            Integer num = a;
            if (!stack.isEmpty())
                num += stack.peek();
            stack.add(num);
        }

        for (int s :  stack)
            result += s;

        System.out.println(result);
    }
}
