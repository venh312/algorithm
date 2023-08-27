import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char character = scanner.next().charAt(0);
        int asciiValue = (int) character;
        System.out.println(asciiValue);
        scanner.close();
    }
}
