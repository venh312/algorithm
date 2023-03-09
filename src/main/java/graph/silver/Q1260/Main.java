package graph.silver.Q1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, v;
    static int[][] adj;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        visit = new boolean[n+1];
        adj = new int[n+1][n+1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            adj[x][y] = 1;
            adj[y][x] = 1;
        }
        dfs(v);
        System.out.println();
        visit = new boolean[n+1];
        bfs(v);
    }

    static void dfs(int start) {
        visit[start] = true;
        System.out.print(start + " ");
        for (int i = 1; i < adj.length; i++)
            if (adj[start][i] == 1 && !visit[i])
                dfs(i);
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visit[start] = true;
        while (!q.isEmpty()) {
            int x = q.poll();
            System.out.print(x + " ");
            for (int i = 1; i < adj.length; i++) {
                if (adj[x][i] == 1 && !visit[i]) {
                    q.offer(i);
                    visit[i] = true;
                }
            }
        }
    }
}
