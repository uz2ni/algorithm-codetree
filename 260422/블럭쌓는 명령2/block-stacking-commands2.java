import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] blocks = new int[N];

        for (int i = 0; i < K; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();

            for(int j=A-1; j<=B-1; j++) {
                blocks[j]++;
            }
        }
        
        int max = 0;
        for(int i=0; i<blocks.length; i++) {
            max = Math.max(max, blocks[i]);
        }

        System.out.println(max);
    }
}