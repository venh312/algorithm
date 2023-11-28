package etc.Q10809;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};

        for (String a : alphabet)
            System.out.print(S.indexOf(a) + " ");
    }

    static void solutionGPT() {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();

        int[] firstOccurrences = new int[26]; // 알파벳의 처음 등장 위치를 저장하는 배열

        // 배열을 -1로 초기화
        for (int i = 0; i < firstOccurrences.length; i++) {
            firstOccurrences[i] = -1;
        }

        // 단어를 순회하면서 알파벳의 처음 등장 위치를 배열에 저장
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';

            if (firstOccurrences[index] == -1) {
                firstOccurrences[index] = i;
            }
        }

        // 결과 출력
        for (int i = 0; i < firstOccurrences.length; i++) {
            System.out.print(firstOccurrences[i] + " ");
        }
    }
}
