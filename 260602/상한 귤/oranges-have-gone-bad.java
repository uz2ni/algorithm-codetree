import java.util.*;

public class Main {

    public final static int[] dx = {-1,1,0,0};
    public final static int[] dy = {0,0,-1,1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] grid = new int[n][n];
        
        int[][] visited = new int[n][n];
        Queue<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                if(grid[i][j] == 0) visited[i][j] = -1;
                else if(grid[i][j] == 1) visited[i][j] = -2;
                else if(grid[i][j] == 2) {
                    visited[i][j] = 0;
                    q.offer(new int[]{i,j});
                }
            }
        }

        bfs(n, grid, visited, q);

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                System.out.print(visited[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void bfs(int n, int[][] grid, int[][] visited, Queue<int[]> q) {

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for(int i=0; i<4; i++) {
                int nx = cur[0]+dx[i];
                int ny = cur[1]+dy[i];
                if(nx<0 || nx>=n || ny<0 || ny>=n) continue;
                if(visited[nx][ny] == -2) {
                    visited[nx][ny] = visited[cur[0]][cur[1]] + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }
    
}