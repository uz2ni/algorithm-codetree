import java.util.*;
public class Main {

    public static final int[] dx = {-1,1,0,0};
    public static final int[] dy = {0,0,-1,1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        
        // k=1 인 경우
        int[] result = {r-1,c-1};
        for(int i=0; i<k; i++) {
            int[] temp = bfs(grid,n,result[0],result[1]);
            if(temp == null) break;
            result[0] = temp[0];
            result[1] = temp[1];
        }
        System.out.println((result[0]+1) + " " + (result[1]+1));
    }

    public static int[] bfs(int[][] grid, int n, int x, int y) {
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> q = new ArrayDeque<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> {
            if(p1[0] != p2[0]) {
                return p2[0] - p1[0];
            }
            if(p1[1] != p2[1]) {
                return p1[1] - p2[1];
            }
            return p1[2] - p2[2];
        });

        q.offer(new int[]{x,y});
        visited[x][y] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for(int i=0; i<4; i++) {
                int nx = cur[0]+dx[i];
                int ny = cur[1]+dy[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if(visited[nx][ny] || (grid[nx][ny] >= grid[x][y])) continue;
                q.offer(new int[]{nx,ny});
                // System.out.println("pq 삽입: " + grid[nx][ny] + " " + nx + " " + ny);
                pq.offer(new int[]{grid[nx][ny],nx,ny});
                visited[nx][ny] = true;
            }
        }

        // 위치 이동
        int[] result = new int[2];
        if(!pq.isEmpty()) {
            int[] nxt = pq.poll();
            result[0] = nxt[1];
            result[1] = nxt[2];
        }else {
            result = null;
        }

        return result;
    }
}