package graph.gold.Q10026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    static String[][] arr;
    static boolean[][] visited;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new String[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++)
            arr[i] = br.readLine().split("");

        int normal_cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++){
                if (!visited[i][j]) {
                    dfs(i,j);
                    normal_cnt++;
                }
            }
        }

        arr = Arrays.stream(arr).map(arr -> Arrays.stream(arr)
                .map(s -> s.replace("G", "R")).toArray(String[]::new)).toArray(String[][]::new);

        visited = new boolean[n][n];

        int rg_cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    dfs(i,j);
                    rg_cnt++;
                }
            }
        }

        System.out.println(normal_cnt + " " + rg_cnt);
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;
        String tmp = arr[x][y];
        for (int i = 0; i < 4; i++) {
            int new_x = x + dir[i][1];
            int new_y = y + dir[i][0];

            if (new_x < 0 || new_y < 0 || new_x >= n || new_y >= n)
                continue;

            if (!visited[new_x][new_y] && arr[new_x][new_y].equals(tmp))
                dfs(new_x, new_y);
        }
    }
}
