import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        List<Weather> list = new ArrayList<>();
        String date, day, status;

        for(int i=0; i<n; i++) {
            date = sc.next();
            day = sc.next();
            status = sc.next();
            if(status.equals("Rain")) {
                list.add(new Weather(date, day, status));
            }
        }
        
        list.sort((w1, w2) -> w1.date.compareTo(w2.date));
        
        System.out.println(list.get(0).date + " " + list.get(0).day + " " + list.get(0).status);
        
    }

    public static class Weather {
        String date;
        String day;
        String status;

        public Weather(String date, String day, String status) {
            this.date = date;
            this.day = day;
            this.status = status;
        }
    }
}