package graph;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    // 1 ~ 6
    static int[][] adj = new int[7][7];
    static boolean[] visited = new boolean[7];
    public static void main(String[] args) {
        adj[1][4] = 1;
        adj[4][1] = 1;
        adj[1][6] = 1;
        adj[6][1] = 1;
        adj[4][3] = 1;
        adj[3][4] = 1;
        adj[4][5] = 1;
        adj[5][4] = 1;
        adj[6][2] = 1;
        adj[2][6] = 1;

        bfs(1);
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList();
        q.offer(start);
        visited[start] = true;
        while (!q.isEmpty()) {
            int x = q.poll();
            System.out.println(x);
            for (int i = 0; i < adj.length; i++) {
                if (adj[x][i] == 1 && !visited[i]) {
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
