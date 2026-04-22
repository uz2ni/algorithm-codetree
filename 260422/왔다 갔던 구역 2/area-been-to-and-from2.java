import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int now = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            int x = sc.nextInt();
            char dr = sc.next().charAt(0);
            if(dr == 'R') {
                for(int j=now; j<now+x; j++) {
                    map.put(j, map.getOrDefault(j,0)+1);
                }
                now += x;
            }else {
                for(int j=now-x; j<now; j++) {
                    map.put(j, map.getOrDefault(j,0)+1);
                }
                now -= x;
            }
        }

        int result = 0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
                if(entry.getValue() >= 2) result++;
        }

        System.out.println(result);
    }
}