import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int offset = 100;
        final int MAX_VALUE = (offset*2)+1;
        boolean[][] visited = new boolean[MAX_VALUE][MAX_VALUE];
        int result = 0;

        for(int i=0; i<N; i++) {
            int x1 = sc.nextInt()+offset;
            int y1 = sc.nextInt()+offset;
            int x2 = x1+8;
            int y2 = y1+8;

            for(int a=y1; a<y2; a++) {
                for(int b=x1; b<x2; b++) {
                    if(!visited[b][a]) {
                        visited[b][a] = true;
                        result++;
                    }
                }
            }
        }

        System.out.println(result);
    }
}