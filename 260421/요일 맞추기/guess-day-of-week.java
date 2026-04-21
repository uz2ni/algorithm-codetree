import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt(); // 2
        int d1 = sc.nextInt();
        int m2 = sc.nextInt(); // 5
        int d2 = sc.nextInt();

        int[] monthDates = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] days = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};

        // 차이 일자 계산
        int date;

        if(m1 == m2) { // 현재 월
            
            date = d2 - d1;

        }else if(d1 < d2) { // 현재 이후

            date = (monthDates[m1-1] - d1) + d2; // 시작+종료 일수 합산
            for(int i=m1; i<m2-1; i++) {
                date += monthDates[i]; // 중간월 일수 합산
            }

        }else { // 현재 이전

            date = (monthDates[m2-1] - d2) + d1; // 시작+종료 일수 합산
            for(int i=m2; i<m1-1; i++) {
                date += monthDates[i]; // 중간월 일수 합산
            }
            
            date = date * (-1);
        }

        // 요일 계산
        if(date < 0) {
            
            int idx = (days.length + date + 1) % 7;
            System.out.println(days[idx]);

        }else {
            
            int idx = (date+1) % 7;
            System.out.println(days[idx]);
        }


    }
}