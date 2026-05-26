import java.util.*;
public class Main {
    public static final int[] dx = {-1,1,0,0};
    public static final int[] dy = {0,0,-1,1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        int[][] startPoints = new int[k][2];
        for (int i = 0; i < k; i++) {
            startPoints[i][0] = sc.nextInt();
            startPoints[i][1] = sc.nextInt();
        }

        // 돌 위치 리스트 넣기
        List<int[]> stones = new ArrayList<>();
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1) {
                    stones.add(new int[]{i,j});
                }
            }
        }

        // m개 조합
        int maxLength = 0;
        List<List<int[]>> combList = comb(stones, m, 0, new ArrayList<>());
        for(List<int[]> c : combList) {
            for(int[] i : c) {
                //System.out.print("[" + i[0] + ", " + i[1] + "],");
                // 돌 제거
                grid[i[0]][i[1]] = 0;
            }
            //System.out.println();
            int length = bfs(grid, startPoints); // 시작점 모두 큐에 넣고, 이동 가능한 경로 수 리턴
            //System.out.println("length: " + length);
            maxLength = Math.max(maxLength, length);

            // 제거한 돌 리셋
            for(int[] i : c) {
                grid[i[0]][i[1]] = 1;
            }            
        }

        System.out.println(maxLength);
    }

    public static List<List<int[]>> comb(List<int[]> stones, int m, int start, List<int[]> curr) {
        List<List<int[]>> ans = new ArrayList<>();
        if(curr.size() == m) {
            ans.add(new ArrayList<>(curr));
            return ans;
        }
        
        for(int i=start; i<stones.size(); i++) {
            curr.add(stones.get(i));
            ans.addAll(comb(stones, m, i+1, curr));
            curr.remove(curr.size()-1);
        }

        return ans;
    }

    public static int bfs(int[][] grid, int[][] starts) {
        
        int n = grid.length;
        int length = 0;
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][n];
        for(int[] s : starts) {
            q.offer(new int[]{s[0]-1,s[1]-1});
            visited[s[0]-1][s[1]-1] = true;
            length++;
        }

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for(int i=0; i<4; i++) {
                int nx = cur[0]+dx[i];
                int ny = cur[1]+dy[i];

                // 사방 이동 가능 영역, 미방문, 돌아닌영역(0) 인 경우 방문
                if(nx<0 || nx>=n || ny<0 || ny>=n
                    || visited[nx][ny] || (grid[nx][ny]==1)) continue;
                
                q.offer(new int[]{nx,ny});
                visited[nx][ny] = true;
                length++;
            }

        }

        return length;
    }
}