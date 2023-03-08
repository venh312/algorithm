package graph;

public class DFS {
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

        dfs(1);
    }

    static void dfs(int start) {
        visited[start] = true;
        System.out.println(start);
        for (int i = 0; i < adj.length; i++) {
            if (adj[start][i] == 1 && !visited[i])
                dfs(i);
        }
    }
}
