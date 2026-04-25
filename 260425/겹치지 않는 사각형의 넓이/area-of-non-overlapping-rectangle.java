import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int ax1 = sc.nextInt();
        int ay1 = sc.nextInt();
        int ax2 = sc.nextInt();
        int ay2 = sc.nextInt();

        int bx1 = sc.nextInt();
        int by1 = sc.nextInt();
        int bx2 = sc.nextInt();
        int by2 = sc.nextInt();

        int mx1 = sc.nextInt();
        int my1 = sc.nextInt();
        int mx2 = sc.nextInt();
        int my2 = sc.nextInt();

        int offset = 1000;
        final int MAX_VALUE = (offset*2)+1;
        boolean[][] visited = new boolean[MAX_VALUE][MAX_VALUE];
        int result = 0;

        // A, B 좌표 visited true
        for(int i=ay1; i<ay2; i++) {
            for(int j=ax1; j<ax2; j++) {
                if(!visited[j][i]) {
                    visited[j][i] = true;
                    result++;
                }
            }
        }
        for(int i=by1; i<by2; i++) {
            for(int j=bx1; j<bx2; j++) {
                if(!visited[j][i]) {
                    visited[j][i] = true;
                    result++;
                }
            }
        }
    
        // visited에서 M 좌표 false
        for(int i=my1; i<my2; i++) {
            for(int j=mx1; j<mx2; j++) {
                if(visited[j][i]) {
                    visited[j][i] = false;
                    result--;
                }
            }
        }

        System.out.println(result);        
    }
}