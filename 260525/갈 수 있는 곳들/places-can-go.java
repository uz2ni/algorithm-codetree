import java.util.*;
public class Main {

    public final static int[] dx = {-1,1,0,0};
    public final static int[] dy = {0,0,-1,1};
    public static int cnt = 0;

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[][] graph = new int[n][n];

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }        

        boolean[][] visited = new boolean[n][n];

        Queue<int[]> q = new ArrayDeque<>();

        // 큐에 시작점 넣기
        for(int i=0; i<k; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            q.offer(new int[]{x-1,y-1});
            visited[x-1][y-1] = true;
            cnt++;
        }

        bfs(graph, visited, q, n);

        System.out.println(cnt);

    }

    public static void bfs(int[][] graph, boolean[][] visited, Queue<int[]> q, int n) {
        
        while(!q.isEmpty()) {
            
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            for(int i=0; i<4; i++) {
                int nx = cx+dx[i];
                int ny = cy+dy[i];

                if(0 <= nx && nx < n && 0 <= ny && ny < n
                    && (graph[nx][ny] == 0) && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        cnt++;
                        q.offer(new int[]{nx,ny});
                }
            }
        }
    }
}