package graph.Q2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] maze;
    static boolean[][] visited;
    static int[][] direction=  {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] curArr = q.poll();
            visited[curArr[0]][curArr[1]] = true;

            for (int i = 0; i < 4; i++) {
                int dx = curArr[0] + direction[i][0];
                int dy = curArr[1] + direction[i][1];

                if (dx > 0 && dx <= N && dy > 0 && dy <= M) {
                    if (!visited[dx][dy] && maze[dx][dy] == 1) {
                        q.add(new int[]{dx, dy});
                        maze[dx][dy] = maze[curArr[0]][curArr[1]] + 1;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maze = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];

        for (int i = 1; i < N+1; i++) {
            String[] arr = br.readLine().split("");
            for (int j = 1; j < M+1; j++)
                maze[i][j] = Integer.parseInt(arr[j-1]);
        }

        bfs(1, 1);
        System.out.println(maze[N][M]);
    }
}
