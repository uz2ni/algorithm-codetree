import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        float[] n = new float[1000000];
        float[] m = new float[1000000];
        
        float sum = 0;
        int time = 0;
        int hour = 0;
        for(int i=0; i<N; i++) {
            int v = sc.nextInt();
            int t = sc.nextInt();
            for(int j=0; j<t; j++) {
                sum += v;
                n[time] = sum;
                time++;
            }
            hour += t;
        }

        sum = 0;
        time = 0;
        for(int i=0; i<M; i++) {
            int v = sc.nextInt();
            int t = sc.nextInt();
            for(int j=0; j<t; j++) {
                sum += v;
                m[time] = sum;
                time++;
            }
        }

        int cnt = 0;
        int history = -1;
        for(int i=0; i<hour; i++) {
            int cur = -1;
            if(n[i] < m[i]) {
                cur = 1;
            }else if(n[i] > m[i]) {
                cur = 2;
            }else {
                cur = 0;
            }
            
            if(history != cur) {
                cnt++;
                history = cur;
            }
        }

        System.out.println(cnt);
    }
}