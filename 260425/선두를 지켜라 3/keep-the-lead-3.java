import java.util.*;

public class Main {
    public static final int MAX_T = 1000000;
    public static long[] posA = new long[MAX_T + 1];
    public static long[] posB = new long[MAX_T + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        // A 이동 기록
        int timeA = 1;
        for(int i = 0; i < n; i++) {
            int v = sc.nextInt();
            int t = sc.nextInt();
            while(t-- > 0) {
                posA[timeA] = posA[timeA - 1] + v;
                timeA++;
            }
        }

        // B 이동 기록
        int timeB = 1;
        for(int i = 0; i < m; i++) {
            int v = sc.nextInt();
            int t = sc.nextInt();
            while(t-- > 0) {
                posB[timeB] = posB[timeB - 1] + v;
                timeB++;
            }
        }

        int ans = 0;
        int leader = 0; // 0: 시작 전, 1: A, 2: B, 3: 공동(A,B)

        // 1초부터 마지막 시간까지 확인
        for(int i = 1; i < timeA; i++) {
            int curLeader;
            if(posA[i] > posB[i]) curLeader = 1;
            else if(posB[i] > posA[i]) curLeader = 2;
            else curLeader = 3;

            // 이전 상태(leader)와 현재 상태(curLeader)가 다르면 무조건 카운트
            // 1초에 처음 상태가 결정될 때도 leader(0)와 다르므로 ans가 1이 됨
            if(curLeader != leader) {
                ans++;
                leader = curLeader;
            }
        }

        System.out.println(ans);
    }
}