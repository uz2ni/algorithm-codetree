import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();
        // Please write your code here.

        int[][] visited = new int[n][m];
        boolean result = dfs(grid, 0, 0, n, m, visited);
        System.out.println(result ? "1" : "0");
        
        
    }

    public static boolean dfs(int[][] grid, int x, int y, int n, int m, int[][] visited) {

        // basecase
        if(x==(n-1) && y==(m-1)) {
            return true;
        }

        visited[x][y] = 1;

        int[] dc = {0, 1}; // x,n 방향
        int[] dr = {1, 0}; // y,m 방향
        
        // recursion
        for(int i=0; i<2; i++) {
            int nc = x+dc[i];
            int nr = y+dr[i];
            
            // 좌표 이내, grid 값 1, visited 아님
            if(0<=nc && nc<n && 0<=nr && nr<m) {
                if(grid[nc][nr]==1 && (visited[nc][nr]==0)) {
                    if(dfs(grid, nc, nr, n, m, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}