import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt(); // 2
        int d1 = sc.nextInt();
        int m2 = sc.nextInt(); // 5
        int d2 = sc.nextInt();

        int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        // 시작 월 계산
        int start = monthDays[m1-1] - d1 + 1;
        
        // 종료 월 계산
        int end = d2;

        // 중간 월 계산
        int mid = 0;
        for(int i=m1; i<m2-1; i++) {
            mid += monthDays[i];
        }

        System.out.print(start+end+mid);

    }
}