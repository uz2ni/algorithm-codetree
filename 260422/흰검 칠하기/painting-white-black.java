import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        final int MAX_K = 100000;
        int[] a = new int[2 * MAX_K +1];
        int[] cntB = new int[2 * MAX_K +1];
        int[] cntW = new int[2 * MAX_K +1];
        int b=0, w=0, g=0;
        int cur = MAX_K;

        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            char d = sc.next().charAt(0);

            if(d == 'L') { // 흰색
                while(x-- > 0) {
                    a[cur] = 1;
                    cntW[cur]++;
                    if(x > 0) cur--; // 마지막 칸 칠한 후 제자리 멈춰있기 위함
                }
            }else {
                while(x-- > 0) {
                    a[cur] = 2;
                    cntB[cur]++;
                    if(x > 0) cur++;
                }
            }
        }

        for(int i=0; i<a.length; i++) {
            if(cntB[i]>=2 && cntW[i]>=2) g++;
            else {
                if(a[i] == 1) { // L 흰색
                    w++;
                }else if(a[i] == 2) { // R 블랙
                    b++;
                }
            }
        }

        System.out.println(w + " " + b + " " + g);
    }
}