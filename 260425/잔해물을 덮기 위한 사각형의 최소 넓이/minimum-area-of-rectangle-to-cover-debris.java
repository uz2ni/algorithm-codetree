import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int offset = 1000;
        final int MAX_VALUE = (1000*2)+1;
        boolean[][] visited = new boolean[MAX_VALUE][MAX_VALUE];        

        int ax1 = sc.nextInt()+offset;
        int ay1 = sc.nextInt()+offset;
        int ax2 = sc.nextInt()+offset;
        int ay2 = sc.nextInt()+offset;

        int bx1 = sc.nextInt()+offset;
        int by1 = sc.nextInt()+offset;
        int bx2 = sc.nextInt()+offset;
        int by2 = sc.nextInt()+offset;        


        // A 방문 처리
        for(int i=ay1; i<ay2; i++) {
            for(int j=ax1; j<ax2; j++) {
                if(!visited[j][i]) {
                    visited[j][i] = true;
                }
            }
        }

        // B 방문 취소 처리
        for(int i=by1; i<by2; i++) {
            for(int j=bx1; j<bx2; j++) {
                if(visited[j][i]) {
                    visited[j][i] = false;
                }
            }
        }

        // visited true 표시된 최소 최대 점 구해서 넓이 구하기
        int maxX=0, maxY=0, minX = MAX_VALUE-1, minY = MAX_VALUE-1;
        boolean visitedCheck = false;
        
        for(int i=0; i<visited.length; i++) {
            for(int j=0; j<visited[0].length; j++) {
                if(visited[j][i]) {
                    visitedCheck = true;
                    maxX = Math.max(maxX, j);
                    minX = Math.min(minX, j);
                    maxY = Math.max(maxY, i);
                    minY = Math.min(minY, i);
                }
            }
        }

        System.out.println(visitedCheck ? (maxX+1-minX)*(maxY+1-minY) : 0);
    }
}