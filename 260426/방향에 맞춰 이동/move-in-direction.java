import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int curX = 0, curY = 0;

        for(int i=0; i<N; i++) {
            char direction = sc.next().charAt(0);
            int count = sc.nextInt();
            
            if(direction == 'W') { // 서
                curX-=count;
            }else if(direction == 'S') { // 남
                curY-=count;
            }else if(direction == 'N') { // 북
                curY+=count;
            }else { // E 동
                curX+=count;
            }
        }

        System.out.println(curX + " " + curY);
    }
}