import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // N, M 입력 (최대 1,000)
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        // 전체 시간은 최대 1,000 * 1,000 = 1,000,000
        // 정밀도와 안전성을 위해 long 배열 사용
        long[] posA = new long[1000001];
        long[] posB = new long[1000001];
        
        int timeA = 0;
        long sumA = 0;
        for(int i = 0; i < N; i++) {
            int v = sc.nextInt();
            int t = sc.nextInt();
            for(int j = 0; j < t; j++) {
                sumA += v;
                posA[timeA++] = sumA;
            }
        }
        
        int timeB = 0;
        long sumB = 0;
        for(int i = 0; i < M; i++) {
            int v = sc.nextInt();
            int t = sc.nextInt();
            for(int j = 0; j < t; j++) {
                sumB += v;
                posB[timeB++] = sumB;
            }
        }
        
        // 문제에서 A와 B가 이동한 총 시간은 동일하다고 주어지는 경우가 많습니다.
        int totalTime = timeA; 
        
        int cnt = 0;
        int history = -1; // 이전 상태 (0: 공동, 1: A선두, 2: B선두)
        
        for(int i = 0; i < totalTime; i++) {
            int cur;
            if (posA[i] > posB[i]) cur = 1;      // {A}
            else if (posA[i] < posB[i]) cur = 2; // {B}
            else cur = 0;                        // {A, B}
            
            if (i == 0) {
                // 시작 직후의 상태는 '변화'가 아니라 '초기 상태'로 설정
                history = cur;
            } else {
                // 이전 초의 명예의 전당 조합과 현재 초의 조합이 다르면 카운트
                if (history != cur) {
                    cnt++;
                    history = cur;
                }
            }
        }
        
        System.out.println(cnt);
    }
}