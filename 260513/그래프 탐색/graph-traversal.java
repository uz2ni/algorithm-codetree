import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] u = new int[m];
        int[] v = new int[m];
        for (int i = 0; i < m; i++) {
            u[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }
        // Please write your code here.

        // 간선 -> 연결리스트
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int i=0; i<u.length; i++) {
            graph.get(u[i]).add(v[i]);
            graph.get(v[i]).add(u[i]);
        }

        boolean[] visited = new boolean[n+1];
        int count = 0;
        // 1번부터 시작해서 도달할 수 있는 정점 수
        int result = dfs(graph, 1, visited, count);
        System.out.println(result);
        
    }

    public static int dfs(List<List<Integer>> graph, int start, boolean[] visited, int count) {

        visited[start] = true;       

        //System.out.println("dfs print: " + start);

        List<Integer> list = graph.get(start);
        for(int i=0; i<list.size(); i++) {
            int nxt = list.get(i);
            if(!visited[nxt]) {
                count = dfs(graph, nxt, visited, count+1);
            }
        }

        return count;
    }
}