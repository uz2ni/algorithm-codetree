import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        // 1. 오차 방지를 위해 long 배열 사용
        long[] n = new long[1000001];
        long[] m = new long[1000001];
        
        int timeN = 0;
        long sumN = 0;
        for(int i=0; i<N; i++) {
            int v = sc.nextInt();
            int t = sc.nextInt();
            for(int j=0; j<t; j++) {
                sumN += v;
                n[timeN++] = sumN;
            }
        }

        int timeM = 0;
        long sumM = 0;
        for(int i=0; i<M; i++) {
            int v = sc.nextInt();
            int t = sc.nextInt();
            for(int j=0; j<t; j++) {
                sumM += v;
                m[timeM++] = sumM;
            }
        }

        // 두 사람 중 더 긴 시간을 기준으로 함 (보통은 같게 주어짐)
        int totalHour = Math.max(timeN, timeM);
        
        int cnt = 0;
        int history = -1;

        for(int i=0; i < totalHour; i++) {
            int cur;
            if(n[i] > m[i])      cur = 1; // A가 선두
            else if(n[i] < m[i]) cur = 2; // B가 선두
            else                 cur = 0; // 공동 선두

            if(i == 0) {
                history = cur;
            } else if(history != cur) {
                cnt++;
                history = cur;
            }
        }

        System.out.println(cnt);
    }
}