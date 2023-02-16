package greedy.gold.Q1700;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, K, ans;
    private static int[] arr;
    private static boolean[] used;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 멀티탭 구멍의 수
        K = Integer.parseInt(st.nextToken()); // 전기용품 사용횟수

        used = new boolean[K + 1];
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int idx = 0, cnt = 0;
        while (true) {
            if (cnt == N) break;
            if (!used[arr[idx]]) {
                used[arr[idx]] = true;
                cnt++;
            }
            idx++;
        }

        while (idx < K) {
            // 지금 사용할 전기용품의 콘센트가 멀티탭에 꽃혀있지 않은 경우
            if (!used[arr[idx]]) {
                List<Integer> list = new ArrayList<>();
                for (int i = idx; i < K; i++) {
                    if (used[arr[i]] && !list.contains(arr[i])) {
                        list.add(arr[i]);
                    }
                }

                // list 사이즈가 N이라는 얘기는 지금 멀티탭에 꽃혀있는 콘센트 모두가 다음에 또
                // 다시 사용된다는 의미이다. 이때는 그나마 가장 늦게 다시 사용될 콘센트를 뽑는다.
                if (list.size() == N) {
                    int remove = list.get(list.size() - 1);
                    used[remove] = false;
                } else {
                    for (int j = 1; j <= K; j++) {
                        if (used[j] && !list.contains(j)) {
                            used[j] = false;
                            break;
                        }
                    }
                }

                used[arr[idx]] = true;
                ans++;
            }

            idx++;
        }

        System.out.println(ans);
    }
}