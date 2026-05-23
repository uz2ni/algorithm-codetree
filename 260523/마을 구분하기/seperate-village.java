import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] graph = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        boolean[][] visited = new boolean[n][n];
        Queue<Integer> pq = new PriorityQueue<>();
        int townCnt = 0;

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(!visited[i][j] && graph[i][j] == 1) { // 방문 안했다면
                    int peopleCnt = dfs(graph, visited, i, j, n);
                    pq.add(peopleCnt);
                    townCnt++;
                }
            }
        }

        System.out.println(townCnt);
        while(!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }

    public static int dfs(int[][] graph, boolean[][] visited, int x, int y, int n) {

        if(x < 0 || x >= n || y < 0 || y >= n || visited[x][y] || graph[x][y] == 0) return 0;
        
        visited[x][y] = true;
        int result = 1;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for(int i=0; i<4; i++) {
            int nx = dx[i]+x;
            int ny = dy[i]+y;
            result = result + dfs(graph, visited, nx, ny, n);
        }
        
        return result;
    }
}