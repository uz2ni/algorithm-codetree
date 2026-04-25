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
            int x2 = sc.nextInt()+offset;
            int y2 = sc.nextInt()+offset;

            int curX = x1;
            int curY = y1;

            while(curY < y2) {
                while(curX < x2) {
                    if(!visited[curX][curY]) {
                        visited[curX][curY] = true;
                        result++;
                    }     
                    curX++;               
                }
                curX = x1;
                curY++;
            }
        }

        System.out.println(result);
    }
}