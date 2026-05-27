import java.util.*;
public class Main {
    public static final int[] dx = {-1,1,0,0};
    public static final int[] dy = {0,0,-1,1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int u = sc.nextInt();
        int d = sc.nextInt();
        int[][] grid = new int[n][n];
        List<int[]> gridList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                gridList.add(new int[]{i,j});
            }
        }

        int maxCnt = 0;
        List<List<int[]>> combList = comb(gridList, 0, k, new ArrayList<>());
        for(int i=0; i<combList.size(); i++) {
            maxCnt = Math.max(maxCnt, bfs(grid,combList.get(i),u,d));
        }

        System.out.println(maxCnt);
    }

    public static List<List<int[]>> comb(List<int[]> gridList, int start, int k, List<int[]> curList) {
        List<List<int[]>> list = new ArrayList<>();
        if(curList.size() == k) {
            list.add(new ArrayList<>(curList));
            return list;
        }

        for(int i=start; i<gridList.size(); i++) {
            int[] cur = gridList.get(i);
            curList.add(cur);
            list.addAll(comb(gridList, i+1, k, curList));
            curList.remove(curList.size()-1);
        }
        return list;
    }

    public static int bfs(int[][] grid, List<int[]> cList, int u, int d) {
        int n = grid.length;
        boolean[][] visited = new boolean[grid.length][grid.length];
        int cnt = 0;
        Queue<int[]> q = new ArrayDeque<>();
        for(int[] c : cList) {
            q.offer(c);
            visited[c[0]][c[1]] = true;
            cnt++;
        }

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            
            for(int i=0; i<4; i++) {
                int nx = cur[0]+dx[i];
                int ny = cur[1]+dy[i];
                if(nx<0 || nx>=n || ny<0 || ny>=n
                    || visited[nx][ny]) continue;

                int diff = Math.abs(grid[cur[0]][cur[1]]-grid[nx][ny]);
                if(diff<u || diff>d) continue;

                q.offer(new int[]{nx,ny});
                visited[nx][ny] = true;
                cnt++;
            }
        }
        return cnt;
    }
}