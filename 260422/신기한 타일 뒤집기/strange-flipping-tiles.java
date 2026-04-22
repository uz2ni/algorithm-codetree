import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        final int MAX_K = 100000;
        int[] a = new int[MAX_K * 2 + 1]; // 1 왼흰, 2 오검
        int w = 0, b = 0;
        int cur = MAX_K;

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            char d = sc.next().charAt(0);

            if(d == 'L') {
                while(x-- > 0) {
                    a[cur] = 1;
                    if(x > 0) cur--;
                }
            }else {
                while(x-- > 0) {
                    a[cur] = 2;
                    if(x > 0) cur++;
                }
            }
        }

        for(int i=0; i<a.length; i++) {
            if(a[i] == 1) w++;
            else if(a[i] == 2) b++;
        }

        System.out.println(w + " " + b);
    }
}