package etc.Q9498;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String answer = "";
        if (n >= 90) {
            answer = "A";
        } else if (n >= 80) {
            answer = "B";
        } else if (n >= 70) {
            answer = "C";
        } else if (n >= 60) {
            answer = "D";
        } else {
            answer = "F";
        }
        System.out.println(answer);
    }
}
