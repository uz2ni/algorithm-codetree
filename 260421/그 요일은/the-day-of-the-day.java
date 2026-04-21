import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt(); // 2
        int d1 = sc.nextInt();
        int m2 = sc.nextInt(); // 5
        int d2 = sc.nextInt();
        String day = sc.next();

        String[] days = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};

        int diff = numOfDays(m2,d2) - numOfDays(m1,d1) + 1;
        
        int result = diff / 7;
        int remain = diff % 7;
        if(remain > 0) {
            for(int i=0; i<remain; i++) {
                if(days[i].equals(day)) {
                    result++;
                    break;
                }
            }
        }

        System.out.println(result);
        
    }

    // 1월 1일부터 주어진 일자 간 차이 계산
    public static int numOfDays(int m, int d) {
        int[] monthDates = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        int totalDays = 0;

        // 이전 월 일자 합산
        for(int i=1; i<m; i++) {
            totalDays += monthDates[i];
        }

        // 해당 월 일자 합
        totalDays += d;

        return totalDays;
    }
}