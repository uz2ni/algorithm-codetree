import java.util.*;
public class Main {

    public final static int[] dx = {-1,1,0,0};
    public final static int[] dy = {0,0,-1,1};

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] graph = new int[n][m];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                graph[i][j] = sc.nextInt();
            }
        }        

        boolean[][] visited = new boolean[n][m];

        dfs(graph, visited, n, m, 0, 0);

        int answer = (visited[n-1][m-1]) ? 1 : 0;
        System.out.println(answer);

    }

    public static void dfs(int[][] graph, boolean[][] visited, int n, int m, int x, int y) {
        if(x < 0 || x >= n || y < 0 || y >= m || (graph[x][y] == 0) || visited[x][y]) return;

        visited[x][y] = true;

        for(int i=0; i<4; i++) {
            dfs(graph, visited, n, m, x+dx[i], y+dy[i]);
        }
    }
}