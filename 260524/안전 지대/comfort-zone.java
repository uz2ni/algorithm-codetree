import java.util.*;
public class Main {

    public final static int[] dx = {-1, 1, 0, 0};
    public final static int[] dy = {0, 0, -1, 1};
    public static int[] answer = new int[]{0, -1};

    public static void main(String[] args) {
        // K초과인 것만 안정 영역
        // visited, for>for dfs() 끝나면 안정 영역 cnt++
        // 영역 내부 and 사방 접근 시, K 초과인 경우만 방문
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] graph = new int[n][m];
        int k = 0; // 최대 k값 저장

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                graph[i][j] = sc.nextInt();
                k = Math.max(k, graph[i][j]);
            }
        }

        int[] result;
        for(int i=1; i<=k; i++) {
            result = bruteForce(i, graph, n, m);
            if(answer[1] < result[1]) {
                answer[0] = result[0];
                answer[1] = result[1];
            }
        }

        System.out.println(answer[0] + " " + answer[1]);
    }

    public static int[] bruteForce(int k, int[][] graph, int n, int m) {
        int cnt = 0;
        boolean[][] visited = new boolean[n][m];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(!visited[i][j] && graph[i][j] > k) { // 미방문 + k 초과
                    dfs(graph, visited, n, m, i, j, k);
                    cnt++;
                }
            }
        }

        return new int[]{k, cnt};
    }

    public static void dfs(int[][] graph, boolean[][] visited, int n, int m, int x, int y, int k) {
        // basecase
        if(x < 0 || x >= n || y < 0 || y >= m || (graph[x][y] <= k) || visited[x][y]) return;

        visited[x][y] = true;

        for(int i=0; i<4; i++) {
            dfs(graph, visited, n, m, x+dx[i], y+dy[i], k);
        }
    }

}