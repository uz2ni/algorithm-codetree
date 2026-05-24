import java.util.*;
public class Main {

    public final static int[] dx = {-1,1,0,0};
    public final static int[] dy = {0,0,-1,1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();

        int[][] graph = new int[n][n];

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        int bumpCnt = 0; // 터지는 블럭 수
        int maxCnt = 0; // 최대 블럭 수
        boolean[][] visited = new boolean[n][n];

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(!visited[i][j]) {
                    int blockCnt = dfs(graph, visited, n, i, j, graph[i][j]);
                    maxCnt = Math.max(maxCnt, blockCnt);
                    if(blockCnt >= 4) {
                        bumpCnt++;
                    }
                }
            }
        }

        System.out.println(bumpCnt + " " + maxCnt);
    }

    public static int dfs(int[][] graph, boolean[][] visited, int n, int x, int y, int k) {
        // basecase
        if(x < 0 || x >= n || y < 0 || y >= n || (graph[x][y] != k) || visited[x][y]) return 0;
        
        visited[x][y] = true;
        int result = 1;

        for(int i=0; i<4; i++) {
            result+=dfs(graph, visited, n, x+dx[i], y+dy[i], k);
        }

        return result;
    }
}